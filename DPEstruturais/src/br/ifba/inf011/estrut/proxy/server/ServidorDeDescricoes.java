package br.ifba.inf011.estrut.proxy.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDeDescricoes{
	
	private static final int PORTA = 1234;
	
	private void init() throws IOException {
		ServerSocket server = new ServerSocket(ServidorDeDescricoes.PORTA);
		System.out.println("Registrando Serviço na Porta " + ServidorDeDescricoes.PORTA + "...");
		while(true) {
			Socket s = server.accept();
			new Thread((new ProcessaRequisicao(s))).start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		(new ServidorDeDescricoes()).init();
	}
	

}
