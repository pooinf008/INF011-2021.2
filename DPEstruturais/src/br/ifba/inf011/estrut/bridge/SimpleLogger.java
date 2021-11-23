package br.ifba.inf011.estrut.bridge;

import java.text.SimpleDateFormat;
import java.util.Date;


//ABSTRACTION em um Bridge
public class SimpleLogger {
	
	protected SimpleLoggerImplementor logger;
	
	public SimpleLogger(SimpleLoggerImplementor logger) {
		this.logger = logger;
	}
	
	public void doLog(StateChangedEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date()); 
		logger.doLog("[" + data + "] - " + e.getDe() + " --> " + e.getPara());
	}
	

}
