package Tarea14;

public class Hilo extends Thread{
    public Hilo(String nombre){
        super(nombre);
    }

    @Override
    public void run(){
        if(getName().equalsIgnoreCase("Ingreso")){
            for(int i=0; i<=5000; i++){
                Caja.incrementoContador();
                System.out.println("Saldo de la caja: " + Caja.capital);
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        if(getName().equalsIgnoreCase("Venta")){
            for(int i=0; i<=3000; i++){
                Caja.decrementoContador();
                System.out.println("Saldo de la caja: " + Caja.capital);
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        Hilo ingreso = new Hilo("Ingreso");
        Hilo venta = new Hilo("Venta");

        ingreso.start();
        venta.start();

        try{
            ingreso.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
