package appvigia.codigo.Model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import appvigia.codigo.Model.dao.IProductosDao;
import appvigia.codigo.Model.entities.Productos;

@Service
public class IProductosServiceImpl implements IProductosService {

    @Autowired
    private IProductosDao productosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> findAll() {
        return (List<Productos>) productosDao.findAll();
    }

    @Override
    public void save(Productos productos) {
        productosDao.save(productos);
    }

    @Override
    @Transactional(readOnly = true)
    public Productos findOne(long id) {
        return productosDao.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        productosDao.deleteById(id);
    }

}
