package br.ifba.inf011.estrut.proxy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ProcessaRequisicao implements Runnable{
	
	private Socket socket;
	
	public ProcessaRequisicao(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		BufferedReader br;
		BufferedWriter bw;
		String questao;
		String resposta;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			questao = br.readLine();
			System.out.println(questao);
			resposta = this.processaMessagem(questao);
			bw.append(resposta);
			bw.newLine();
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String processaMessagem(String mensagem) {
		StringTokenizer tokenizer = new StringTokenizer(mensagem, " ");
		String acao = tokenizer.nextToken();
		if(!acao.equals("WHOIS"))
			return null;
		double setpoint = Double.parseDouble(tokenizer.nextToken());
		double valor = Double.parseDouble(tokenizer.nextToken());
		return "SYMBOL " + this.gerarSimbolo(setpoint, valor);
	}
	
	private String gerarSimbolo(double setpoint, double valor) {
		if(this.getAcima(setpoint, valor) && this.getMaior5(setpoint, valor))
			return new String("^5");
		else if(this.getAcima(setpoint, valor) && this.getMaior1(setpoint, valor))
			return new String("^1");
		else if(this.getAbaixo(setpoint, valor) && this.getMaior5(setpoint, valor))
			return new String("v5");
		else if(this.getAbaixo(setpoint, valor) && this.getMaior1(setpoint, valor))
			return new String("v1");			
		else
			return new String("<>");
	}	
	
	private boolean getAcima(double setpoint, double valor) {
		return (valor > setpoint);
	}
	
	private boolean getAbaixo(double setpoint, double valor) {
		return (valor < setpoint);
	}	
	
	private boolean getMaior1(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.01; 
	}
	
	private  boolean getMaior5(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.05; 
	}		
	
	
}
