package com.arimor.pruebaJPA.Service;

import com.arimor.pruebaJPA.Model.Persona;
import com.arimor.pruebaJPA.Repository.IPersonaRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaRepository personRepository ;

    @Override
    public List<Persona> getPersonas() {
         List<Persona> listaPersonas = personRepository.findAll();
         return listaPersonas;
    }

    @Override
    public void savePersona(Persona person) {
        personRepository.save(person);
    }

    @Override
    public void deletePersona(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = personRepository.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApelliido, int nuevaEdad) {
        //para buscar el obeto original
        Persona perso = this.findPersona(idOriginal);

        //modificar datos
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApelliido);
        perso.setEdad(nuevaEdad);

        //Guardar los datos
        this.savePersona(perso);
    }
}
