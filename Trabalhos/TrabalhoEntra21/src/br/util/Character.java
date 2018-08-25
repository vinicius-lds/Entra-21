/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

/**
 *
 * @author vinic
 */
public class Character {
    
    public static boolean isSpecialCharacter(char c) {
        return (c > 31 && c < 48) || (c > 57 && c < 65) || (c > 90 && c < 97) || (c > 123 && c < 127);
    } 
    
}
