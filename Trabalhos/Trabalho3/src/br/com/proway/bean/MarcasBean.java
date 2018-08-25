package br.com.proway.bean;

import java.util.Objects;

/**
 * @author Vinícius Luis da Silva
 */
public class MarcasBean {
    
    private final int idMarca;
    private String nomeMarca;

    public MarcasBean(int idMarca, String nomeMarca) {
        this.idMarca = idMarca;
        this.nomeMarca = nomeMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    @Override
    public String toString() {
        return this.getNomeMarca();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcasBean other = (MarcasBean) obj;
        if (this.idMarca != other.idMarca) {
            return false;
        }
        if (!Objects.equals(this.nomeMarca, other.nomeMarca)) {
            return false;
        }
        return true;
    }
    
}
