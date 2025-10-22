package Tarea19;

class Vocales {
    private int totalDeVocales = 0;

    public int getContadorVocales() {
        return totalDeVocales;
    }

    public synchronized void sumarVocales(int cantidad) {
        totalDeVocales += cantidad;
    }
}
