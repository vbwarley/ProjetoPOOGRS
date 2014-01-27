package negocios;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SocketClient {
	private Socket s = null;

	public void abrirConexao() {

		try {
			s = new Socket("localhost", 1900);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Algum problema ocorreu para criar ou enviar dados pelo scoket");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void fecharConexao() {
		try {
			s.close();

		} catch (IOException e) {

		}
	}


	public void salvarCliente(Cliente c) {
		abrirConexao();

		try {
			
//			Socket s = new Socket("127.0.0.1", 1900);
			ObjectOutputStream outToServer = new ObjectOutputStream(s.getOutputStream());
			outToServer.writeObject(c);            
			
			s.close();

		} catch (Exception e) {
			System.err.println("Client Error: " + e.getMessage());
			System.err.println("Localized: " + e.getLocalizedMessage());
			System.err.println("Stack Trace: " + e.getStackTrace());
			e.printStackTrace();
		}
	
		fecharConexao();
	}
}