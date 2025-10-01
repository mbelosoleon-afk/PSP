package Tarea10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Hilos hilo1 = new Hilos("Hilo 1");
        Hilos hilo2 = new Hilos("Hilo 2");
        Hilos hilo3 = new Hilos("Hilo 3");
        Hilos hilo4 = new Hilos("Hilo 4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}

class Hilos extends Thread {

    private String nombre;
    public Hilos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(int i=0; i<10; i++){
            System.out.println("Iteración " + i + " del hilo " + nombre);
            try {
                int tiempo = random.nextInt(10) + 1;
                Thread.sleep(tiempo * 1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

