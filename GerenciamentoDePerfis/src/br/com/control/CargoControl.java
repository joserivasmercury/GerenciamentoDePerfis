package br.com.control;

import br.com.model.Cargo;
import br.com.model.CargoRepo;
import java.util.List;

public class CargoControl {
    
    private final CargoRepo repo;
    private static CargoControl control;

    private CargoControl() {
        repo = new CargoRepo();
        repo.addCargo("Tester");
        repo.addCargo("Scrum Master");
        repo.addCargo("Dev OP");
    }
    
    public static CargoControl getInstancia() {
        if (control == null) {
            control = new CargoControl();
        }
        return control;
    }
    
    public Cargo getByNome(String nome) {
        return repo.getByNome(nome);
    }
    
    public boolean addCargo(String nome) {
        return repo.addCargo(nome);
    }
    
    public boolean updateCargo(String nome, String nomeNovo) {
        return repo.updateCargo(nome, nomeNovo);
    }
    
    public boolean deleteCargo(String nome) {
        return repo.deleteCargo(nome);
    }
    
    public List<Cargo> getCargoList() {
        return repo.getCargoList();
    }
    
    public String[] getCargoNames() {
        List<Cargo> cargos = getCargoList();
        String[] nomes = new String[cargos.size()];
        int count = 0;
        for (Cargo cargo : cargos) {
            nomes[count++] = cargo.getNome();
        }
        return nomes;
    }
    
    public int countCargos() {
        return getCargoList().size();
    }
}
