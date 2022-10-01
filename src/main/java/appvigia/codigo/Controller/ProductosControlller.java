package appvigia.codigo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import appvigia.codigo.Model.entities.Productos;
import appvigia.codigo.Model.service.IProductosService;

@Controller
@SessionAttributes("producto")
public class ProductosControlller {

    @Autowired
    private IProductosService productosService;

    @RequestMapping(value = "/listarProductos", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("producto", productosService.findAll());
        return "listarProductos";
    }

    @RequestMapping(value = "/nuevoProducto")
    public String crear(Map<String, Object> model) {
        Productos producto = new Productos();
        model.put("producto", producto);
        model.put("titulo", "Formulario de Productos");
        return "nuevoProducto";
    }

    @GetMapping(value = "/nuevoProducto/{id}")
    public String editar(@PathVariable(value = "id") long id, Map<String, Object> model) {
        Productos producto = null;

        if (id > 0) {
            producto = productosService.findOne(id);
        } else {
            return "redirect:/listarProductos";
        }
        model.put("producto", producto);
        model.put("titulo", "Actualizar Registro");
        return "nuevoProducto";
    }

    @RequestMapping(value = "/nuevoProducto", method = RequestMethod.POST)
    public String guardar(@Validated Productos producto, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Productos");
            return "nuevoProducto";
        }
        productosService.save(producto);
        status.setComplete();
        return "redirect:listarProductos";
    }

    @RequestMapping(value = "/eliminarP/{id}")
    public String eliminar(@PathVariable(value = "id") long id) {
        if (id > 0) {
            productosService.delete(id);
        }
        return "redirect:/listarProductos";
    }

    @RequestMapping(value = "/preciosP/{id}")
    public String precios(@PathVariable(value = "id") long id) {
        if (id > 0) {
            //TODO: implementar servicio
        }
        return "redirect:/listarProductos";
    }
}
