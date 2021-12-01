package br.ifba.inf011.estrut.proxy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import br.ifba.inf011.estrut.noflyweight.report.DeltaTemperatura;

public class ClientServicoSimbolos implements GeraSimboloIF{
	
	private static final int PORTA = 1234;
	private static final String HOST = "localhost";
	
	public String gerarSimbolo(double setpoint, double valor) {
		try {
			return this.run(setpoint, valor);
		} catch (IOException e) {
			return null;
		}
	};	
	
	private String processaMessagem(String mensagem) {
		StringTokenizer tokenizer = new StringTokenizer(mensagem, " ");
		String acao = tokenizer.nextToken();
		if(!acao.equals("SYMBOL"))
			return null;
		String simbolo = tokenizer.nextToken();
		return simbolo;
	}	
	
	public String run(double setpoint, double valor) throws IOException {
		String mensagem;
		Socket s = new Socket(ClientServicoSimbolos.HOST, ClientServicoSimbolos.PORTA);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.append("WHOIS " + Double.toString(setpoint) + " " + Double.toString(valor));
		bw.newLine();
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		mensagem = br.readLine();
		br.close();
		bw.close();
		s.close();
		return this.processaMessagem(mensagem);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println((new ClientServicoSimbolos()).gerarSimbolo(10, 10.1));
	}

}
