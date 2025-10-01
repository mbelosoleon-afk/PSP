package Tarea10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        new Hilos("Hilo 1").start();
        new Hilos("Hilo 2").start();
        new Hilos("Hilo 3").start();
        new Hilos("Hilo 4").start();
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

