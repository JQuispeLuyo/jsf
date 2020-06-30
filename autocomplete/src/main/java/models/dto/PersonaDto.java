/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dto;

import models.Ubigeo;
import java.io.Serializable;

/**
 *
 * @author José Quispe
 */
public class PersonaDto implements Serializable{
    Integer IDPER;
    String NOMPER;
    String APEPER;
    Ubigeo ubigeo;

    public Integer getIDPER() {
        return IDPER;
    }

    public void setIDPER(Integer IDPER) {
        this.IDPER = IDPER;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getAPEPER() {
        return APEPER;
    }

    public void setAPEPER(String APEPER) {
        this.APEPER = APEPER;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    @Override
    public String toString() {
        return "PersonaDto{" + "IDPER=" + IDPER + ", NOMPER=" + NOMPER + ", APEPER=" + APEPER + ", ubigeo=" + ubigeo + '}';
    }

}
