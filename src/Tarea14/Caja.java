package Tarea14;

public class Caja {
    public static double capital = 1000.0;

    public synchronized static void incrementoContador() {
        Caja.capital += 10;
    }
    public synchronized static void decrementoContador() {
        Caja.capital -= 10;
    }
}
