package br.ifba.inf011.estrut.decorator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//ADAPTEE em Adapter
public class StateFileLogger {
	
	private String fileName;

	public StateFileLogger(String fileName) {
		this.fileName = fileName;
	}
	
	//SpecificRequest
	public void doLog(String quando, String de, String para) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(this.fileName, true));
		buffWrite.append("[" + quando + "] " + de + " ==> " + para + "\r\n");
		buffWrite.close();
	}

}
