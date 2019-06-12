package br.ucsal.core.models;

import java.util.Map;
import java.util.HashMap;

public class Laboratory {
    private String initial;
    private String name;

    private Map<String, Computer> computers = new HashMap<>();

    public Laboratory(String initial, String name){
        this.initial = initial;
        this.name = name;
    }

    public String getInitial(){
        return this.initial;
    }

    public String getName(){
        return this.name;
    }
}