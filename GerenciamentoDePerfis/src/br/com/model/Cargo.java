package br.com.model;

import java.util.Objects;

public class Cargo implements Comparable<Cargo> {

    private String nome;
    private int quantUsos;
    
    public Cargo(String nome) {
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
    public int compareTo(Cargo o) {
        return this.nome.compareTo(o.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Cargo)) return false;
        return this.nome.equals(((Cargo)o).nome);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nome);
        return hash;
    }
}
