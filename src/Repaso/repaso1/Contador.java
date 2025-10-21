package repaso1;

public class Contador {
    private int totalEspectadores = 0;

    public synchronized void incrementar() {
        totalEspectadores++;
    }

    public int getTotalEspectadores() {
        return totalEspectadores;
    }
}
