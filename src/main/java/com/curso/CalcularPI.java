package com.curso;

import java.util.ArrayList;
import java.util.List;

public class CalcularPI {

    public static void main(String[] args) {

        // Tengo a un hilo (persona) ejecutando ese código para 2000 Millones de dardos
        // Podría tener a 10 personas haciendo su estimación para 200Millones...
        // Y luego hacer la media de las estimaciones
        int NUMERO_TOTAL_DARDOS = 200 * 1000 * 1000;
        int NUMERO_TRABAJADORES = 10;
        
        int dardosPorTrabajador = NUMERO_TOTAL_DARDOS / NUMERO_TRABAJADORES;
        
        double estimacionDePI = IntStream.range(0, NUMERO_TRABAJADORES)
                .map(trabajador -> dardosPorTrabajador)
                .parallel()
                .mapToDouble(CalcularPi::estimarPi).sum()/NUMERO_TRABAJADORES;

        System.out.println("Mi estimación de PI vale: " + estimacionDePI);
    }

    public static double estimarPI(double numeroDeDardosATirar){
        int numeroDardosDentro = 0;

        for (int dardo = 0; dardo < numeroDeDardosATirar; dardo++) { // Haz un millón de veces
            double x = Math.random();
            double y = Math.random();

            double distanciaAlCentro = Math.sqrt(x * x + y * y);
            if (distanciaAlCentro <= 1) numeroDardosDentro++;
        }

        return 4. * numeroDardosDentro / numeroDeDardosATirar;

    }

}
