package dao;

import models.Persona;
import models.Ubigeo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao extends Conexion {

    public List<Persona> findAll() throws SQLException {
        this.conectar();
        List<Persona> lista;
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
                Persona persona = new Persona();
                
                persona.setIDPER(rs.getInt("IDPER"));
                persona.setNOMPER(rs.getString("NOMPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                
                Ubigeo ubigeo = new Ubigeo();
                
                ubigeo.setCODUBI(rs.getString("CODUBI"));
                ubigeo.setNOMDEP(rs.getString("NOMDEP"));
                ubigeo.setNOMPROV(rs.getString("NOMPROV"));
                ubigeo.setNOMDIST(rs.getString("NOMDIST"));
                
                persona.setUbigeo(ubigeo);
                
                lista.add(persona);
                
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
            ps.setString(3, persona.getUbigeo().getCODUBI());
            
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
