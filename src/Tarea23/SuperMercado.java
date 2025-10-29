package Tarea23;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SuperMercado {
    private Semaphore cajas;
    int numeroClientes;
    static AtomicInteger Resultados = new AtomicInteger();
    public SuperMercado(int numeroCajas,int numeroClientes) {
        cajas = new Semaphore(numeroCajas);
        this.numeroClientes = numeroClientes;
    }

    public void entrarCaja(){
        try{
            cajas.acquire();
            Thread.sleep(100);
            int importe = (int) Math.floor(Math.random()*(10-2)*12);
            Resultados.addAndGet(importe);
        }catch (InterruptedException e){
            System.out.println("Fallo en la compra");
        }finally {
            cajas.release();
        }
    }
}
