package Tarea19;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Escriba el texto");
        String texto = scan.next();
        scan.close();
        System.out.println(contadorVocales(texto,"a"));
    }

    public static int contadorVocales(String texto,String letra){
        int contador = 0;
        for(int i=0; i<texto.length(); i++){
            char character = texto.charAt(i);
            if(letra.indexOf(character) != -1){
                contador++;
            }
        }
        return contador;
    }
}

