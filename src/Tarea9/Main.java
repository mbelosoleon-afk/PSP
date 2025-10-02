package Tarea9;

    public class Main extends Thread{


        public final int fibonacci;
        public Main(int nveces) {
            this.fibonacci = nveces ;
        }

        // Definimos lo que hace el hilo
        @Override
        public void run() {
            int a = 1, b = 1, c;
            System.out.print("Fibonacci nveces " + fibonacci + ": ");
            for (int i = 0; i < fibonacci; i++) {
                System.out.print(a + " ");
                c = a + b;
                a = b;
                b = c;
            }

            System.out.println("\nPrograma terminado");
        }


        public static void main(String[] args) {
            new Main(10).start();
        }
    }