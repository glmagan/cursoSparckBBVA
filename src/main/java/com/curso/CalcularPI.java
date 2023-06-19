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

        List<Double> estimaciones = new ArrayList<>();
        int dardosPorTrabajador = NUMERO_TOTAL_DARDOS / NUMERO_TRABAJADORES;

        // PASO 1: Calcular las estimacioones de cada trabajador
        for(int trabajador = 0; trabajador < NUMERO_TRABAJADORES; trabajador ++){ // Para cada trabajador
            estimaciones.add( CalcularPI.estimarPI(dardosPorTrabajador) );
        }
        // PASO 2: Hacer la media de las estimaciones
            // Sumo todas las estimaciones
        double estimacionDePI = 0;
        for(int trabajador = 0; trabajador < NUMERO_TRABAJADORES; trabajador ++){ // Para cada trabajador
            estimacionDePI += estimaciones.get( trabajador );
        }
            // Las divido entre el numero de trabajadores para calcular la media
        estimacionDePI = estimacionDePI / NUMERO_TRABAJADORES;

        System.out.println("Mi estimación de PI vale: " + estimacionDePI);
        // Tengo a esos 10 tios calculando en paralelo? NO... uno detrás de otro... de forma secuencial
        // Para que ese trabajo se hiciera en paralelo en una computadora, necesito: ABRIR HILOS !
    }

    public static double estimarPI(int numeroDeDardosATirar){
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
