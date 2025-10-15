package Tarea19;

public class Hilo extends Thread{
    private String textoVocales;
    private char letra;
    public Hilo(String texto, char letra){
        this.textoVocales = texto;
        this.letra = letra;
    }
    @Override
    public void run() {
        char[]textoChar = textoVocales.toCharArray();
        for(char vocal : textoChar){
            if(letra == vocal){
                Contador.contador();
            }
        }
    }
}
