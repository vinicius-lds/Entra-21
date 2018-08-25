
package br.enumeradores;

/**
 *
 * @author 104884
 */
public enum Alternativa {
    A(0), B(1), C(2), D(3);
    
    private int index;
    
    private Alternativa(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    
    public boolean isAlternativaCorreta(int i) {
        return (this.getIndex() == i);
    }
    
}
