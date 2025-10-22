package Tarea19;

public class Hilo implements Runnable {
    private final Vocales contadorVocales;
    private final String texto;
    private final char vocal;

    public Hilo(Vocales contadorVocales, String texto, char vocal) {
        this.contadorVocales = contadorVocales;
        this.texto = texto;
        this.vocal = vocal;
    }

    @Override
    public void run() {
        int contador = 0;
        for (char letra : texto.toCharArray()) {
            if (letra == vocal) {
                contador++;
            }
        }
        contadorVocales.sumarVocales(contador);
    }
}