package com.crystalmath.WuhanMetro.subway;

import java.util.ArrayList;
import java.util.List;

public class SubwayLine {
    public int id;
    public List<SubwayStation> stations;

    public SubwayLine(int id){
        this.id = id;
        stations = new ArrayList<>();
    }

    public void add(SubwayStation station){
        station.lineId = id;
        station.stationId = this.stations.size();
        this.stations.add(station);
    }
}
