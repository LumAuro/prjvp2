package appvigia.codigo.Model.dao;

import org.springframework.data.repository.CrudRepository;

import appvigia.codigo.Model.entities.Usuarios;

public interface IUsuariosDao extends CrudRepository<Usuarios, Integer> {

}
