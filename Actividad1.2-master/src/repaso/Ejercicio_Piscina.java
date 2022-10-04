/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import repaso.config.Config;
import repaso.model.Piscina;
import repaso.persistencia.FilePersistencia;
import repaso.util.DuplicateDNIException;
import repaso.util.IOManager;
import repaso.util.Util;
import repaso.servicios.BookingManager;

/**
 *
 * @author mfernandez
 */
public class Ejercicio_Piscina {

    private static final String CONFIG_FILE ="piscina.config";
    private static final String CONFIG_RUTA= "objecto.txt";
    
    
    private static BookingManager bookingManager;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int long_vaso = 0;
        int ancho_vaso = 0;
        int long_parcela = 0;
        int ancho_parcela = 0;
        Piscina piscina;
        int aforo = 0;
        
        crearConfigFile();
        
        
        String clave= "max_franjas";
        String valor= Config.leerConfig(CONFIG_FILE, clave);
        System.out.println("El valor de la clave: " + clave + " es" + valor);
        
        
        
        
        

        long_vaso = IOManager.leerEnteroPositivo("Introduzca longitud de la piscina: ");
        ancho_vaso = IOManager.leerEnteroPositivo("Introduzca anchura de la piscina: ");
        long_parcela = IOManager.leerEnteroPositivo("Introduzca longitud de la parcela: ");
        ancho_parcela = IOManager.leerEnteroPositivo("Introduzca anchura de la parcela: ");

        piscina = new Piscina(long_vaso, long_parcela, ancho_vaso, ancho_parcela);
        aforo = piscina.getAforo();
        
        FilePersistencia.write(piscina, CONFIG_RUTA);

        System.out.println("El aforo de la piscina es: " + aforo + " personas");

        bookingManager = new BookingManager(piscina);
        reservar();

    }
    
    private static void crearConfigFile(){
        
        if(!Files.exists(Paths.get(CONFIG_FILE))){
            HashMap<String, String> mapa = new HashMap<>();
            mapa.put("start", "true");
            mapa.put("persistencia", "true");
            mapa.put("max_franjas", "4");
            
            Config.crearConfigFile(mapa, CONFIG_FILE);
        }
    }
/***
 * Gestiona las reservas por teclado en un bucle continuo
 * @param piscina 
 */
    private static void reservar() {

        int franja = 0;
     
        String dni = "";
        boolean isValidDni = false;
        
        
        //Repeat 
        do {

            do {
                franja = IOManager.leerEnteroPositivo("Introduzca número de franja donde quiere reservar [1-6]: ");
            } while (!Util.isInRange(BookingManager.MIN_FRANJAS, BookingManager.MAX_FRANJAS, franja));

         
            if (!bookingManager.isDisponible(franja)) {
                System.out.println("No hay plazas en la franja: " + franja);
            } else {

                do {
                    dni = IOManager.leerCadena("Introduzca dni: ");
                    isValidDni = Util.isDniValid(dni);

                    if (!isValidDni) {
                        System.out.println("El dni " + dni + " no es válido");
                    }

                } while (!isValidDni);

                try {
                    if (bookingManager.reservar(franja, dni)) {
                        System.out.println("Su reserva se ha realizado con éxito");
                    } else {
                        System.out.println("Su reserva no ha podido completarse");
                    }

                } catch (DuplicateDNIException ex) {
                    System.out.println("No se puede reservar 2 veces en el mismo día");
                } catch (Exception ex) {
                    System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
                }
            }
        } while (true);

    }

}
