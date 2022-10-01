package appvigia.codigo.Model.service;

import java.util.List;

import appvigia.codigo.Model.entities.Usuarios;

public interface IUsuariosService {
    public List<Usuarios> findAll();

    public void save(Usuarios usuarios);

    public Usuarios findOne(int id);

    public void delete(int id);
}
