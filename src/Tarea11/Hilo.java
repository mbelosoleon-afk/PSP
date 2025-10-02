package Tarea11;

import java.util.Random;
import java.util.Scanner;

public class Hilo extends Thread{
    private int numero;
    private String nombre;
    private int limite;
    private int iteracion;

    public Hilo(String nombre, int numero, int limite, int iteracion) {
        this.nombre = nombre;
        this.numero = numero;
        this.limite = limite;
        this.iteracion = iteracion;
    }

    @Override
    public void run() {
        Random random = new Random();
        if(numero <= limite){
            Hilo siguienteHilo = new Hilo ("Hilo " + (numero + 1), numero + 1, limite, iteracion);
            siguienteHilo.start();
            for(int i=1; i<iteracion;i++){
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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nHilos;
        int iteraciones = 0;
        System.out.println("Elija el número de hilos");
        if(scan.hasNext()){
            nHilos = scan.nextInt();
            if(nHilos == 1){
                System.out.println("Ha introducido " +nHilos+ " numero de hilos");
            }else{
                System.out.println("Ha introducido " +nHilos+ " numeros de hilos");
            }
           System.out.println("Elija el número de iteraciones por hilo");
            iteraciones = scan.nextInt();
            if(iteraciones == 1){
                System.out.println("Ha introducido " +iteraciones+ " iteración por hilo");
            }else{
                System.out.println("Ha introducido " +iteraciones+ " iteraciones por hilo");
            }
        }else{
            System.out.println("No ha introducido número, se le asignará un 5 al valor");
            nHilos = 5;
        }

        if(nHilos >= 1){
            new Hilo("Hilo 1",1,nHilos,iteraciones).start();
        }
        scan.close();
    }
}