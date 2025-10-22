package repaso1;

public class Main {
    public static void main(String[] args){
        Torno torno1 = new Torno("Torno 1");
        Torno torno2 = new Torno("Torno 2");
        Torno torno3 = new Torno("Torno 3");
        Torno torno4 = new Torno("Torno 4");

        torno1.start();
        torno2.start();
        torno3.start();
        torno4.start();

        try {
            torno1.join();
            torno2.join();
            torno3.join();
            torno4.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total de espectadores: " + Contador.getTotalEspectadores());
    }
}
