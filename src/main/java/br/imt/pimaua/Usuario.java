package br.imt.pimaua;

public class Usuario {
    private String nome;
    private String email;
    private int senha;

    public Usuario( String nome,String email, int senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
