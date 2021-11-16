package br.ifba.inf011.cria.fm;

import java.lang.reflect.InvocationTargetException;

//CLIENT em um Factory Method
public class Aplicacao {
	public static TipoSensor SENSOR = TipoSensor.LOCK;
	private SensorFactory factory;
	
	public Aplicacao() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.factory = (SensorFactory) (Class.forName(Aplicacao.SENSOR.getFactoryName()).getDeclaredConstructor().newInstance());
		//this.factory = SensorFactory.getFactory("basico");
	}
	
	public void rodar() throws InterruptedException, InstantiationException{
		Ambiente ambiente = new Ambiente();
		SensorIF sensor = null;
		sensor = factory.getSensor(30);
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			sensor.medir(temperatura);
			Thread.sleep(100);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Aplicacao app = new Aplicacao();
		app.rodar();
		
		
	}

}
