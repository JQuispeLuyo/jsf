package services.impl;

import dao.PersonaDao;
import models.Persona;
import models.dto.PersonaDto;
import services.PersonaService;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements Serializable, PersonaService {
    
    @Inject
    PersonaDao personaDao;
    
    public PersonaServiceImpl() {}

    @Override
    public void create(PersonaDto personaDto) {
        try {
            
            Persona persona = new Persona();
            
            persona.setIDPER(personaDto.getIDPER());
            persona.setNOMPER(personaDto.getNOMPER());
            persona.setAPEPER(personaDto.getAPEPER());
            persona.setCODUBI(personaDto.getUbigeo().getCODUBI());
            
            personaDao.create(persona);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PersonaDto> findAll() {
        try {
            return personaDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
