package appvigia.codigo.Model.service;

import java.util.List;

import appvigia.codigo.Model.entities.Tiendas;

public interface ITiendasService {
    public List<Tiendas> findAll();

    public void save(Tiendas tienda);

    public Tiendas findOne(long id);

    public void delete(long id);
}
