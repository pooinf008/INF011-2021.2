package br.ifba.inf011.cria.prot;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.cria.prot.atuador.AtuadorIF;
import br.ifba.inf011.cria.prot.atuador.AtuadorResfriador;
import br.ifba.inf011.cria.prot.atuador.TipoAtuador;
import br.ifba.inf011.cria.prot.sensor.SensorIF;
import br.ifba.inf011.cria.prot.sensor.SensorTemperaturaAlta;
import br.ifba.inf011.cria.prot.sensor.TipoSensor;



public class Aplicacao {

	public void rodar2() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		SensorIF sensor = new SensorTemperaturaAlta(30);
		sensor.setLogger(System.err);

		AtuadorIF resfriador = new AtuadorResfriador(30);
		resfriador.setLogger(System.err);
		
		ControladorIF controlador = new ControladorGenerico(sensor, resfriador); 
				
				
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.modificar(controlador.processar(temperatura));
			Thread.sleep(500);
		}
		
	}	
	
	
	
	public void rodar() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		GerentePrototipos gerente = new GerentePrototipos(); 
		
		GerentePrototipos gerente2 = new GerentePrototipos();		
		
		ControladorIF controlador = gerente.get(TipoSensor.BASICO, 
												TipoAtuador.RESFRIADOR);
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.modificar(controlador.processar(temperatura));
			Thread.sleep(500);
		}
		
	}	
	

	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Aplicacao app = (Aplicacao) Class.forName("br.ifba.inf011.prot.Aplicacao").getConstructor().newInstance();
		app.rodar2();
//		(new Aplicacao()).rodar2();
	}

}
