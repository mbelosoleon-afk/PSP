package Tarea16;

public class Ejercicio16 {
    public static void main(String[] args) throws InterruptedException {
        Contador contadorCompartido = new Contador();

        Thread h1 = new HiloContador(contadorCompartido);
        Thread h2 = new HiloContador(contadorCompartido);
        Thread h3 = new HiloContador(contadorCompartido);
        Thread h4 = new HiloContador(contadorCompartido);
        Thread h5 = new HiloContador(contadorCompartido);

        h1.start(); h2.start(); h3.start(); h4.start(); h5.start();


        h1.join(); h2.join(); h3.join(); h4.join(); h5.join();

        System.out.println("Valor final del contador: " + contadorCompartido.obtenerValor());
    }
}

