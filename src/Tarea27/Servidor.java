package Tarea27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args){
        try{
            InetSocketAddress dir = new InetSocketAddress("localhost",6666);

            String mensaje;
            String respuesta;

            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            System.out.println("Esperando conexiones...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");

            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);

            while (true){
                mensaje = lector.readLine();
                respuesta = "ECO: " + mensaje;
                escritor.println(respuesta);
                if(mensaje == null || mensaje.equalsIgnoreCase("adios")){
                    break;
                }
            }

            System.out.println("El servidor ha respondido");

            cliente.close();
            servidor.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
