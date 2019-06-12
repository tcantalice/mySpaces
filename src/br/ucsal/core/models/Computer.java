package br.ucsal.core.models;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

import br.ucsal.core.interfaces.IComputer;

public class Computer implements IComputer{
    private String code;
    private String model;
    private String cpu;
    private String memory;
    private String hd;
    private String ip;

    private Map<String, Software> softwares = new TreeMap<>();

    // Constructors 

    public Computer(String code, String model, String cpu, String memory, String hd, String ip){
        this.code = code;
        this.model = model;
        this.cpu = cpu;
        this.memory = memory;
        this.hd = hd;
        this.ip = ip;
    }

    // Getter & Setters

    public String getCode(){
        return this.code;
    }

    public String getModel(){
        return this.model;
    }

    public String getIp(){
        return this.ip;
    }

    // Interfaces Methods

    @Override
    public Software[] installedSoftwares(){
        return (Software[])this.softwares.values().toArray();
    }

    @Override
    public void install(Software sw){
        if(!this.softwares.containsKey(sw.getName())){
            this.softwares.put(sw.getName(), sw);
        }
    }

    @Override
    public void uninstall(String swName){
        if(this.softwares.containsKey(swName)){
            this.softwares.remove(swName);
        }
    }

    // Object Methods
    @Override
    public String toString(){
        return String.format("%s : %s", this.code, this.ip);
    }
}