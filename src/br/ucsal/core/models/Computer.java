package br.ucsal.core.models;

import java.util.Map;
import java.util.HashMap;

import br.ucsal.core.interfaces.IComputer;

public class Computer implements IComputer{
    private int code;
    private String model;
    private String cpu;
    private String memory;
    private String hd;
    private String ip;

    private Map<String, Software> softwares = new HashMap<>();

    @Override
    public String installedSoftwares(){
        return null;
    }

    @Override
    public void install(Software sw){

    }

    @Override
    public void uninstall(String swName){
        
    }
}