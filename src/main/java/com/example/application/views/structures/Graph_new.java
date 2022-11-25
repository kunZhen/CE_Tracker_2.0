package com.example.application.views.structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import com.example.application.views.entity.Center;

public class Graph_new {

    List<List<Node>> adjList = new ArrayList<>();

    public Graph_new(){}

    public Graph_new(List<Edge1> edges) {

        for (int i = 0; i < edges.size(); i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (Edge1 edge: edges) {
            if (edge.start < adjList.size()) {
                adjList.get(edge.start).add(new Node(edge.end, edge.weight));
            }
        }
    }

    public List<Edge1> randomizeGraph() {
        Random random = new Random();
        int edgeAmount = random.nextInt(10, 20);
        List<Edge1> edges = new LinkedList<>();

        while (edgeAmount > 0) {
            int start = random.nextInt(edgeAmount);
            int end = random.nextInt(edgeAmount);
            int weight = random.nextInt(1, 10);
            if (start != end){
                Edge1 edge1 = new Edge1(start, end, weight);
                edges.add(edge1);
            }
            edgeAmount--;
        }
        return edges;
    }

    public void printG(Graph_new graph) {
        int srcV = 0;
        int listSize = graph.adjList.size();
        while (srcV < listSize) {
            for (Node edge : graph.adjList.get(srcV)) {
                System.out.println("V" + srcV + "("+ graph.adjList.get(srcV).get(0).getCenter().isDistributes() +")" + " ==> " + "V" + edge.id + "("+ edge.getCenter().isDistributes() +")" + " " + "weight: " + edge.weight);
            }
            System.out.println();
            srcV++;
        }
    }

    public void paths(int origin, int end) {
        boolean[] isVisited = new boolean[adjList.size()];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(origin);
        pathsRec(origin, end, isVisited, pathList);

    }

    private void pathsRec(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }
        isVisited[u] = true;
        for (Node i : adjList.get(u)) {
            if (!isVisited[i.id]) {
                localPathList.add(i.id);
                pathsRec(i.id, d, isVisited, localPathList);
                localPathList.remove(i.id);
            }
        }
        isVisited[u] = false;
    }

    static class Node {
        int id;
        int weight;
        Center center;
        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
            this.center = new Center("Centro " + id);
        }
        public Center getCenter() {return center;}
        public int getId() {return id;}
    }
}

class Edge1 {
    int start;
    int end;
    int weight;
    public Edge1(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
