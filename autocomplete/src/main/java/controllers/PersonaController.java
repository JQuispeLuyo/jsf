package controllers;

import dao.PersonaDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import models.Persona;

@Named("personaController")
@ViewScoped
public class PersonaController implements Serializable{

    private final PersonaDao personaDao = new PersonaDao();
    
    private List<Persona> items;
    
    private Persona persona = new Persona();
    
    public PersonaController() {
        this.items = null;
    }

    //Metodo para listar todas las personas
    public void create() throws SQLException {
        System.out.println(persona);
        this.personaDao.create(persona);
        items = null;
        growlMessage("El usuario "+ persona.getNOMPER() + " fue creado exitosamente");
        persona = new Persona();
    }
    
    
    //metodo para llamar al growl
    private void growlMessage (String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nuevo registro", message) );
    }
    

    public List<Persona> getItems() throws SQLException {
        if (items == null) { //Condicional para lista cada vez que se realize una accion de CRUD
            items = personaDao.findAll();
        }
        return items;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
