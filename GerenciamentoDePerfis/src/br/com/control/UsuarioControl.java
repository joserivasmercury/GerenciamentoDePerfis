package br.com.control;

import br.com.model.Cargo;
import br.com.model.Perfil;
import br.com.model.Usuario;
import br.com.model.UsuarioRepo;
import java.util.Date;
import java.util.List;

public class UsuarioControl {
    
    private final UsuarioRepo repo;
    private static UsuarioControl control;

    private UsuarioControl() {
        repo = new UsuarioRepo();
    }
    
    public static UsuarioControl getInstancia() {
        if (control == null) {
            control = new UsuarioControl();
        }
        return control;
    }
    
    public Usuario getByCPF(String cpf) {
        return repo.getByCPF(cpf);
    }
    
    public boolean addUsuario(String nome, String cpf, Date datanasc, char sexo, Cargo cargo, List<Perfil> perfis) {
        return repo.addUsuario(nome, cpf, datanasc, sexo, cargo, perfis);
    }
    
    public boolean updateUsuario(String cpf, String nome, String cpfNovo, Date datanasc, char sexo, Cargo cargo, List<Perfil> perfis) {
        return repo.updateUsuario(cpf, nome, cpfNovo, datanasc, sexo, cargo, perfis);
    }
    
    public boolean deleteUsuario(String cpf) {
        return repo.deleteUsuario(cpf);
    }
    
    public List<Usuario> getUsuarioList() {
        return repo.getUsuarioList();
    }
    
    public String[] getUsuarioNames() {
        List<Usuario> usuarios = getUsuarioList();
        String[] nomes = new String[usuarios.size()];
        int count = 0;
        for (Usuario usuario : usuarios) {
            nomes[count++] = usuario.getNome()+ " - " + usuario.getCpf();
        }
        return nomes;
    }
    
    public int countUsuarios() {
        return getUsuarioList().size();
    }
}
