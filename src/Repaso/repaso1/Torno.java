package repaso1;

import java.util.Random;

public class Torno extends Thread{
    private int asistentes_por_torno = 1000;
    private String nombre;
    public int contador;
    Random random = new Random();

    public Torno(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for(contador=1; contador<asistentes_por_torno; contador++){
            try {
                long tiempo = random.nextInt(10) + 1;
                Thread.sleep(tiempo);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            Contador.incrementar();
            System.out.println("Han entrado " + contador + " en el " + nombre);
        }
        System.out.println(nombre + " lleno");

    }
}
