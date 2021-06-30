package com.horstmann.ch7.ex10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализуйте алгоритм Дейкстры для поиска кратчайших путей между городами, связанными сетью автомобильных дорог.
 * (Описание этого алгоритма можно найти в популярной литературе по алгоритмам или в соответствующей статье Википедии.)
 * Воспользуйтесь вспомогательным классом Neighbor для хранения названия соседнего города и расстояния до него.
 * Представьте полученный граф в виде преобразования названий городов в множества соседних городов.
 * Воспользуйтесь в данном алгоритме классом PriorityQueue<Neighbor>.
 */
public class Main {
    private static Graph graph = new Graph();
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Chelyabinsk");
        graph.addVertex("Samara");
        graph.addVertex("Saratov");
        graph.addVertex("Kazan");
        graph.addVertex("Moscow");
        graph.addEdge("Chelyabinsk", "Samara", 800);
        graph.addEdge("Kazan", "Samara", 300);
        graph.addEdge("Kazan", "Chelyabinsk", 900);
        graph.addEdge("Kazan", "Moscow", 800);
        graph.addEdge("Samara", "Moscow", 1000);
        graph.addEdge("Saratov", "Moscow", 1200);
        graph.addEdge("Saratov", "Chelyabinsk", 1200);
        graph.addEdge("Saratov", "Samara", 400);
        Map<String, Set<Neighbor>> citiesAndDistances = deixtra();

    }

    public static Map<String, Set<Neighbor>> deixtra(){
        Map<String, Set<Neighbor>> analyzedGraph = new HashMap<>();
        for (String city : graph.getAdjVertices().keySet()){
            analyzedGraph.putAll(analyzeCity(city));
        }
        return analyzedGraph;
    }

    private static Map<String, Set<Neighbor>> analyzeCity(String city) {
        Map<String, Set<Neighbor>> distancesToAllCitiesFromCity = new TreeMap<>();
        Set<Neighbor> distancesToAllCities = new HashSet<>();
        distancesToAllCities.add(new Neighbor(city, 0));

        //0
        Queue<Neighbor> neighboursOfTheCity = new PriorityQueue<>(graph.getAdjVertices().get(city));

        while (neighboursOfTheCity.size() > 0){
            distancesToAllCities.add(neighboursOfTheCity.remove());
        }


        distancesToAllCitiesFromCity.put(city, distancesToAllCities);
        return distancesToAllCitiesFromCity;

    }

}
