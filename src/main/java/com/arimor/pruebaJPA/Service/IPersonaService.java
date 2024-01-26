package com.arimor.pruebaJPA.Service;

import com.arimor.pruebaJPA.Model.Persona;

import java.util.List;

public interface IPersonaService {

    //metodo para traer a todas las oersonas
    // lecyura
    public List<Persona> getPersonas();

    //alta
    public void savePersona(Persona person);

    //baja borrar
    public void deletePersona(Long id);

    //lectura de una sola persona
    public Persona findPersona(Long id);

    //modifica o editar
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);
}
