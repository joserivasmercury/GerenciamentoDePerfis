package br.com.model;

import java.util.Objects;

public class Perfil implements Comparable<Perfil> {
    
    private String nome;
    private int quantUsos;
    
    public Perfil(String nome) {
        this.nome = nome;
        quantUsos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void incUso() {
        quantUsos++;
    }
    
    public void decUso() {
        quantUsos--;
    }
    
    public boolean taSendoUsado() {
        return quantUsos > 0;
    }

    @Override
    public int compareTo(Perfil o) {
        return this.nome.compareTo(o.nome);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Perfil)) return false;
        return this.nome.equals(((Perfil)o).nome);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nome);
        return hash;
    }
}
