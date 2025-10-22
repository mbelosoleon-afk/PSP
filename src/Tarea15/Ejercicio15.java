package Tarea15;

public class Ejercicio15 extends Thread{
    public Ejercicio15(String nombre){
        super(nombre);
    }
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Soy el hilo "+ getName() + " Iteración: "+ i);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        // Lanza los 3 hilos
        Ejercicio15 hilo3 = new Ejercicio15("Hilo3");
        Ejercicio15 hilo2 = new Ejercicio15("Hilo2");
        Ejercicio15 hilo1 = new Ejercicio15("Hilo1");
        hilo3.start();
        try {
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Programa finalizado");
    }
}