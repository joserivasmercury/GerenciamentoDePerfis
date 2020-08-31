package br.com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UsuarioRepo {
    private final List<Usuario> usuarios;

    public UsuarioRepo() {
        usuarios = new ArrayList<>();
    }
    
    public Usuario getByCPF(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equalsIgnoreCase(cpf)) return usuario;
        }
        return null;
    }
    
    public boolean addUsuario(String nome, String cpf, Date datanasc, char sexo, Cargo cargo, List<Perfil> perfis) {
        if (getByCPF(cpf) == null) {
            usuarios.add(new Usuario(nome, cpf, datanasc, sexo, cargo, perfis));
            cargo.incUso();
            for (Perfil perfil : perfis) {
                perfil.incUso();
            }
            Collections.sort(usuarios);
            return true;
        }
        return false;
    }
    
    public boolean updateUsuario(String cpf, String nome, String cpfNovo, Date datanasc, char sexo, Cargo cargo, List<Perfil> perfis) {
        Usuario usuario = getByCPF(cpf);
        if (usuario != null && (getByCPF(cpfNovo) == null || cpfNovo.equalsIgnoreCase(cpf))) {
            usuario.setNome(nome);
            usuario.setCpf(cpfNovo);
            usuario.setDatanasc(datanasc);
            usuario.setSexo(sexo);
            usuario.setCargo(cargo);
            usuario.setPerfis(perfis);
            Collections.sort(usuarios);
            return true;
        }
        return false;
    }
    
    public boolean deleteUsuario(String cpf) {
        Usuario usuario = getByCPF(cpf);
        if (usuario != null) {
            usuario.getCargo().decUso();
            for (Perfil perfil : usuario.getPerfis()) {
                perfil.decUso();
            }
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
    
    public List<Usuario> getUsuarioList() {
        return usuarios;
    }
}
