/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.config;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfernandez
 */
public class Config {

    private static final String SEPARATOR = "=";

    public static void crearConfigFile(HashMap<String, String> mapa, String rutaFichero) {

        try (
                 FileWriter fWriter = new FileWriter(rutaFichero);  BufferedWriter bWriter = new BufferedWriter(fWriter);) {

            for (Map.Entry<String, String> entry : mapa.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();

                bWriter.write(key + SEPARATOR + val);
                bWriter.newLine();

            }

        } catch (IOException ex) {
            System.err.println("Ha ocurrido una exception: " + ex.getMessage());
        }

    }

    public static String leerConfig(String rutaFichero, String clave) {
        String[] paresClaveValor = null;
        String valor = null;
        boolean encontrado = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String linea = br.readLine();
            while (linea != null) {
                paresClaveValor = linea.split(SEPARATOR);

                if (paresClaveValor[0] != null && paresClaveValor[0].equals(clave)) {
                    encontrado = true;
                    valor = paresClaveValor[1];

                } else {
                    linea = br.readLine();
                }

            }

        } catch (IOException ex) {
            System.err.println("Ha ocurrido una exception: " + ex.getMessage());
        }
        return valor;
    }
}
