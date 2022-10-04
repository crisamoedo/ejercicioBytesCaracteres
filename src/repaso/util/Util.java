/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mfernandez
 */
public class Util {

    public static boolean isInRange(int min, int max, int valor) {
        return (valor >= min && valor <= max);
    }

    public static boolean isDniValid(String dni) {
        Pattern pat = Pattern.compile("[0-9]{8}[A-Za-z]");
        Matcher mat = pat.matcher(dni);
        return mat.matches();
    }
}
