package Tarea23;

public class Main {
    public static void main(String[] args){
        Caja caja = new Caja();

        Cliente cliente1 = new Cliente("Cliente 1",caja);
        Cliente cliente2 = new Cliente("Cliente 2",caja);
        Cliente cliente3 = new Cliente("Cliente 3",caja);
        Cliente cliente4 = new Cliente("Cliente 4",caja);
        Cliente cliente5 = new Cliente("Cliente 5",caja);
        Cliente cliente6 = new Cliente("Cliente 6",caja);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
    }
}
