package Ejercicios_Json;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

import POJOS.RespuestaCines;
import POJOS.Cine;
import POJOS.Peliculas;
import POJOS.Sesiones;

public class Ejer_Gestion_Cines {

    public static void main(String[] args) {
        Gson gson = new Gson();
        
        try {
        	//inicializamos el lector con la ruta del json
        	FileReader lector = new FileReader("src/json/cines.json");
        
            // Mapeamos el JSON a la clase raíz RespuestaCines
            RespuestaCines datos = gson.fromJson(lector, RespuestaCines.class);
            
            // =========================================================================
            // Mostrar por consola el nombre de todos los cines
            // =========================================================================
            System.out.println("Cines disponibles:");
            for (Cine miCine : datos.getCines()) {
            	//saco el nombre del cine con el getter
                System.out.println(miCine.getNombre());
            }
            //salto de linea
            System.out.println();

            // =========================================================================
            // BÚSQUEDA 1: Mostrar todas las películas disponibles en "Cines Golem"
            // =========================================================================
            System.out.println("=== BÚSQUEDA 1 ===");
            for (Cine miCine : datos.getCines()) {
                if (miCine.getNombre().equalsIgnoreCase("Cines Golem")) {
                    System.out.println(miCine.getNombre());
                    for (Peliculas peli : miCine.getPeli()) {
                        System.out.println("  " + peli.getTitulo());
                    }
                }
            }
            System.out.println();

            // =========================================================================
            // BÚSQUEDA 2: Buscar la película "Avatar" y mostrar sus sesiones
            // =========================================================================
            System.out.println("=== BÚSQUEDA 2 ===");
            boolean encontradaAvatar = false;
            for (Cine miCine : datos.getCines()) {
                for (Peliculas peli : miCine.getPeli()) {
                    if (peli.getTitulo().equalsIgnoreCase("Avatar")) {
                        if (!encontradaAvatar) {
                            System.out.println("Película: " + peli.getTitulo());
                            // Para evitar repetir el título de la película si estuviera en más cines
                            encontradaAvatar = true; 
                        }
                        for (Sesiones sesion : peli.getSesion()) {
                            System.out.println("  Hora: " + sesion.getHora() + 
                                               " | Sala: " + sesion.getSala() + 
                                               " | Precio: " + sesion.getPrecio() + " €");
                        }
                    }
                }
            }
            System.out.println();

            // =========================================================================
            // BÚSQUEDA 3: Mostrar películas de ciencia ficción en todos los cines
            // =========================================================================
            System.out.println("=== BÚSQUEDA 3 ===");
            System.out.println("Películas de ciencia ficción");
            for (Cine miCine : datos.getCines()) {
                for (Peliculas peli : miCine.getPeli()) {
                    if (peli.getGenero().equalsIgnoreCase("Ciencia ficción")) {
                        System.out.println("  " + miCine.getNombre() + " -> " + peli.getTitulo());
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error al procesar o leer el archivo JSON: " + e.getMessage());
        }
    }
}
