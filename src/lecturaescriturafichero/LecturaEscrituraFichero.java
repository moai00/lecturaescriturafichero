/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturafichero;

import java.io.File;
import static java.lang.Float.parseFloat;
import java.util.Scanner;

/**
 *
 * @author usu21
 */
public class LecturaEscrituraFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File("hola.txt");
        Scanner s = null;
        int linia = 0;
        float total = 0;
        float total2 = 0;

        float max1 = 0;
        float max2 = 0;
        float min1 = 1;
        float min2 = 1;

        try {
            // Leemos el contenido del fichero
            System.out.println("... Leemos el contenido del fichero ...");
            s = new Scanner(fichero);
            // Leemos linea a linea el fichero

            while (s.hasNext()) {

                String linea = s.nextLine(); 	// Guardamos la linea en un float

                //System.out.println(linea);      // Imprimimos la linea
                String[] parts = linea.split("\t");
                String col1 = parts[0];
                String col2 = parts[1];
                System.out.println(col1 + "\t" + col2);

                total = total + parseFloat(col1);
                total2 = total2 + parseFloat(col2);
                linia++;
                if (parseFloat(col1) > max1) {
                    max1 = parseFloat(col1);
                }
                if (parseFloat(col1) < min1) {
                    min1 = parseFloat(col1);
                }
                if (parseFloat(col2) < min2) {
                    min2 = parseFloat(col2);
                }
                if (parseFloat(col2) > max2) {
                    max2 = parseFloat(col2);
                }

            }

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }

        System.out.println("mitjana columna 1 = " + total / linia);
        System.out.println("mitjana columna 2 = " + total2 / linia);
        System.out.println("el maximo de la primera columna es " + max1);
        System.out.println("el maximo de la segunda columna es " + max2);
        System.out.println("el minimo de la primera columna es " + min1);
        System.out.println("el minimo de la segunda columna es " + min2);

    }

}
