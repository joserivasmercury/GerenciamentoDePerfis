package br.com.control;

import br.com.model.Perfil;
import br.com.model.PerfilRepo;
import java.util.List;

public class PerfilControl {
    
    private final PerfilRepo repo;
    private static PerfilControl control;

    private PerfilControl() {
        repo = new PerfilRepo();
        repo.addPerfil("Usuário");
        repo.addPerfil("Admin");
        repo.addPerfil("Dev");
    }
    
    public static PerfilControl getInstancia() {
        if (control == null) {
            control = new PerfilControl();
        }
        return control;
    }
    
    public Perfil getByNome(String nome) {
        return repo.getByNome(nome);
    }
    
    public boolean addPerfil(String nome) {
        return repo.addPerfil(nome);
    }
    
    public boolean updatePerfil(String nome, String nomeNovo) {
        return repo.updatePerfil(nome, nomeNovo);
    }
    
    public boolean deletePerfil(String nome) {
        return repo.deletePerfil(nome);
    }
    
    public List<Perfil> getPerfilList() {
        return repo.getPerfilList();
    }
    
    public String[] getPerfilNames() {
        List<Perfil> cargos = getPerfilList();
        String[] nomes = new String[cargos.size()];
        int count = 0;
        for (Perfil cargo : cargos) {
            nomes[count++] = cargo.getNome();
        }
        return nomes;
    }
    
    public int countPerfis() {
        return getPerfilList().size();
    }
}
