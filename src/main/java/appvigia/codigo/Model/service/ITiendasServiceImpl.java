package appvigia.codigo.Model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import appvigia.codigo.Model.dao.ITiendasDao;
import appvigia.codigo.Model.entities.Tiendas;

@Service
public class ITiendasServiceImpl implements ITiendasService {

    @Autowired
    private ITiendasDao tiendasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tiendas> findAll() {
        return (List<Tiendas>) tiendasDao.findAll();
    }

    @Override
    @Transactional
    public void save(Tiendas tiendas) {
        tiendasDao.save(tiendas);
    }

    @Override

    public Tiendas findOne(long id) {
        return tiendasDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(long id) {
        tiendasDao.deleteById(id);
    }

}
