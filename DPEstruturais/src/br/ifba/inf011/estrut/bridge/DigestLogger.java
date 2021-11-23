package br.ifba.inf011.estrut.bridge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//REFINEDABSTRACTION em um Bridge
public class DigestLogger extends SimpleLogger{

	private static final int MAX_MESSAGES = 5;
	
	private List<String> messages;
	private int qtdeMessages; 
	
	public DigestLogger(SimpleLoggerImplementor logger) {
		super(logger);
		this.messages = new LinkedList<String>();
		this.qtdeMessages = 0;
	}
	
	public void doDigestLogger(StateChangedEvent e) {
		if(this.qtdeMessages < DigestLogger.MAX_MESSAGES) {
			this.messages.add(e.getDe() + " --> " + e.getPara());
			this.qtdeMessages++;
		}
		else {
			SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
			String data = fd.format(new Date());
			String logMessage = "Diggest Log de [" + data + "]\n";
			for(String message : messages)
				logMessage = logMessage + message + "\n";
			this.qtdeMessages = 0;
			this.messages.clear();
			this.logger.doLog(logMessage);
		}
		
	}
	
	public void doLog(StateChangedEvent e) {
		this.doDigestLogger(e);
	}

}
