package Tarea25;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion;
        String ip;
        ArrayList<String> resumen = new ArrayList<>();
        while(true){
            System.out.println("Indica la IP");
            ip = scan.next();
            System.out.println("Elige un puerto: 1:21, 2:22, 3:80, 4:443, 5:Otro, 6:Salir");
            opcion = scan.nextInt();
            switch (opcion){
                case 1 -> opcion = 21;
                case 2 -> opcion = 22;
                case 3 -> opcion = 80;
                case 4 -> opcion = 443;
                case 5 -> opcion = pedirPuerto(scan);
                default -> opcion = -1;
            }
            if(opcion<=0) break;
            try{
                Socket socket = new Socket(ip,opcion);
                resumen.add("IP: " + ip + " Puerto: " + opcion + " Abierto");
                socket.close();
            }catch (UnknownHostException e){
                System.out.println("Host desconocido: " + e.getLocalizedMessage());
            }catch (IOException e){
                resumen.add("IP: "+ip+" Puerto: "+opcion+" Cerrado");
            }
            System.out.println(resumen);
        }
    }
    private static int pedirPuerto(Scanner scan){
        System.out.println("Elige el puerto a conectar");
        int puerto;
        puerto = scan.nextInt();
        return puerto;
    }
}