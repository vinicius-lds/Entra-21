package br.util;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author vinic
 */
public class Imagem {
    
    public static final String ICON_CLOSE = "/br/img/icon-close.png";
    public static final String LOGIN_BACKGROUND = "/br/img/login-background.jpg";
    public static final String ICON_USUARIO = "/br/img/icon-usuario.png";
    public static final String ICON_DATABASE = "/br/img/icon-database.png";
    public static final String ICON_FINANCEIRO = "/br/img/icon-financeiro.png";
    public static final String ICON_HISTORICO = "/br/img/icon-historico.png";
    public static final String ICON_PRINCIPAL = "/br/img/icon-principal.png";
    public static final String ICON_VENDAS = "/br/img/icon-vendas.png";
    public static final String PRINCIPAL_BACKGROUND = "/br/img/principal-background.jpg";
    
    public void setIcon(JLabel label, String imagem, int width, int height) {
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagem)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
    
}
