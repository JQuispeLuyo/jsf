package dao;

import models.Persona;
import models.Ubigeo;
import models.dto.PersonaDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao extends Conexion {

    public List<PersonaDto> findAll() throws SQLException {
        this.conectar();
        List<PersonaDto> lista;
        try {
            lista = new ArrayList();
            String sql = "Select " +
                        "    P.IDPER," +
                        "    P.NOMPER," +
                        "    P.APEPER," +
                        "    P.CODUBI," +
                        "    U.NOMDEP," +
                        "    U.NOMPROV," +
                        "    U.NOMDIST" +
                        "       from persona as P" +
                        "           INNER JOIN ubigeo as U " +
                        "        	ON P.CODUBI = U.CODUBI";
            
            PreparedStatement ps = getCn().prepareStatement(sql);
            //ps.setString(1, "%" + texto.toUpperCase() + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                PersonaDto personaDto = new PersonaDto();
                
                personaDto.setIDPER(rs.getInt("IDPER"));
                personaDto.setNOMPER(rs.getString("NOMPER"));
                personaDto.setAPEPER(rs.getString("APEPER"));
                
                Ubigeo ubigeo = new Ubigeo();
                
                ubigeo.setCODUBI(rs.getString("CODUBI"));
                ubigeo.setNOMDEP(rs.getString("NOMDEP"));
                ubigeo.setNOMPROV(rs.getString("NOMPROV"));
                ubigeo.setNOMDIST(rs.getString("NOMDIST"));
                
                personaDto.setUbigeo(ubigeo);
                
                lista.add(personaDto);
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public void create(Persona persona) throws SQLException {
        this.conectar();
        try {
            String sql = "INSERT INTO persona (NOMPER, APEPER, CODUBI) "
                        + "VALUES (?, ?, ?) ";
            
            PreparedStatement ps = getCn().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getCODUBI());
            
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
