/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.util;

/**
 *
 * @author maria
 */
public class DuplicateDNIException extends Exception{
    private String dni;

    public DuplicateDNIException(String string, String dni) {
        super(string);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
    
    
    
    
}
