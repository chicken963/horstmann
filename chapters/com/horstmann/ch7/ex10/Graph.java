package com.horstmann.ch7.ex10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<Neighbor>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public Map<String, List<Neighbor>> getAdjVertices() {
        return adjVertices;
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }

    void removeVertex(String label) {
        Neighbor v = new Neighbor(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(label);
    }

    void addEdge(String label1, String label2, Integer distance) {
        Neighbor v1 = new Neighbor(label1, distance);
        Neighbor v2 = new Neighbor(label2, distance);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Neighbor v1 = new Neighbor(label1);
        Neighbor v2 = new Neighbor(label2);
        List<Neighbor> eV1 = adjVertices.get(v1);
        List<Neighbor> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }
}
