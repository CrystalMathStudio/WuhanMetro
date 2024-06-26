package com.crystalmath.WuhanMetro.frag;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.crystalmath.WuhanMetro.R;
import com.crystalmath.WuhanMetro.subway.SubwayInfo;
import com.crystalmath.WuhanMetro.subway.SubwayLine;
import com.crystalmath.WuhanMetro.subway.SubwayStation;
import com.crystalmath.WuhanMetro.util.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaiduMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaiduMapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapView mapView;
    public BaiduMap baiduMap;
    private LocationClient locationClient;

    public BaiduMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BaiduMapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BaiduMapFragment newInstance(String param1, String param2) {
        BaiduMapFragment fragment = new BaiduMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();

        mapView.onCreate(view.getContext(), savedInstanceState);

        try {
            LocationClient.setAgreePrivacy(true);
            locationClient = new LocationClient(getContext());

            LocationClientOption option = new LocationClientOption();
            option.setOpenGnss(true);
            option.setCoorType("bd09ll"); // 设置坐标类型
            option.setScanSpan(1000);

            locationClient.setLocOption(option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MapStatusUpdate updateGeo = MapStatusUpdateFactory.newLatLng(new LatLng(30.59, 114.30));
        baiduMap.setMapStatus(updateGeo);

        List<OverlayOptions> options = new ArrayList<>();
        Bitmap subwayBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.subway2), 48, 48, true);
        for (SubwayLine line : SubwayInfo.lineMap.values()){
            int color = getResources().getColor(line.color);

            Bitmap lineBitmap = Graphics.makeTintBitmap(subwayBitmap, color);
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(lineBitmap);

            List<LatLng> linePoints = new ArrayList<>();

            for (SubwayStation station : line.stations){
                linePoints.add(station.latLng);
                OverlayOptions option = new MarkerOptions()
                        .position(station.latLng)
                        .icon(bitmapDescriptor)
                        .perspective(true)
                        .title(station.name)
                        .anchor(0.5f, 0.5f);
                options.add(option);
            }

            OverlayOptions polyline = new PolylineOptions()
                    .width(5)
                    .color(color)
                    .points(linePoints);
            options.add(polyline);
        }
        baiduMap.addOverlays(options);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_baidu_map, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        locationClient.stop();
        baiduMap.setMyLocationEnabled(false);
        mapView.onDestroy();
        mapView = null;
        super.onDestroy();
    }
}