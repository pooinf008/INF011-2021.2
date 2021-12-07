package br.ifba.inf011.estrut.decorator;

public interface StateChangedObserver {
	
	public void notifyStateChanged(StateChangedEvent e);

}
