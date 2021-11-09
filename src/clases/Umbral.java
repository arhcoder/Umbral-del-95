package clases;

import java.util.Scanner;

// Hecho por @arhcoder.

public class Umbral
{

    public static void main(String[] args)
    {
        
        // Variables para la simulación:
        int repeticiones;
        int i, porcentaje, disparo;
        boolean vivo;
        Scanner scanner = new Scanner(System.in);
        
        // Muertes[100] guarda en cada índice correspondiente a un porcentaje,
        // la cantidad de muertes en dicho porcentaje.
        // 1% se guarda en Muertes[0]; 100% en [99].
        int[] Muertes = new int[100];
        
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
                    Muertes[porcentaje - 1]++;
                }
            }
        }
        
        // Se imprime la cantidad de muertes en cada porcentaje.
        System.out.println("\n\n\n\n");
        for (i = 100 - 1; i >= 0; i--)
        {
            System.out.print("" + Muertes[i] + "\n");
        }
    }
}