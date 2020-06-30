package services;

import java.util.List;
import javax.ejb.Local;
import models.dto.PersonaDto;

@Local
public interface PersonaService {
    
    //Crea una nueva persona en Base de Datos
    void create(PersonaDto personaDto);
    
    //Lista todas las personas
    List<PersonaDto> findAll();
    
}
