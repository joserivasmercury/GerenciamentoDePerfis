package br.com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CargoRepo {
    private final List<Cargo> cargos;

    public CargoRepo() {
        cargos = new ArrayList<>();
    }
    
    public Cargo getByNome(String nome) {
        for (Cargo cargo : cargos) {
            if (cargo.getNome().equalsIgnoreCase(nome)) return cargo;
        }
        return null;
    }
    
    public boolean addCargo(String nome) {
        if (getByNome(nome) == null) {
            cargos.add(new Cargo(nome));
            Collections.sort(cargos);
            return true;
        }
        return false;
    }
    
    public boolean updateCargo(String nome, String nomeNovo) {
        Cargo cargo = getByNome(nome);
        if (cargo != null && getByNome(nomeNovo) == null) {
            cargo.setNome(nomeNovo);
            Collections.sort(cargos);
            return true;
        }
        return false;
    }
    
    public boolean deleteCargo(String nome) {
        Cargo cargo = getByNome(nome);
        if (cargo != null && !cargo.taSendoUsado()) {
            cargos.remove(cargo);
            return true;
        }
        return false;
    }
    
    public List<Cargo> getCargoList() {
        return cargos;
    }
}
