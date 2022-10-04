/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import repaso.model.Piscina;

/**
 *
 * @author a21cristinaaf
 */
//Crea un paquete repaso.persistencia y dentro una clase FilePersistencia
//con un método  write(Piscina object, String ruta) que sea capaz de guardar un objeto de tipo piscina en un archivo con la ruta especificada
public class FilePersistencia {

    public static void write(Piscina object, String ruta) {

        try (
                 FileOutputStream file = new FileOutputStream(ruta);  ObjectOutputStream output = new ObjectOutputStream(file);) {

            output.writeObject(object);

        } catch (IOException ex) {
            System.out.println("Ha ocurrido una excepción" + ex.getMessage());

        }

    }

    public static Piscina read(String ruta) {
        Piscina piscina = null;
        try (
                 FileInputStream fis = new FileInputStream(ruta);  ObjectInputStream ois = new ObjectInputStream(fis);) {

            piscina = (Piscina) ois.readObject();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción" + ex.getMessage());
        }
        return piscina;
    }

}
