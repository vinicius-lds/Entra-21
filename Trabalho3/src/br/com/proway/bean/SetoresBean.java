package br.com.proway.bean;

import java.util.Objects;

/**
 * @author Vinícius Luis da Silva
 */
public class SetoresBean {
    
    private int idSetor;
    private String nomeDoSetor;

    public SetoresBean(int idSetor, String nomeDoSetor) {
        this.idSetor = idSetor;
        this.nomeDoSetor = nomeDoSetor;
    }

    public String getNomeDoSetor() {
        return nomeDoSetor;
    }

    public void setNomeDoSetor(String nomeDoSetor) {
        this.nomeDoSetor = nomeDoSetor;
    }

    public int getIdSetor() {
        return idSetor;
    }

    @Override
    public String toString() {
        return this.getNomeDoSetor();
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
        final SetoresBean other = (SetoresBean) obj;
        if (this.idSetor != other.idSetor) {
            return false;
        }
        if (!Objects.equals(this.nomeDoSetor, other.nomeDoSetor)) {
            return false;
        }
        return true;
    }
    
}
