package com.example.application.views.structures;

import com.example.application.views.entity.Center;

import java.util.Random;

public class Graph {
    private Vertex[] vertices;

    private Center[] centers;

    public Graph() {}

    public Graph(int a) {
        vertices = new Vertex[a];

        for (int i = 0; i < a; i++) {
            vertices[i] =new Vertex(i);
        }
    }

    public Vertex[] getVertices() {return vertices;}

    public Center[] getCenters() {return centers;}
    public void setCenters(Center[] centers) {this.centers = centers;}
    public void showCenters(){
        for (Center center : centers) {
            System.out.println(center.getName());
        }
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        vertices[start].addEdge(edge);
    }

    public Graph randomGraph(){
        Random random = new Random();
        int graphSize = random.nextInt(20);
        while (graphSize < 10) {
            graphSize = random.nextInt(20);
        }

        Graph map = new Graph(graphSize);

        for (int i = 0; i < (graphSize * 3); i++) {
            int start = random.nextInt(graphSize);
            int end = random.nextInt(graphSize);
            int weight = random.nextInt(10);

            map.addEdge(start, end, weight);
        }
        return map;
    }

    public void matchCenters() {
        setCenters(new Center[vertices.length]);

        for (int i = 0; i < vertices.length; i++) {
            centers[i] = new Center("Ciudad " + i);
        }
    }

    static class Vertex {
        int id;
        Center center;
        LinkList adjacency = new LinkList();

        public Vertex(int id) {
            this.id = id;
        }

        public void addEdge(Edge edge) {
            adjacency.add(edge);
        }

        public Center getCenter() {return center;}
        public LinkList getAdjacency() {return adjacency;}
        public int getId() {return id;}
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
