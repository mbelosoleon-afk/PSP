package Tarea15;

public class Ejercicio15 extends Thread{
    private String nombre;
    private Thread hiloanterior;
    public Ejercicio15(String nombre, Thread hiloanterior){
        this.nombre = nombre;
        this.hiloanterior = hiloanterior;
    }

    @Override
    public void run(){
        if(hiloanterior != null) {
            try {
                hiloanterior.join();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("Error");
            }
        }else {

        }
        for(int i=0; i<8;i++){
            System.out.println("Soy el Hilo " + nombre + " - Iteracion: " + i);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Ejercicio15 hilo3 = new Ejercicio15("1", null);
        Ejercicio15 hilo2 = new Ejercicio15("2",hilo3);
        Ejercicio15 hilo1 = new Ejercicio15("3",hilo2);

        hilo3.start();
        hilo2.start();
        hilo1.start();

        try{
            hilo1.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Programa principal terminado");
    }
}