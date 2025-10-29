package Tarea23;

import java.util.concurrent.Semaphore;

public class Caja {
    private final Semaphore cajas = new Semaphore(4);

    public void entrarYPagar(String cliente) throws InterruptedException{
        cajas.acquire();

        try {
            System.out.println(cliente + " ha entrado..");
            System.out.println("Quedan " + cajas.availablePermits() + " cajas vacías");
            Thread.sleep( (long)(Math.random() * 5000));
            System.out.println(cliente + " va a salir...");
        }finally {
            cajas.release();
        }
    }
}
