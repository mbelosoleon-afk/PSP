package Tarea8;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {
        new Profesor("Diego",4).start();
        new Profesor("Manuel",5).start();
        new Profesor("Damian",3).start();
        new Profesor("Araujo",5).start();
    }
}

class Profesor extends Thread{
    private final String nombre;
    private final int limite;
    private int nivelCabreo = 0;
    public Profesor(String nombre,int limite) {
        this.nombre = nombre;
        this.limite = limite;
    }

    @Override
    public void run() {
        while(nivelCabreo<limite){
            System.out.println("[ " + nombre + " ] nivel de Cabreo: " + nivelCabreo);
            nivelCabreo++;
        }
        System.out.println("[ " + nombre + " ] nivel de Cabreo: " + nivelCabreo + "He llegado a mi limite");
    }
}