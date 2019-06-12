package br.ucsal.core.models;

import java.util.Map;

import java.util.HashMap;

import br.ucsal.core.interfaces.ILaboratory;

public class Laboratory implements ILaboratory{
    private String initial;
    private String name;

    private Map<String, Computer> computers = new HashMap<>();

    public Laboratory(String initial, String name){
        this.initial = initial;
        this.name = name;
    }

    // Getters
    public String getInitial(){
        return this.initial;
    }

    public String getName(){
        return this.name;
    }

    // Interfaces Methods
    @Override
    public void add(Computer pc){
        String code = pc.getCode();
        if(!this.computers.containsKey(code)){
            this.computers.put(code, pc);
        }
    }

    @Override
    public void remove(String pcCode){
        if(this.computers.containsKey(pcCode)){
            this.computers.remove(pcCode);
        }
    }

    @Override
    public Computer[] avaiableComputers(){
        return (Computer[])this.computers.values().toArray();
    }
}