package Tarea37;

import java.util.Scanner;

public class Ejercicio37 {
    public static void main(String[] args){
        System.out.println("Introduzca el texto a cifrar");
        Scanner scan = new Scanner(System.in);

        String texto = scan.nextLine();

        System.out.println("Introduzca tmbn el número de desplazamiento");

        int desplazamiento = scan.nextInt();

        String resultado = cifrar(texto,desplazamiento);

        System.out.println("Texto cifrado: " + resultado);
    }

    public static String cifrar(String texto, int desplazamiento) {
        StringBuilder cifrado = new StringBuilder();

        //Por si el número es mayor de 26
        desplazamiento = desplazamiento % 26;

        for(int i=0; i<texto.length(); i++) {
            char caracter = texto.charAt(i);

            //Cifrar mayúsculas
            if(Character.isUpperCase(caracter)) {
                char newChar = (char) ('A' + (caracter - 'A' + desplazamiento + 26) % 26);
                cifrado.append(newChar);
            } else if (Character.isLowerCase(caracter)) {
                char newChar = (char) ('a' + (caracter - 'a' + desplazamiento + 26) % 26);
                cifrado.append(newChar);
            }else{
                cifrado.append(caracter);
            }
        }
        return cifrado.toString();
    }
}
