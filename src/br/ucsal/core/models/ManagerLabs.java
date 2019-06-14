package br.ucsal.core.models;

import java.util.Map;
import java.util.TreeMap;

import br.ucsal.core.interfaces.IManagerSpaces;
import br.ucsal.core.exceptions.*;

public class ManagerLabs implements IManagerSpaces<Laboratory>{
    
    private static ManagerLabs manager;
    private Map<String, Laboratory> laboratories = new TreeMap<>();

    private ManagerLabs(){}

    public static ManagerLabs getInstance(){
        if(manager == null)
            manager = new ManagerLabs();
        return manager;
    }

    public void add(String initial, String name) throws AlreadyExistsException{
        this.add(new Laboratory(initial, name));
    }

    @Override
    public void add(Laboratory space) throws AlreadyExistsException{
        if(!this.laboratories.containsKey(space.getInitial())){
            this.laboratories.put(space.getInitial(), space);
        }else{
            throw new AlreadyExistsException(String.format("O código '%s' já está atribuído a outro laboratório", space.getInitial()));
        }
    }

    @Override
    public Laboratory enterSpace(Object k) throws NotFoundException {
        String key = (String) k;
        if(this.laboratories.containsKey(key)){
            return laboratories.get(key);
        }
        throw new NotFoundException(String.format("Laboratório '%s' não encontrado", key));
    }

    @Override
    public void remove(Object k) throws NotFoundException {
        String key = (String) k;
        if(this.laboratories.containsKey(key)){
            this.laboratories.remove(key);
        }else{
            throw new NotFoundException(String.format("Laboratório '%s' não encontrado", key));
        }
    }

    @Override
    public Laboratory[] avaiableSpaces(){
        return (Laboratory[])this.laboratories.values().toArray();
    }
}