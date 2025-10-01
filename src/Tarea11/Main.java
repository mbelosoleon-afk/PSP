package Tarea11;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo 1",1);
        hilo1.start();
        try{
            hilo1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Hilo extends Thread {
    private int numero;
    private String nombre;

    public Hilo(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public void run() {
        Random random = new Random();
        if(numero < 5){
            Hilo siguienteHilo = new Hilo ("Hilo " + (numero + 1), numero + 1);
            siguienteHilo.start();
            for(int i=1; i<5;i++){
                System.out.println("Iteración " +i+ " del " + nombre);
                try {
                    int tiempo = random.nextInt(501) + 100;
                    Thread.sleep(tiempo + 1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(siguienteHilo != null) {
                try{
                    siguienteHilo.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Acabó hilo " + nombre);
        }
    }
}