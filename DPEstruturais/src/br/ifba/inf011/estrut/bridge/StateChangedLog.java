package br.ifba.inf011.estrut.bridge;

public class StateChangedLog implements StateChangedObserver{

	private SimpleLogger logger; 
	
	public StateChangedLog(SimpleLogger logger) {
		this.logger = logger;
	}
	
	@Override
	public void notifyStateChanged(StateChangedEvent e) {
		this.logger.doLog(e);
	}

	

}
