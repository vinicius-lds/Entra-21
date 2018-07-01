package br.com.proway.util;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Vinícius Luis da Silva
 */
public class Imagem {
    
    private static Imagem obj;
    private Imagem() {}
    public static Imagem getInstance() {
        if(obj == null) {
            obj = new Imagem();
        }
        return obj;
    }
    
    public static final String ICON_PRODUTO = "/br/com/proway/images/icon-produto.png";
    public static final String ICON_CLIENTE = "/br/com/proway/images/icon-cliente.png";

    public void setIcon(JLabel label, String imagem, int width, int height) {
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagem)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
    
}
