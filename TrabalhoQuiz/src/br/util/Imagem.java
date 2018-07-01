package br.util;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author vinic
 */
public class Imagem {
    
    public static final String ICON_CLOSE = "/br/img/icon-close.png";
    public static final String ICON_USUARIO = "/br/img/icon-usuario.png";
    public static final String ICON_SKIP = "/br/img/icon-skip.png";
    public static final String ICON_RESPOND = "/br/img/icon-help.png";
    public static final String ICON_HELP = "/br/img/icon-respond.png";
    
    public void setIcon(JLabel label, String imagem, int width, int height) {
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagem)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
    
}
