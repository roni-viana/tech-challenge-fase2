package com.postech.tech_challenge_fase2.domain.entity;

public class Utilizador {
    
    private Long id;
    private String nome;
    private String email;
    private Long idTipoUsuario; // Aqui fazemos a associação exigida no PDF

    public Utilizador() {
    }

    public Utilizador(Long id, String nome, String email, Long idTipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Long getIdTipoUsuario() { return idTipoUsuario; }
    public void setIdTipoUsuario(Long idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }
}