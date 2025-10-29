package Tarea23;

public class Cliente extends Thread{
    private Caja caja;
    public Cliente(String nombre, Caja caja){
        super(nombre);
        this.caja = caja;
    }
    @Override
    public void run(){
        try{
            caja.entrarYPagar(this.getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
