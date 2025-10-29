package Tarea23;

public class Cliente extends Thread{
    SuperMercado superMercado;

    public Cliente(SuperMercado mercado){
        superMercado = mercado;
    }
    @Override
    public void run(){
        superMercado.entrarCaja();
    }
}
