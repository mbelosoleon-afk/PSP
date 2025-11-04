package Tarea24;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String direccion = scan.nextLine();
        System.out.println("Escriba la dirección");
        try{
            InetAddress ip = InetAddress.getByName(direccion);
            System.out.println(ip.getHostName() + " - " + ip.getHostAddress());

        }catch(UnknownHostException e){
            System.out.println("Host no encontrado: " + e.getLocalizedMessage());
        }
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Local: " + local.getHostName() + " - " + local.getHostAddress());
        }catch (UnknownHostException e){
            System.out.println("Host local no encontrado: " + e.getLocalizedMessage());
        }
    }
}