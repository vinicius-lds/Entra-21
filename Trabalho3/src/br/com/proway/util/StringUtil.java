package br.com.proway.util;

import java.sql.Date;

/**
 * @author Vinícius Luis da Silva
 */
public abstract class StringUtil {
    
    public static String setAspas(String str) {
        return "\"" + str + "\"";
    }
    
    public static String padronizarData(String data) {
        return data.substring(6) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
    }
    
    public static String dateToString(Date date) {
        String str = (((date.getDate()) < 10) ? "0" + date.getDate() : date.getDate() + "") 
                + (((date.getMonth() + 1) < 10) ? "0" + (date.getMonth() + 1): (date.getMonth() + 1) + "")
                + (date.getYear() + 1900);
        System.out.println(str);
        return str;
    }
    
}
