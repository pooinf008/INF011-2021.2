package br.ifba.inf011.comp.observer;

import java.text.SimpleDateFormat;
import java.util.Date;

//CONCRETEOBSERVER em Observer
public class StateChangedLog implements StateChangedObserver{

	@Override
	public void notifyStateChanged(StateChangedEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date()); 
		System.err.println("[" + data + "] " + e.getDe() + " ==> " + e.getPara());
		
	}

	

}
