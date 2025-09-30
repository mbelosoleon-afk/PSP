package Tarea3PSP;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner name = new Scanner(System.in);
            System.out.println("Introduzca el archivo que quieras abrir");
            String archivo = name.nextLine();

            if(archivo.isEmpty()){
                archivo = "Sin título";
            }else{

            }

            System.out.println("Introduzca la ruta");
            String ruta = name.nextLine().trim();

            ProcessBuilder pBloc = new ProcessBuilder("gnome-text-editor",archivo);

            if(!ruta.isEmpty()){
                pBloc.directory(new File(ruta));
            }else{

            }
            Process p = pBloc.start();
        }catch(IOException e){
            System.out.println("Error");
        }

    }
}