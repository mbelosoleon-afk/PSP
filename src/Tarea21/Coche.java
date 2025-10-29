package Tarea21;

import java.util.ArrayList;

public class Coche extends Thread{
    private Parking parking;
    public Coche(String nombre, Parking parking){
        super(nombre);
        this.parking = parking;
    }
    @Override
    public void run(){
        try{
            parking.entrar(this.getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
