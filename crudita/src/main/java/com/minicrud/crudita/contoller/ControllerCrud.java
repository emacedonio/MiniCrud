package com.minicrud.crudita.contoller;

import com.minicrud.crudita.model.Persona;
import com.minicrud.crudita.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCrud {

    @Autowired
    private Repository repo;

    @GetMapping()
    public String index() {
        return "Conectado";
    }

    @GetMapping("personas")
    public List<Persona> getPersonas() {
       return repo.findAll();
    }

    @PostMapping("guardar")
    public String post(@RequestBody Persona persona) {
       repo.save(persona);
       return "Guardado";

    }
    @PutMapping("editar/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona) {
        Persona updatePersona = repo.findById(id).get();
        updatePersona.setNombre(persona.getNombre());
        updatePersona.setTelefono(persona.getTelefono());
        repo.save(updatePersona);
        return "Editado correctamente";
    }
    @DeleteMapping("eliminado/{id}")
    public String delete(@PathVariable Long id) {
        Persona deletePersona = repo.findById(id).get();
        repo.delete(deletePersona);
        return "Eliminado correctamente";
    }
}
