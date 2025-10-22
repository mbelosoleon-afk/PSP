package Tarea19;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = scanner.nextLine().toLowerCase();

        Vocales contador = new Vocales();

        Thread hiloA = new Thread(new Hilo(contador, texto, 'a'));
        Thread hiloE = new Thread(new Hilo(contador, texto, 'e'));
        Thread hiloI = new Thread(new Hilo(contador, texto, 'i'));
        Thread hiloO = new Thread(new Hilo(contador, texto, 'o'));
        Thread hiloU = new Thread(new Hilo(contador, texto, 'u'));

        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();

        hiloA.join();
        hiloE.join();
        hiloI.join();
        hiloO.join();
        hiloU.join();

        System.out.println("Total de vocales: " + contador.getContadorVocales());
        scanner.close();
    }
}