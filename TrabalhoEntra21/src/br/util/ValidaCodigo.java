package br.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinic
 */
public class ValidaCodigo {
    
    
    public static boolean isCPF(String codigo) {
        
        codigo = formatCode(codigo);
        
        if(codigo.equals("99999999999")
        || codigo.equals("88888888888")
        || codigo.equals("77777777777")
        || codigo.equals("66666666666")
        || codigo.equals("55555555555")
        || codigo.equals("44444444444")
        || codigo.equals("33333333333")
        || codigo.equals("22222222222")
        || codigo.equals("11111111111")
        || codigo.equals("00000000000")
        || !isNumbersOnly(codigo)
        || codigo.length() != 11) {
            return false;
        }
        
        int primeiroDigito = Integer.valueOf(String.valueOf(codigo.charAt(9)));
        int segundoDigito = Integer.valueOf(String.valueOf(codigo.charAt(10)));
        
        int resultado = 0;
        for (int i = 0, j = 10; i < 9; i++, j--) {
            resultado += Integer.valueOf(String.valueOf(codigo.charAt(i))) * j;
        }

        resultado = 11 - (resultado % 11);
        if (!(((resultado == 10) || (resultado == 11)
           && primeiroDigito == 0)
           || primeiroDigito == resultado)) {
           return false;
        }
        
        resultado = 0;
        for (int i = 0, j = 11; i < 10; i++, j--) {
            resultado += Integer.valueOf(String.valueOf(codigo.charAt(i))) * j;
        }
        
        resultado = 11 - (resultado % 11);
        if(!(((resultado == 10) || (resultado == 11) && segundoDigito == 0)
               || segundoDigito == resultado)) {
            return false;
        }
        
        return true;
    }
    
    public static boolean isCNPJ(String codigo) {
        
        codigo = formatCode(codigo);
        
        if (codigo.equals("00000000000000") 
        || codigo.equals("11111111111111") 
        || codigo.equals("22222222222222") 
        || codigo.equals("33333333333333") 
        || codigo.equals("44444444444444")
        || codigo.equals("55555555555555") 
        || codigo.equals("66666666666666") 
        || codigo.equals("77777777777777")
        || codigo.equals("88888888888888") 
        || codigo.equals("99999999999999")
        || !isNumbersOnly(codigo)
        || (codigo.length() != 14)) {
            return false;
        }
        
        int primeiroDigito = Integer.valueOf(String.valueOf(codigo.charAt(12)));
        int segundoDigito = Integer.valueOf(String.valueOf(codigo.charAt(13)));
        
        int resultado = 0;
        for (int i = 11, j = 2; i >= 0; i--, j++) {
            if(j == 10) {
                j = 2;
            }
            resultado += Integer.valueOf(String.valueOf(codigo.charAt(i))) * j;
        }
        
        resultado = resultado % 11;
        if (!((((resultado == 0) || (resultado == 1)) && primeiroDigito == 0)
            || primeiroDigito == (11 - resultado))) {
            return false;
        }
        
        resultado = 0;
        for (int i = 12, j = 2; i >= 0; i--, j++) {
            if(j == 10) {
                j = 2;
            }
            resultado += Integer.valueOf(String.valueOf(codigo.charAt(i))) * j;
        }
        
        resultado = resultado % 11;
        if(!((((resultado == 0) || (resultado == 1)) && segundoDigito == 0)
                || segundoDigito == 11 - resultado)) {
            return false;
        }
        
        return true;
    }
    
    private static boolean isNumbersOnly(String codigo) {
        /*
            Esse método é funcional somente entre os numeros:
            -922337203685477808 a 922337203685477807
        */
        try {
            Long.valueOf(codigo);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    private static String formatCode(String codigo) {
        codigo = codigo.replace(".", "");
        codigo = codigo.replace("-", "");
        codigo = codigo.replace("/", "");
        return codigo;
    }
}
