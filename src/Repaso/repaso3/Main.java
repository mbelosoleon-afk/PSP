package repaso3;

import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args){
        Buzon b = new Buzon();
        Cliente cliente = new Cliente(b);
        cliente.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrumpido " + e.getMessage());
        }
        Repartidor repartidor = new Repartidor(b, "Hola");
        repartidor.start();
    }
}
