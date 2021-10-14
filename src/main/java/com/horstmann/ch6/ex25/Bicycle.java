package com.horstmann.ch6.ex25;

import java.util.ArrayList;
import java.util.List;

public class Bicycle {
    public List<Integer> getWheelsDiameters(List<String> defaultDiameters){
        System.out.println(defaultDiameters);
        List<Integer> wheelDiameters = new ArrayList<>();
        wheelDiameters.add(26);
        wheelDiameters.add(29);
        return wheelDiameters;
    }
}
