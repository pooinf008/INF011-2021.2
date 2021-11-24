package br.ifba.inf011.estrut.bridge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//CONCRETEIMPLEMENTOR em um Bridge 
public class FileLogger implements LoggerImplementor{

	private String fileName;

	public FileLogger(String fileName) {
		this.fileName = fileName;
	}
	
	public void doLog(String s) {
		BufferedWriter buffWrite;
		try {
			buffWrite = new BufferedWriter(new FileWriter(this.fileName, true));
			buffWrite.append(s + "\r\n");
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	

}
