package br.ifba.inf011.estrut.proxy.server;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.estrut.proxy.report.DeltaTemperatura;

public class ClientDicionarioDescricoesCache implements DicionarioDescricoesIF{
	
	private ClientDicionarioDescricoes servico;
	private Map<String, String> descricoes;
	
	public ClientDicionarioDescricoesCache() {
		this.servico = new ClientDicionarioDescricoes();
		this.descricoes = new HashMap<String, String>();
	}

	@Override
	public String buscarDescricao(String simbolo) {
		String descricao = this.descricoes.get(simbolo);
		if(descricao == null) {
			descricao = this.servico.buscarDescricao(simbolo);
			this.descricoes.put(simbolo, descricao);
		}
		return descricao;
	}
	

}
