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

import appvigia.codigo.Model.entities.Tiendas;
import appvigia.codigo.Model.service.ITiendasService;

@Controller
@SessionAttributes("tienda")
public class TiendasController {

    @Autowired
    private ITiendasService tiendasService;

    @RequestMapping(value = "/listarTiendas", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Tiendas y/o Almacenes de Cadena");
        model.addAttribute("tienda", tiendasService.findAll());
        return "listarTiendas";
    }

    @RequestMapping(value = "/nuevaTienda")
    public String crear(Map<String, Object> model) {
        Tiendas tienda = new Tiendas();
        model.put("tienda", tienda);
        model.put("titulo", "Formulario de Tiendas y/o Almacenes de Cadena");
        return "nuevaTienda";
    }

    @GetMapping(value = "/nuevaTienda/{id}")
    public String editar(@PathVariable(value = "id") long id, Map<String, Object> model) {
        Tiendas tienda = null;

        if (id > 0) {
            tienda = tiendasService.findOne(id);
        } else {
            return "redirect:/listarTiendas";
        }
        model.put("tienda", tienda);
        model.put("titulo", "Actualizar Registro");
        return "nuevaTienda";
    }

    @RequestMapping(value = "/nuevaTienda", method = RequestMethod.POST)
    public String guardar(@Validated Tiendas tienda, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Tiendas o Almacenes de Cadena");
            return "nuevaTienda";
        }
        tiendasService.save(tienda);
        status.setComplete();
        return "redirect:listarTiendas";
    }

    @RequestMapping(value = "/eliminarT/{id}")
    public String eliminar(@PathVariable(value = "id") long id) {
        if (id > 0) {
            tiendasService.delete(id);
        }
        return "redirect:/listarTiendas";
    }
}
