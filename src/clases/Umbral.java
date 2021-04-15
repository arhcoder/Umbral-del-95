package clases;

import java.util.Scanner;

// Hecho por @arhcoder.

public class Umbral {

    public static void main(String[] args) {
        
        // Variables para la simulación:
        int repeticiones = 80000;
        int i, porcentaje, disparo;
        boolean vivo;
        int p95 = 0, p90 = 0, p85 = 0, p80 = 0, p75 = 0, p70 = 0, p65 = 0, p60 = 0, p55 = 0, p50 = 0, p00 = 0;
        Scanner scanner = new Scanner(System.in);
        
        // Muertes[100] guarda en cada índice correspondiente a un porcentaje, la cantidad de muertes en dicho porcentaje //
        int[] Muertes = new int[101];
        
        // Pregunta por la cantidad de repeticiones.
        System.out.println("¿Cuántas veces desea repetir el juego?");
        repeticiones = scanner.nextInt();
        
        // Inician las n repeticiones...
        System.out.println("_______________________________________\n");
        for(i = 1; i <= repeticiones; i++)
        {
            // Reinicia las varibales, para intentar un nuevo caso.
            vivo = true;
            porcentaje = 100;
            
            // Ciclo en el que dispara hasta que esté muerto, y registra la probabilidad cuando murió.
            while(vivo)
            {
                disparo = (int) Math.floor(Math.random()* 100 + 1);
                if(disparo >= 1 && disparo <= porcentaje)
                {
                    porcentaje--;
                }
                else
                {
                    vivo = false;
                    System.out.println("["+((int)i)+"]\t\tPorcentaje al morir: " + porcentaje + "%");
                    Muertes[porcentaje]++;
                }
            }
        }
        
        // Analiza el vector con los resultados, para contar los porcentajes.
        System.out.println("_______________________________________\n");
        for(int index = 100; index >= 1 ; index--)
        {
            System.out.println("Muertes con "+index+"% = "+Muertes[index]);
            
            if(index <= 99 && index >= 95)
            {
                p95 += Muertes[index];
            }
            else if(index <= 94 && index >= 90)
            {
                p90 += Muertes[index];
            }
            else if(index <= 89 && index >= 85)
            {
                p85 += Muertes[index];
            }
            else if(index <= 84 && index >= 80)
            {
                p80 += Muertes[index];
            }
            else if(index <= 79 && index >= 75)
            {
                p75 += Muertes[index];
            }
            else if(index <= 74 && index >= 70)
            {
                p70 += Muertes[index];
            }
            else if(index <= 69 && index >= 65)
            {
                p65 += Muertes[index];
            }
            else if(index <= 64 && index >= 60)
            {
                p60 += Muertes[index];
            }
            else if(index <= 59 && index >= 55)
            {
                p55 += Muertes[index];
            }
            else if(index <= 54 && index >= 50)
            {
                p50 += Muertes[index];
            }
            else
            {
                p00+=Muertes[index];
            }
        }
        System.out.println("_______________________________________\n");
        
        // Imprime los rangos de procentajes.
        System.out.println("Muertes entre el 99% y el 95% = "+p95);
        System.out.println("Muertes entre el 94% y el 90% = "+p90);
        System.out.println("Muertes entre el 89% y el 85% = "+p85);
        System.out.println("Muertes entre el 84% y el 80% = "+p80);
        System.out.println("Muertes entre el 79% y el 75% = "+p75);
        System.out.println("Muertes entre el 74% y el 70% = "+p70);
        System.out.println("Muertes entre el 69% y el 65% = "+p65);
        System.out.println("Muertes entre el 64% y el 60% = "+p60);
        System.out.println("Muertes entre el 59% y el 55% = "+p55);
        System.out.println("Muertes entre el 54% y el 50% = "+p50);
        System.out.println("Muertes entre el 49% y el  0% = "+p00);
        System.out.println("\nRepeticiones ejecutadas: " + repeticiones);
        System.out.println("_______________________________________\n");
    }
}