package Tarea12;

import com.sun.source.doctree.SummaryTree;

public class Hilo extends Thread{
        public Hilo(String nombre){
            super(nombre);
        }

        @Override
    public void run() {
        if(getName().equalsIgnoreCase("Par")){
                for(int i=0; i<1924; i++){
                    if(i % 2 == 0){
                        System.out.println("Hilo par: " + i );
                    }
                }
            }
            if(getName().equalsIgnoreCase("Impar")){
                for(int i=0; i<1924; i++){
                    if(i % 2 != 0){
                        System.out.println("Hilo impar: " + i );
                    }
                }
            }
            if(getName().equalsIgnoreCase("Otro")){
                for(int i=0; i<1924; i++){
                    int n = i%10;
                    if(n==3 || n==4){
                        System.out.println("Hilo otro: " + i );
                    }
                }
            }
        }

        public static void main(String[] args){
            new Hilo("Par").start();
            new Hilo("Impar").start();
            new Hilo("Otro").start();
        }
}
