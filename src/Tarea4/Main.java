package Tarea4;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Scanner menu = new Scanner(System.in);
            System.out.println("Escribe su comando");
            String entrada = menu.nextLine();

            String[] comando = entrada.split("\\s+");

            ProcessBuilder pBloc = new ProcessBuilder(comando);
            pBloc.inheritIO();
            Process p = pBloc.start();
        } catch (IOException e) {
            System.out.println("Erorr: " + e.getMessage());
        }
    }
}