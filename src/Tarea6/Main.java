package Tarea6;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Scanner menu = new Scanner(System.in);
            String entrada = "";

            while(true){
                System.out.println("Escriba su dirección IP o salir para cerrar");
                entrada = menu.nextLine();
                if(entrada.equals("salir")){
                    System.out.println("Saliendo del programa");
                    break;
                }else {
                    ProcessBuilder pBloc = new ProcessBuilder("ping","-c","4",entrada);
                    pBloc.inheritIO();
                    Process p = pBloc.start();
                    int exitCode = p.waitFor();
                }
            }
        }catch(IOException e) {
            System.err.println("Error: " + e.getMessage());
        }catch(InterruptedException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}