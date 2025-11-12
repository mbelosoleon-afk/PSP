package Tarea28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorClientes extends Thread{
    private Socket socket;

    String mensaje;
    String respuesta;

    public GestorClientes(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        //try-with cierra streams automáticamente
        try(
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true)
        ) {
            while (true){
                mensaje = lector.readLine();
                if(mensaje == null || mensaje.equalsIgnoreCase("adios")){
                    break;
                }
                respuesta = "ECO: " + mensaje;
                escritor.println(respuesta);
            }
            System.out.println("El servidor ha respondido");
        }catch (IOException e){
            System.out.println("Error con el cliente: " + e.getMessage());
        }finally {
            try{
                socket.close();
                System.out.println("Cliente desconectado");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
