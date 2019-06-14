package br.ucsal.core.models;

import java.util.Map;
import java.util.TreeMap;

import br.ucsal.core.exceptions.*;
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

    public Computer(String code, String ip){
        this(code, null, null, null, null, ip);
    }

    public Computer(String code, String model, String cpu, String memory, String hd, String ip){
        this.code = code;
        this.model = model;
        this.cpu = cpu;
        this.memory = memory;
        this.hd = hd;
        this.ip = ip;
    }

    // Getter

    public String getCode(){
        return this.code;
    }

    public String getIp(){
        return this.ip;
    }

    public String infos(){
        return null;
    }

    // Interfaces Methods

    @Override
    public Software[] installedSoftwares(){
        return this.softwares.values().toArray(new Software[0]);
    }

    @Override
    public void install(Software sw) throws AlreadyExistsException{
        if(!this.softwares.containsKey(sw.getName())){
            this.softwares.put(sw.getName(), sw);
        }else{
            throw new AlreadyExistsException(String.format("O software '%s' já se encontra instalado.", sw.getName()));
        }
    }

    @Override
    public void uninstall(String swName) throws NotFoundException{
        if(this.softwares.containsKey(swName)){
            this.softwares.remove(swName);
        }else{
            throw new NotFoundException(String.format("O software '%s' não está instalado.", swName));
        }
    }

    // Object Methods
    @Override
    public String toString(){
        return String.format("%s : %s", this.code, this.ip);
    }
}