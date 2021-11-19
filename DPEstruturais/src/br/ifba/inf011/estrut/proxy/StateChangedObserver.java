package br.ifba.inf011.estrut.proxy;

//TARGET em um Adapter
public interface StateChangedObserver {
	
	public void notifyStateChanged(StateChangedEvent e);

}
