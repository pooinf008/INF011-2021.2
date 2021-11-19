package br.ifba.inf011.estrut.proxy.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ProcessaRequisicao implements Runnable{
	
	private Socket socket;
	
	public ProcessaRequisicao(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
