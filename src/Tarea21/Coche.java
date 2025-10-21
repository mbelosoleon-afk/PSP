package Tarea21;

import java.util.ArrayList;

public class Coche extends Thread{
    ArrayList parking = new ArrayList(5);
    String nombre;
    int numero;
    int plazasVacias;

    public Coche(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public void run() {

    }
}
