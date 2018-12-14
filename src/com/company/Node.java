package com.company;

import java.util.Optional;

public class Node implements Comparable<Node> {
    private final String name;
    private final double average;

    public Node(String name, double average){
        this.name = name;
        this.average = average;
    }

    public String getName(){
        return name;
    }

    public double getAverage(){
        return average;
    }

    @Override
    public int compareTo(Node o) {
        return Optional.ofNullable(name)
                .map(n -> n.compareTo(o.name))
                .orElse(-1);
    }
}