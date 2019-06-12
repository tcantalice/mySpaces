package br.ucsal.core.models;

import java.util.Map;
import java.util.HashMap;

import br.ucsal.core.exceptions.*;
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
    public Computer[] avaiableComputers(){
        return (Computer[])this.computers.values().toArray();
    }

    @Override
    public void add(Computer pc) throws AlreadyExistsException{
        String code = pc.getCode();
        if(!this.computers.containsKey(code)){
            this.computers.put(code, pc);
        }else{
            throw new AlreadyExistsException(String.format("%s já existe no laboratório %s", code, this.initial));
        }
    }

    @Override
    public void remove(String pcCode) throws NotFoundException{
        if(this.computers.containsKey(pcCode)){
            this.computers.remove(pcCode);
        }else{
            throw new NotFoundException(String.format("%s não encontrado no laboratório %s", pcCode, this.initial));
        }
    }

    @Override
    public Computer getComputer(String pcCode) throws NotFoundException{
        if(this.computers.containsKey(pcCode)){
            return this.computers.get(pcCode);
        }
        throw new NotFoundException(String.format("%s não encontrado no laboratório %s", pcCode, this.initial));
    }

}