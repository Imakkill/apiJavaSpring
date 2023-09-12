package com.example.demo.domain.Enum;

public enum ETipoDeck {
    ATAQUE("Prato Quente!"),
    CONTROLE("Pratos frios e saladas!");

    private String valor;

    private ETipoDeck(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }   
}
