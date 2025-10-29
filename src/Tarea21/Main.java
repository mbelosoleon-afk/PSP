package Tarea21;

public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking();

        Coche coche1 = new Coche("Coche 1",parking);
        Coche coche2 = new Coche("Coche 2",parking);
        Coche coche3 = new Coche("Coche 3",parking);
        Coche coche4 = new Coche("Coche 4",parking);
        Coche coche5 = new Coche("Coche 5",parking);
        Coche coche6 = new Coche("Coche 6",parking);
        Coche coche7 = new Coche("Coche 7",parking);

        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();
        coche6.start();
        coche7.start();

    }
}
