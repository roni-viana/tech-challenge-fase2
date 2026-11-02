package com.postech.tech_challenge_fase2.domain.entity;

public class Restaurante {
    
    private Long id;
    private String nome;
    private String endereco;
    private String tipoCozinha;
    private String horarioFuncionamento;
    private Long idDono; // Associação ao utilizador existente

    public Restaurante() {
    }

    public Restaurante(Long id, String nome, String endereco, String tipoCozinha, String horarioFuncionamento, Long idDono) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.idDono = idDono;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    
    public String getTipoCozinha() { return tipoCozinha; }
    public void setTipoCozinha(String tipoCozinha) { this.tipoCozinha = tipoCozinha; }
    
    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public void setHorarioFuncionamento(String horarioFuncionamento) { this.horarioFuncionamento = horarioFuncionamento; }
    
    public Long getIdDono() { return idDono; }
    public void setIdDono(Long idDono) { this.idDono = idDono; }
}