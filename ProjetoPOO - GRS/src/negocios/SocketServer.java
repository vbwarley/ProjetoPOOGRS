package negocios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import persistencia.Banco;

public class SocketServer {

	public void salvarCliente(Cliente c) {
		try {
	        ServerSocket welcomeSocket = new ServerSocket(1900);

	        while (true) {    
	            // Create the Client Socket
	            Socket clientSocket = welcomeSocket.accept();
	            System.out.println("Socket Extablished...");
	            
	            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

	            c = (Cliente) inFromClient.readObject();
	            Banco.getInstance().salvarUsuario(c);

	        }

	    } catch (Exception e) {
	        System.err.println("Server Error: " + e.getMessage());
	        System.err.println("Localized: " + e.getLocalizedMessage());
	        System.err.println("Stack Trace: " + e.getStackTrace());
	        System.err.println("To String: " + e.toString());
	    }
	}
}
