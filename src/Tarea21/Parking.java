package Tarea21;

import java.util.concurrent.Semaphore;

public class Parking {
    //Creamos semáforo con 5 plazas
    private final Semaphore plazas = new Semaphore(5);

    public void entrar(String coche) throws InterruptedException {
        //Pide un permiso (plaza). Si no hay, espera
        plazas.acquire();

        try{
            //---INICIO DE SESIÓN CRÍTICA (simulada)---
            System.out.println(coche + " ha entrado");
            System.out.println("Quedan " + plazas.availablePermits() + "plazas libres");
            Thread.sleep( (long)(Math.random() * 5000) );
            System.out.println(coche + " va a salir...");
            //---FIN DE SECCIÓN CRÍTICA---
        }finally {
            //Libera el permiso (plaza)
            plazas.release();
        }
    }
}
