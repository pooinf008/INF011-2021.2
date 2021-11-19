package br.ifba.inf011.estrut.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StateChangedLog implements StateChangedObserver{

	@Override
	public void notifyStateChanged(StateChangedEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date()); 
		System.err.println("[" + data + "] " + e.getDe() + " ==> " + e.getPara());
	}

	

}
