package Tarea19;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Escriba el texto");
        String texto = scan.next();

        Hilo h1 = new Hilo(texto,'a');
        Hilo h2 = new Hilo(texto,'e');
        Hilo h3 = new Hilo(texto,'i');
        Hilo h4 = new Hilo(texto,'o');
        Hilo h5 = new Hilo(texto,'u');

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        try{
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        }catch (InterruptedException e){
            System.out.println("Hilo interrumpido");
        }
        System.out.println("Total de vocales que tiene la palabra: "+ Contador.contador);
        scan.close();
    }
}

