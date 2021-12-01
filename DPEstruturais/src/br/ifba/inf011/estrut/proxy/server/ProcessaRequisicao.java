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
		String acao = mensagem.substring(0, mensagem.indexOf(' ')).trim();
		if(!acao.equals("WHATIS"))
			return null;
		String descricao = mensagem.substring(mensagem.indexOf(' '), mensagem.length()).trim();
		return "DESC " + this.gerarDescricao(descricao);
	}
	
	private String gerarDescricao(String descricao) {
		if(descricao.contentEquals("^5"))
			return new String("Temperatura Ambiente mais que 5% Acima do SetPoint");
		else if(descricao.contentEquals("^1"))
			return new String("Temperatura Ambiente mais que 1% Acima do SetPoint");
		else if(descricao.contentEquals("v5"))
			return new String("Temperatura Ambiente menos que 5% Abaixo do SetPoint");
		else if(descricao.contentEquals("v1"))
			return new String("Temperatura Ambiente menos que 1% Abaixo do SetPoint");			
		else
			return new String("Temperatura Ambiente dentro dos padrões estabelecidos");
	}	
	
	
}
