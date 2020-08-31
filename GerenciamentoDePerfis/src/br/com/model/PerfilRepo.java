package br.com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfilRepo {
    private final List<Perfil> perfis;

    public PerfilRepo() {
        perfis = new ArrayList<>();
    }
    
    public Perfil getByNome(String nome) {
        for (Perfil perfil : perfis) {
            if (perfil.getNome().equalsIgnoreCase(nome)) return perfil;
        }
        return null;
    }
    
    public boolean addPerfil(String nome) {
        if (getByNome(nome) == null) {
            perfis.add(new Perfil(nome));
            Collections.sort(perfis);
            return true;
        }
        return false;
    }
    
    public boolean updatePerfil(String nome, String nomeNovo) {
        Perfil perfil = getByNome(nome);
        if (perfil != null && getByNome(nomeNovo) == null) {
            perfil.setNome(nomeNovo);
            Collections.sort(perfis);
            return true;
        }
        return false;
    }
    
    public boolean deletePerfil(String nome) {
        Perfil perfil = getByNome(nome);
        if (perfil != null && !perfil.taSendoUsado()) {
            perfis.remove(perfil);
            return true;
        }
        return false;
    }
    
    public List<Perfil> getPerfilList() {
        return perfis;
    }
}
