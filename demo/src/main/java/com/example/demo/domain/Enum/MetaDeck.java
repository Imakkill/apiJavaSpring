package com.example.demo.domain.Enum;

public enum MetaDeck {
    SIM("Deck Meta!"),
    NAO("Deck For fun");

    private String meta;

    private MetaDeck(String meta){
        this.meta = meta;
    }

    public String getValor(){
        return this.meta;
    }   
}
