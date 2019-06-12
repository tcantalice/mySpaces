package br.ucsal.core.models;

public enum Licenses {
    FREE("Gratuito"), PAID("Pago");

    private String tag;

    Licenses(String tag){
        this.tag = tag;
    }

    public String getTag(){
        return this.tag;
    }
}