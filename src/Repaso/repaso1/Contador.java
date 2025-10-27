package repaso1;

public class Contador {
    private static int totalEspectadores = 0;

    public static int getTotalEspectadores() {
        return totalEspectadores;
    }

    public static synchronized void incrementar() {
        totalEspectadores++;
    }
}
