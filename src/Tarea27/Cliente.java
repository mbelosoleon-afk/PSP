package Tarea27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args){
        InetSocketAddress dir = new InetSocketAddress("localhost",6666);
        Scanner scan = new Scanner(System.in);
        String mensaje;
        String respuesta;

        try{
            Socket cliente = new Socket();
            cliente.connect(dir);

            System.out.println("Conectado");
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            while (true){
                System.out.println("Escribe un mensaje");
                mensaje = scan.nextLine();
                escritor.println(mensaje);
                respuesta = lector.readLine();
                System.out.println(respuesta);
                if(mensaje.equalsIgnoreCase("adios")){
                    break;
                }
            }
            cliente.close();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
