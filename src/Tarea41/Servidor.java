package Tarea41;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;

public class Servidor {
    public static void main(String[] args) throws IOException {
        //1.DEFINIR IDENTIDAD (¿Quién soy?)
        //Apuntamos al fichero .p12 que creamos con keytool
        System.setProperty("javax.net.ssl.keyStore","servidor.p12");
        System.setProperty("javax.net.ssl.keyStorePassword","123456");

        //2.CREAR EL SOCKET USANDO LA FACTORIA
        //No hacemos 'new SSLServerSocker'. Pedimos uno por defecto
        SSLServerSocketFactory factory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket server =
                (SSLServerSocket) factory.createServerSocket(8443);

        System.out.println("Servidor SSL esperando...");

        //3.ACEPTAR (el cifrado es automático)
        SSLSocket cliente = (SSLSocket) server.accept();

        //Usar Streams igual que siempre...
        cliente.getOutputStream().write("¡Hola cifrado!".getBytes());

    }
}
