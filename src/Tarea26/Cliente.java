package Tarea26;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args){
        InetSocketAddress dir = new InetSocketAddress("localhost",6666);

        try{
            Socket socket = new Socket();
            socket.connect(dir);

            System.out.println("Conectado al servidor");

            //"Envolvemos" el InputStream
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            //Leemos la respuesta (línea bloqueante)
            String mensaje1 = lector.readLine();
            String mensaje2 = lector.readLine();
            String mensaje3 = lector.readLine();
            System.out.println("Servidor dice: " + mensaje1);
            System.out.println("Servidor dice: " + mensaje2);
            System.out.println("Servidor dice: " + mensaje3);

            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
