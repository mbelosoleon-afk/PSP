package Tarea13;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hilo MaxP = new Hilo("Hilo 1");
        Hilo MinP = new Hilo("Hilo 2");
        Hilo hilo1 = new Hilo("Hilo 3");
        Hilo hilo2 = new Hilo("Hilo 4");

        MaxP.setPriority(Thread.MAX_PRIORITY);
        MinP.setPriority(Thread.MIN_PRIORITY);
        hilo1.setPriority(Thread.NORM_PRIORITY);
        hilo2.setPriority(Thread.NORM_PRIORITY);

        MaxP.start();
        MinP.start();
        hilo1.start();
        hilo2.start();

    }
}

class Hilo extends Thread {
    private String nombre;
    public Hilo(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(int i=0; i<=10; i++){
            System.out.println("Iteración: " + i + " del hilo " + nombre);
            try {
                int tiempo = random.nextInt(10) + 1;
                Thread.sleep(tiempo * 1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}