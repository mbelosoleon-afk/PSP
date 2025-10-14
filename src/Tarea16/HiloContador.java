package Tarea16;

public class HiloContador extends Thread{
    private Contador contador;
    public HiloContador(Contador c) {
        this.contador = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            contador.incrementar();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }
}