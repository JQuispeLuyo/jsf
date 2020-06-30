package controllers;

import models.Ubigeo;
import dao.UbigeoDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("ubigeoController")
@ViewScoped
public class UbigeoController implements Serializable{

    private final UbigeoDao ubigeoDao;
    
    private List<Ubigeo> items;
    
    private Ubigeo ubigeo;
    
    public UbigeoController() {
        this.items = null;
        this.ubigeoDao = new UbigeoDao();
    }

    //Metodo para le auto complete de ubigeo
    public List<Ubigeo> autocomplete(String distri) throws SQLException {
        items = this.ubigeoDao.autocomplete(distri);
        return items;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }
}
