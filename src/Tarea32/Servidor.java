package Tarea32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 6666;
        byte[] buffer = new byte[1024];

        try (DatagramSocket datagramSocket = new DatagramSocket(puerto)){
            System.out.println("Servidor arrancando");

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            datagramSocket.receive(peticion);
            System.out.println("Recibida peticion");

            String msj = new String(peticion.getData(), 0, peticion.getLength());
            System.out.println("listado de palabras = " + msj);

            msj=msj.replace("[","");
            msj=msj.replace("]","");
            String[] palabras = msj.split(",");
            String palabraLarga = palabras[0];
            for (String palabra:palabras){
                if (palabraLarga.length()<palabra.length()) palabraLarga = palabra;
            }

            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();

            String msjServidor = palabraLarga;
            buffer = msjServidor.getBytes();
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
            datagramSocket.send(respuesta);
            System.out.println("Envié respuesta al cliente");

        } catch (SocketException ex) {
            System.out.println("Error: "+ ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
}