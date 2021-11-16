package br.ifba.inf011.fm;

//CLIENT em um Factory Method
public class Aplicacao {
	public static TipoSensor SENSOR = TipoSensor.LOCK;
	private SensorFactory factory;
	
	public Aplicacao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.factory = (SensorFactory) (Class.forName(Aplicacao.SENSOR.getFactoryName()).newInstance());
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
	
	public void minhaClasse() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class classe = Class.forName("br.ifba.inf011.fm.SensorTemperaturaLockFactory");
		Object object = classe.newInstance();
		SensorFactory factory = (SensorFactory) object;
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Aplicacao app = new Aplicacao();
		app.rodar();
		
		
	}

}
