package com.crystalmath.WuhanMetro.subway;

import android.util.Pair;

import java.util.Arrays;
import java.util.List;

public class TransferStation {
    public List<SubwayStation> stations;

    private TransferStation(){
    }

    public static TransferStation construct(List<SubwayStation> stations){
        TransferStation transferStation = new TransferStation();
        transferStation.stations = stations;
        for (int i = 0; i < stations.size(); i++){
            stations.get(i).transfer = transferStation;
        }
        return transferStation;
    }
}
