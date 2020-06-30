package models;

import java.io.Serializable;

public class Ubigeo implements Serializable {
    
    private String CODUBI;
    private String NOMDEP;
    private String NOMPROV;
    private String NOMDIST;

    public String getCODUBI() {
        return CODUBI;
    }

    public void setCODUBI(String CODUBI) {
        this.CODUBI = CODUBI;
    }

    public String getNOMDEP() {
        return NOMDEP;
    }

    public void setNOMDEP(String NOMDEP) {
        this.NOMDEP = NOMDEP;
    }

    public String getNOMPROV() {
        return NOMPROV;
    }

    public void setNOMPROV(String NOMPROV) {
        this.NOMPROV = NOMPROV;
    }

    public String getNOMDIST() {
        return NOMDIST;
    }

    public void setNOMDIST(String NOMDIST) {
        this.NOMDIST = NOMDIST;
    }

    @Override
    public String toString() {
        return "Ubigeo{" + "CODUBI=" + CODUBI + ", NOMDEP=" + NOMDEP + ", NOMPROV=" + NOMPROV + ", NOMDIST=" + NOMDIST + '}';
    }

}
