package appvigia.codigo.Model.dao;

import org.springframework.data.repository.CrudRepository;

import appvigia.codigo.Model.entities.Productos;

public interface IProductosDao extends CrudRepository<Productos, Long> {

}
