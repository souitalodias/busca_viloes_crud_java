package com.busca_viloes.model;

public class Vilao {
    private Long id;
    private String nome;
    private String codinome;
    private String nivelAmeaca;
    private Double precoDiaria;
    private Boolean disponivel;

    public Vilao() {
    }

    public Vilao(Long id, String nome, String codinome, String nivelAmeaca, Double precoDiaria, Boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.codinome = codinome;
        this.nivelAmeaca = nivelAmeaca;
        this.precoDiaria = precoDiaria;
        this.disponivel = disponivel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCodinome() { return codinome; }
    public void setCodinome(String codinome) { this.codinome = codinome; }
    public String getNivelAmeaca() { return nivelAmeaca; }
    public void setNivelAmeaca(String nivelAmeaca) { this.nivelAmeaca = nivelAmeaca; }
    public Double getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(Double precoDiaria) { this.precoDiaria = precoDiaria; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}