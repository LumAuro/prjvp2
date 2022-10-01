package appvigia.codigo.Model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import appvigia.codigo.Model.dao.IUsuariosDao;
import appvigia.codigo.Model.entities.Usuarios;

@Service
public class IUsuariosServiceImpl implements IUsuariosService {

    @Autowired
    private IUsuariosDao usuariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return (List<Usuarios>) usuariosDao.findAll();
    }

    @Override
    @Transactional
    public void save(Usuarios usuarios) {
        usuariosDao.save(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios findOne(int id) {
        return usuariosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        usuariosDao.deleteById(id);
    }
}
