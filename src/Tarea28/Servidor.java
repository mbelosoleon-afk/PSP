package Tarea28;

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

            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            System.out.println("Servidor multihilo esperando clientes...");

            while (true){
                //Acepta la conexión
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");

                //Crea un hilo (una "ventanilla") y le pasa el cliente
                GestorClientes hilo = new GestorClientes(cliente);
                hilo.start();


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
