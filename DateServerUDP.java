package ec.edu.epn.redes.date.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;


public class DateServerUDP {

private static int PORT = 9091;
	
	/**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
    
    	DatagramSocket serverSocket = new DatagramSocket(PORT);
    	System.err.println("Server listening on port " + PORT + " using UDP connection\n");
    	long initialTime = System.currentTimeMillis();
    	System.out.println("Tiempo Inicial: "+initialTime+"\n");
    	 
    	try {
            while (true) {
            	//Receive packet
            	byte bufferReceive[] = new byte[128];
	            DatagramPacket receivePacket = new DatagramPacket(bufferReceive, bufferReceive.length);
	            serverSocket.receive(receivePacket);          
	            InetAddress clientAdress = receivePacket.getAddress();
	            int clientPort = receivePacket.getPort();
	            System.out.println("Client port: "+clientPort+"\n");
	            
	            //Send packet
	            byte bufferSend[] = "hola Graci soy May".getBytes(); //Cambiar por el nombre del estudiante que corresponda
	            DatagramPacket sendPacket = new DatagramPacket(bufferSend,bufferSend.length,clientAdress,clientPort);
	            long endTime = System.currentTimeMillis();
	            System.out.println("Tiempo Final: "+endTime+"\n");
	            long sendTime = endTime-initialTime;
	            System.out.println("Envia el paquete en: "+sendTime+" ms\n");
	            serverSocket.send(sendPacket);
	            
            }
        }
        finally {
        	serverSocket.close();
        }
    	
    }
    }

