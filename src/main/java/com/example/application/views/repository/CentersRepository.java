package com.example.application.views.repository;

import com.example.application.views.entity.Center;
import com.example.application.views.structures.Graph;

import java.util.LinkedList;

public class CentersRepository {
    Graph graph = new Graph();
    Graph map = graph.randomGraph();
    LinkedList<Center> centerList = new LinkedList<>();

    public void CentersRepositoryInitialize() {
        map.matchCenters();

        for(int i = 0; i < (map.getCenters().length); i++){
            if (map.getCenters()[i].isDistributes()) {
                centerList.add(map.getCenters()[i]);
            }
        }
    }

    public LinkedList<Center> getCenterList() {
        return centerList;
    }

    public void setCenterList(LinkedList<Center> centerList) {
        this.centerList = centerList;
    }
}
