package br.ifba.inf011.comp.observer;

public class StateChangedEvent {
	
	private String de;
	private String para;
	
	public StateChangedEvent(String de, String para) {
		this.de = de;
		this.para = para;
	}

	public String getDe() {
		return de;
	}

	public String getPara() {
		return para;
	}
	
	
	

}
