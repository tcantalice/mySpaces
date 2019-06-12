package br.ucsal.core.models;

public class Software {
    private String name;
    private Licenses license;

    // Constructors
    public Software(String name, Licenses license){
        this.name = name;
        this.license = license;
    }

    // Getters
    public String getName(){
        return this.name;
    }

    public Licenses getLicense(){
        return this.license;
    }

    // Object Methods
    @Override
    public String toString(){
        return String.format("%s : %s", this.name, this.license.getTag());
    }
}