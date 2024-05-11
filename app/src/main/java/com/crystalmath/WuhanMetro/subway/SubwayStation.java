package com.crystalmath.WuhanMetro.subway;

import com.baidu.mapapi.model.LatLng;

public class SubwayStation {
    public String name;
    public String sid;
    public int lineId;
    public int stationId;
    public TransferStation transfer;
    public LatLng latLng;

    public SubwayStation(String name, String sid, double lat, double lng){
        this.name = name;
        this.sid = sid;
        this.latLng = new LatLng(lat, lng);
        this.transfer = null;
    }
}
