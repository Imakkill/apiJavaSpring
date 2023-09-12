package com.example.demo.domain.model; 
import com.example.demo.domain.Enum.ETipoDeck;
import com.example.demo.domain.Enum.MetaDeck;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

@Entity
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPratos")
    private Long id;
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    @Column(nullable = false)
    private Double precoCusto;
    private int quantidadeCartas;
    public int getQuantidadeCartas() {
        return quantidadeCartas;
    }
    public void setQuantidadeCartas(int quantidadeCartas) {
        this.quantidadeCartas = quantidadeCartas;
    }
    @Enumerated(EnumType.STRING)
    private ETipoDeck tipo;

    @Enumerated(EnumType.STRING)
    private MetaDeck meta;

    public MetaDeck getMeta() {
        return meta;
    }
    public void setMeta(MetaDeck meta) {
        this.meta = meta;
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }
    

    public ETipoDeck getTipo() {
        return tipo;
    }
    public void setTipo(ETipoDeck tipo) {
        this.tipo = tipo;
    }

}
