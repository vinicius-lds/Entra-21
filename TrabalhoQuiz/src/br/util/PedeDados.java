package br.util;

import javax.swing.JOptionPane;

public class PedeDados {

    public static String getString(String mensagem) {
        String retorno = JOptionPane.showInputDialog(mensagem);
        while (retorno.equals("")) {
            JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            retorno = JOptionPane.showInputDialog(mensagem);
        }
        return retorno;
    }

    public static int getInt(String mensagem, boolean somentePositivo) {
        int retorno = Integer.MIN_VALUE;
        while (retorno == Integer.MIN_VALUE) {
            try {
                retorno = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                if (somentePositivo && retorno < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            }
        }
        return retorno;
    }

    public static int getInt(String mensagem, int valorMinimo) {
        int retorno = Integer.MIN_VALUE;
        while (retorno == Integer.MIN_VALUE) {
            try {
                retorno = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                if (retorno < valorMinimo) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            }
        }
        return retorno;
    }

    public static int getInt(String mensagem, int valorMinimo, int valorMaximo) {
        int retorno = Integer.MIN_VALUE;
        while (retorno == Integer.MIN_VALUE) {
            try {
                retorno = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                if (retorno < valorMinimo || retorno > valorMaximo) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                retorno = Integer.MIN_VALUE;
                JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            }
        }
        return retorno;
    }

    public static double getDouble(String mensagem, boolean somentePositivo) {
        double retorno = Double.MIN_VALUE;
        while (retorno == Double.MIN_VALUE) {
            try {
                retorno = Double.parseDouble(JOptionPane.showInputDialog(mensagem).replace(',', '.'));
                if (somentePositivo && retorno < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                retorno = Double.MIN_VALUE;
                JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            }
        }
        return retorno;
    }

    public static double getDouble(String mensagem, double valorMinimo) {
        double retorno = Double.MIN_VALUE;
        while (retorno == Double.MIN_VALUE) {
            try {
                retorno = Double.parseDouble(JOptionPane.showInputDialog(mensagem).replace(',', '.'));
                if (retorno < valorMinimo) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                retorno = Double.MIN_VALUE;
                JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            }
        }
        return retorno;
    }

    public static double getDouble(String mensagem, double valorMinimo, double valorMaximo) {
        double retorno = Double.MIN_VALUE;
        while (retorno == Double.MIN_VALUE) {
            try {
                retorno = Double.parseDouble(JOptionPane.showInputDialog(mensagem).replace(',', '.'));
                if (retorno < valorMinimo || retorno > valorMaximo) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                retorno = Double.MIN_VALUE;
                JOptionPane.showMessageDialog(null, "Informação Inválida!");
            }
        }
        return retorno;
    }

    public static String getComboBox(String mensagem, String[] opcoes) {
        return (String) JOptionPane.showInputDialog(null,
                mensagem,
                "",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                "");
    }

    public static Object getComboBox(String mensagem, Object[] opcoes) {
        return JOptionPane.showInputDialog(null,
                mensagem,
                "",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                "");
    }

    public static boolean perguntaBooleana(String mensagem) {
        int aux;
        do {
            aux = JOptionPane.showConfirmDialog(null, mensagem, "", 0);
        } while (aux == -1);
        return aux == 0 ? true : false;
    }

}
