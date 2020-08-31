package br.com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Usuario extends Pessoa implements Comparable<Pessoa> {

    private Cargo cargo;
    private List<Perfil> perfis;
    private final Date dataCriado;
    
    public Usuario(String nome, String cpf, Date datanasc, char sexo, Cargo cargo, List<Perfil> perfis) {
        super(nome, cpf, datanasc, sexo);
        this.cargo = cargo;
        this.perfis = new ArrayList<>(perfis);
        Collections.sort(this.perfis);
        dataCriado = new Date();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Perfil> getPerfis() {
        return Collections.unmodifiableList(perfis);
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = new ArrayList<>(perfis);
        Collections.sort(this.perfis);
    }
    
    public String getDataCriado() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss");    
        return formatter.format(dataCriado);  
    }
    
    public String[] getListaPerfis() {
        String[] lista = new String[perfis.size()];
        int cont = 0;
        for (Perfil perfil : perfis) {
            lista[cont++] = perfil.getNome();
        }
        return lista;
    }

    @Override
    public int compareTo(Pessoa o) {
        return getNome().compareTo(o.getNome());
    }
}
