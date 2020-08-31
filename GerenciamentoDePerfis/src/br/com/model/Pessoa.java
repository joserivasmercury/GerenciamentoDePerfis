package br.com.model;

import java.util.Date;

public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    private Date datanasc;
    private char sexo;

    public Pessoa(String nome, String cpf, Date datanasc, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Pessoa)) return false;
        return this.cpf.equals(((Pessoa)o).cpf);
    }
}
