package repaso2;

import javax.print.attribute.standard.Copies;

public class Main {
private static final Object miLockPieza = new Object();
private static final Object miLockPintura = new Object();
private static final Object miLockEmbalaje = new Object();

        static class T {
            void Tarea1(){
                synchronized (miLockPieza){
                    Pieza p = new Pieza();
                    p.CogerPieza();
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
            void Tarea2(){
                synchronized (miLockPintura){
                    Pieza p = new Pieza();
                    p.PintarPieza();
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
            void Tarea3(){
                synchronized (miLockEmbalaje){
                    Pieza p = new Pieza();
                    p.EmbalandoPieza();
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    static T t = new T();

        static Thread operario1 = new Thread(()->t.Tarea1(),"operario 1");
        static Thread operario2 = new Thread(()->t.Tarea2(),"operario 2");
        static Thread operario3 = new Thread(()->t.Tarea3(),"operario 3");

        public static void main(String[] args){
            System.out.println(operario1.getName());
            operario1.start();
            try{
                operario1.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(operario2.getName());
            operario2.start();
            try{
                operario2.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(operario3.getName());
            operario3.start();
            try{
                operario3.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Pieza lista para lanzar");
        }
}
