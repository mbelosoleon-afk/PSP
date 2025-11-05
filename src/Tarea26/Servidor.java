package Tarea26;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.ECField;

public class Servidor {
    public static void main(String[] args){
        try{
            //InetSocketAddress nos permite encapsular dirección y puerto
            InetSocketAddress dir = new InetSocketAddress("localhost",6666);

            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            System.out.println("Esperando conexiones...");
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado");

            //"Envolvemos" el OutputStream
            //El 'true' activa el "autoflush"
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);

            //Enviamos el mensaje al cliente
            escritor.println("Respuesta 1");
            escritor.println("Respuesta 2");
            escritor.println("Respuesta 3");

            socket.close();
            servidor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
