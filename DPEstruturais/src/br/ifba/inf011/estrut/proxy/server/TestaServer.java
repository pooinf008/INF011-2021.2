package br.ifba.inf011.estrut.proxy.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TestaServer {
	
	public void run() throws IOException {
		Socket s = new Socket("localhost", 1234);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.append("ABC");
		bw.newLine();
		bw.close();
		s.close();
		System.out.println("Mensagem Enviada");
	}
	
	public static void main(String[] args) throws IOException {
		(new TestaServer()).run();
	}

}
