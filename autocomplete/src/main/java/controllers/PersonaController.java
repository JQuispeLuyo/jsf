package controllers;

import models.dto.PersonaDto;
import services.PersonaService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("personaController")
@ViewScoped
public class PersonaController implements Serializable{

    @EJB
    private PersonaService personaService;
    
    private List<PersonaDto> items;
    
    @Inject
    private PersonaDto persona;
    
    public PersonaController() {
        this.items = null;
    }

    //Metodo para listar todas las personas
    public void create() {
        System.out.println(persona);
        this.personaService.create(persona);
        items = null;
    }

    public List<PersonaDto> getItems() {
        if (items == null) { //Condicional para lista cada vez que se realize una accion de CRUD
            items = personaService.findAll();
        }
        return items;
    }
    
    
    
    
    
    
    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

}
