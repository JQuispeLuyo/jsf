package dao;

import models.Ubigeo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UbigeoDao extends Conexion {

    public List<Ubigeo> autocomplete(String texto) throws SQLException {
        this.conectar();
        List<Ubigeo> lista;
        try {
            lista = new ArrayList();
            String sql = "Select CODUBI, NOMDEP, NOMPROV, NOMDIST "
                    + "from UBIGEO "
                    + "WHERE NOMDIST like ? and NOMPROV = 'CAÑETE' ";
            
            PreparedStatement ps = getCn().prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Ubigeo ubigeo = new Ubigeo();
                
                ubigeo.setCODUBI(rs.getString("CODUBI"));
                ubigeo.setNOMDEP(rs.getString("NOMDEP"));
                ubigeo.setNOMPROV(rs.getString("NOMPROV"));
                ubigeo.setNOMDIST(rs.getString("NOMDIST"));
                
                lista.add(ubigeo);
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public static void main(String[] args) {
        UbigeoDao ubigeoDao = new UbigeoDao();
        try {
            
            List<Ubigeo> ubigeos = ubigeoDao.autocomplete("san");
            System.out.println(ubigeos.size());
            ubigeos.forEach(x->{
                System.out.println(x);
            });
        } catch (SQLException ex) {
            Logger.getLogger(UbigeoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
