package br.edu.ifba.inf011.adapter;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.prototype.Prototipavel;

public class WebinarAdapter extends Disciplina{

	private Webinar webinar;

	public WebinarAdapter(Webinar webinar) {
		super(webinar.getId(), webinar.getTitle());
		this.webinar = webinar;
	}

	@Override
	public Prototipavel prototipar() {
		Webinar novo = new Webinar(this.webinar.getId(),
								   this.webinar.getTitle(),
								   this.webinar.getHoster(),
								   this.webinar.getPrice(),
								   this.webinar.getMinutes(), this.webinar.getUri());
		
		return new WebinarAdapter(novo);
	}

	@Override
	public int getCHCumprida() {
		return this.webinar.wasWatched() ? this.getCHTotal() : 0;
	}

	@Override
	public int getCHTotal() {
		return (int) (Math.ceil(this.webinar.getMinutes() / 60.0));
	}

	@Override
	public double getPreco() {
		return this.webinar.getPrice();
	}

	@Override
	public void setPreco(double preco) {
	}	
	
	@Override
	public void avancar(int ch) {
		this.webinar.play();	
	}
	
	@Override
	public void setCHTotal(int chTotal) {
		
	}
	
	@Override
	public String toString() {
		return "[WEBINAR] "  + this.getCodigo() + "-" + this.getNome() + 
				" CH Total: " + this.getCHTotal() + " / CH Cumprida :" + 
				this.getCHCumprida(); 
	}

	@Override
	public Set<Disciplina> getDisciplinas() {
		HashSet<Disciplina> setDisciplinas = new HashSet<Disciplina>();
		setDisciplinas.add(this);
		return setDisciplinas;
	}
		

}
