package Tarea32;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        int puerto_servidor = 6666;
        byte[] buffer = new byte[1024];
        String[] palabras = {"Palabra","PalabraLarga","PalabraMasLarga"};


        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            DatagramSocket datagramSocket = new DatagramSocket();
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);


            String msj = Arrays.toString(palabras).trim();
            buffer = msj.getBytes();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, puerto_servidor);
            datagramSocket.send(pregunta);
            System.out.println("Enviado el mensaje al servidor");

            datagramSocket.receive(peticion);

            System.out.println("Recibo msj del servidor");

            String msjServidor = new String(peticion.getData(),0, peticion.getLength());
            System.out.println("Respuesta del servidor = " + msjServidor);

            System.out.println("La longitud de la palabra es de: " + msjServidor.length() + " caracteres");

        } catch (SocketException ex) {
            System.out.println("Error: "+ ex.getMessage());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}