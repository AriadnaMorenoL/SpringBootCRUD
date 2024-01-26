package com.arimor.pruebaJPA.Controller;

import com.arimor.pruebaJPA.Model.Persona;
import com.arimor.pruebaJPA.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService personService;

    //traer la lista de objetos
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return personService.getPersonas();
    }

    //Guardar un objeto
    @PostMapping("personas/crear")
    public String savePersona(@RequestBody Persona perso){
        personService.savePersona(perso);
        return "se guardó exitosamente!!";
    }

    // Borrar objeto
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personService.deletePersona(id);
        return "se eliminó exitosamente!!";
    }

    // Editar un objeto
    @PutMapping("/persona/editar/{idOriginal}")
    public Persona editPersona(@PathVariable Long idOriginal,
                               @RequestParam(required = false, name = "id") Long idNueva,
                               @RequestParam(required = false,  name = "nombre") String nuevoNombre,
                               @RequestParam(required = false,name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") int nuevaEdad){

        //Envio del Id original para buscar
        //Envio de nuevos datos pra modificar
        personService.editPersona(idOriginal, idNueva, nuevoNombre, nuevoApellido, nuevaEdad);

        //buscar nuevo objeto para mostrarlo enn response

        Persona perso = personService.findPersona(idNueva);

        return perso;

    }

}
