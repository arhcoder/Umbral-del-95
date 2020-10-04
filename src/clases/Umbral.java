package clases;

import java.util.Scanner;

public class Umbral {

    public static void main(String[] args) {
        
        // Variables para la simulación:
        int repeticiones = 80000;
        int contador, probabilidad, disparo, cantidades;
        String estado = "Vivo";
        int p95 = 0, p90 = 0, p85 = 0, p80 = 0, p75 = 0, p70 = 0, p65 = 0, p60 = 0, p55 = 0, p50 = 0, p00 = 0;
        Scanner scanner = new Scanner(System.in);
        
        // Pregunta por la cantidad de repeticiones.
        System.out.println("¿Cuántas veces desea repetir el juego?");
        repeticiones = scanner.nextInt();
        int[] Probabilidades = new int[repeticiones];
        
        // Inician las 10,000 repeticiones...
        System.out.println("_______________________________________\n");
        for(contador = 0; contador < repeticiones; contador++)
        {
            // Reinicia las varibales, para intentar un nuevo caso.
            estado = "Vivo";
            probabilidad = 100;
            
            // Ciclo en el que dispara hasta que esté muerto, y registra la probabilidad cuando murió.
            while(estado.equals("Vivo"))
            {
                disparo = (int) Math.floor(Math.random()* 100 + 1);
                if(disparo >= 1 && disparo <= probabilidad)
                {
                    estado = "Vivo";
                    probabilidad--;
                }
                else
                {
                    estado = "Muerto";
                    System.out.println("Probabilidad al morir: " + probabilidad+"% ["+((int)contador+1)+"]");
                    Probabilidades[contador] = probabilidad;
                }
            }
        }
        
        // Analiza el vector con los resultados, para contar los porcentajes.
        System.out.println("_______________________________________\n");
        for(int index = 100; index >= 1 ; index--)
        {
            int n = 0;
            for(int i = 0; i <= Probabilidades.length - 1; i++)
            {
                if(Probabilidades[i] == index)
                {
                    n++;
                }
            }
            if(n > 0)
            {
                System.out.println("Muertes con "+index+"% = "+n);
            }
            
            if(index <= 99 && index >= 95)
            {
                p95 += n;
            }
            else if(index <= 94 && index >= 90)
            {
                p90 += n;
            }
            else if(index <= 89 && index >= 85)
            {
                p85 += n;
            }
            else if(index <= 84 && index >= 80)
            {
                p80 += n;
            }
            else if(index <= 79 && index >= 75)
            {
                p75 += n;
            }
            else if(index <= 74 && index >= 70)
            {
                p70 += n;
            }
            else if(index <= 69 && index >= 65)
            {
                p65 += n;
            }
            else if(index <= 64 && index >= 60)
            {
                p60 += n;
            }
            else if(index <= 59 && index >= 55)
            {
                p55 += n;
            }
            else if(index <= 54 && index >= 50)
            {
                p50 += n;
            }
            else
            {
                p00+=n;
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