package com.example.demo.domain.dto;
import com.example.demo.domain.Enum.ETipoDeck;
import com.example.demo.domain.Enum.MetaDeck;


public class deckRequestDTO {
    private Long id;
    private String nome;
    private String descricao;
    private ETipoDeck tipo;
    private Double precoCusto;
    private int quantidadeCartas;
    private MetaDeck meta;
    
    public MetaDeck getMeta() {
        return meta;
    }
    public void setMeta(MetaDeck meta) {
        this.meta = meta;
    }
    public int getQuantidadeCartas() {
        return quantidadeCartas;
    }
    public void setQuantidadeCartas(int quantidadeCartas) {
        this.quantidadeCartas = quantidadeCartas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ETipoDeck getTipo() {
        return tipo;
    }
    public void setTipo(ETipoDeck tipo) {
        this.tipo = tipo;
    }
    public Double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    
}
