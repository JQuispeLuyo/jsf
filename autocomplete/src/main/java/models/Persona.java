/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Jose Quispe
 */
public class Persona implements Serializable{
    
    Integer IDPER;
    String NOMPER;
    String APEPER;
    String CODUBI;

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

    public String getCODUBI() {
        return CODUBI;
    }

    public void setCODUBI(String CODUBI) {
        this.CODUBI = CODUBI;
    }

    @Override
    public String toString() {
        return "Persona{" + "IDPER=" + IDPER + ", NOMPER=" + NOMPER + ", APEPER=" + APEPER + ", CODUBI=" + CODUBI + '}';
    }

}
