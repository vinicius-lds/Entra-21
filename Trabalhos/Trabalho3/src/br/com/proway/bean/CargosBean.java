package br.com.proway.bean;

/**
 * @author Vinícius Luis da Silva
 */
public class CargosBean {
    
    private final int idCargo;
    private String nomeCargo;
    private double salarioCargo;

    public CargosBean(int idCargo, String nomeCargo, double salarioCargo) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.salarioCargo = salarioCargo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public double getSalarioCargo() {
        return salarioCargo;
    }

    public void setSalarioCargo(double salarioCargo) {
        this.salarioCargo = salarioCargo;
    }

    @Override
    public String toString() {
        return this.getNomeCargo();
    }
    
}
