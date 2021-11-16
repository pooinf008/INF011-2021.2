package br.ifba.inf011.single;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.single.atuador.TipoAtuador;
import br.ifba.inf011.single.sensor.TipoSensor;

public class Aplicacao {
	
	
	public void rodar() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		GerentePrototipos gerente = GerentePrototipos.getGerente(); 
		
		ControladorIF controlador = gerente.get(TipoSensor.FAIXA, 
												TipoAtuador.ESTABILIZADOR);
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.modificar(controlador.processar(temperatura));
			Thread.sleep(500);
		}
		
	}	
	

	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		(new Aplicacao()).rodar();
	}

}
