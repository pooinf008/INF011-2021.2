package br.ifba.inf011.estrut.composite;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//ADAPTER em um Adapter
public class StateFileLoggerAdapter implements StateChangedObserver{

	
	private StateFileLogger fileLogger;
	
	public StateFileLoggerAdapter(String fileName) {
		this.fileLogger = new StateFileLogger(fileName);
	}
	
	@Override
	public void notifyStateChanged(StateChangedEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date()); 
		try {
			this.fileLogger.doLog(data, e.getDe(), e.getPara());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
