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

import appvigia.codigo.Model.entities.Usuarios;
import appvigia.codigo.Model.service.IUsuariosService;

@Controller
@SessionAttributes("usuario")
public class UsuariosController {

    @Autowired
    private IUsuariosService usuariosService;

    @RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuario", usuariosService.findAll());
        return "listarUsuarios";
    }

    // El Map<String, Object> es igual a <Model, model>
    // Este metodo es para presentar el formulario
    @RequestMapping(value = "/nuevoUsuario")
    public String crear(Map<String, Object> model) {
        Usuarios usuario = new Usuarios();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de Usuario");
        return "nuevoUsuario";
    }

    @GetMapping(value = "/nuevoUsuario/{id}")
    public String editar(@PathVariable(value = "id") int id, Map<String, Object> model) {
        Usuarios usuario = null;

        if (id > 0) {
            usuario = usuariosService.findOne(id);
        } else {
            return "redirect:/listarUsuarios";
        }
        model.put("usuario", usuario);
        model.put("titulo", "Actualizar Registro");
        return "nuevoUsuario";
    }

    @RequestMapping(value = "/nuevoUsuario", method = RequestMethod.POST)
    public String guardar(@Validated Usuarios usuario, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Usuario");
            return "nuevoUsuario";
        }
        usuariosService.save(usuario);
        status.setComplete();
        return "redirect:listarUsuarios";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int id) {
        if (id > 0) {
            usuariosService.delete(id);
        }
        return "redirect:/listarUsuarios";
    }

}
