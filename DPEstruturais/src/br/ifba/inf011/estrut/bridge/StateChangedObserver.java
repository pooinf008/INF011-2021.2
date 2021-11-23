package br.ifba.inf011.estrut.bridge;

public interface StateChangedObserver {
	
	public void notifyStateChanged(StateChangedEvent e);

}
