package appvigia.codigo.Model.service;

import java.util.List;

import appvigia.codigo.Model.entities.Productos;

public interface IProductosService {
    public List<Productos> findAll();

    public void save(Productos tienda);

    public Productos findOne(long id);

    public void delete(long id);
}
