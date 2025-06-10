package br.imt.pimaua;

public class Usuario {
    private int idusuario;
    private String nome;
    private String email;
    private int senha;

    public Usuario( int idusuario, String nome, String email, int senha) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public int getIdusuario() {
        return idusuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getSenha() {
        return senha;
    }
}
