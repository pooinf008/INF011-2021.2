package br.ifba.inf011.estrut.proxy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDicionarioDescricoes implements DicionarioDescricoesIF{
	
	private static final int PORTA = 1234;
	private static final String HOST = "localhost";
	
	public String buscarDescricao(String simbolo) {
		String conteudo;
		try {
			conteudo = this.run(simbolo);
		} catch (IOException e) {
			conteudo = "INDEFINIDO";
		}
		return conteudo;
	};	
	
	private String processaMessagem(String mensagem) {
		String acao = mensagem.substring(0, mensagem.indexOf(' ')).trim();
		if(!acao.equals("DESC"))
			return "INDEFINIDO";
		String simbolo = mensagem.substring(mensagem.indexOf(' '), mensagem.length()).trim();
		return simbolo;
	}	
	
	public String run(String simbolo) throws IOException {
		String mensagem;
		Socket s = new Socket(ClientDicionarioDescricoes.HOST, ClientDicionarioDescricoes.PORTA);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.append("WHATIS " + simbolo);
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
		System.out.println((new ClientDicionarioDescricoes()).buscarDescricao("v1"));
	}


}
