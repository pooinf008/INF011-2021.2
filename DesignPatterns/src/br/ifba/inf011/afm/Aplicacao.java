package br.ifba.inf011.afm;

//CLIENT em um Abstract Factory
public class Aplicacao {
	
	public static TipoControlador CONTROLADOR = TipoControlador.FAIXA;
	public static double MAX_TEMPERATURA = 30;
	private AbstractControladorFactory controladorFactory;
	
	public Aplicacao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.controladorFactory = (AbstractControladorFactory) (Class.forName(Aplicacao.CONTROLADOR.getFactoryName()).newInstance());
		this.controladorFactory.setTemperaturaMaxima(Aplicacao.MAX_TEMPERATURA);
	}
	
	public void rodar() throws InterruptedException {
		Ambiente ambiente = new Ambiente();
		SensorIF sensor = this.controladorFactory.getSensor();
		AtuadorIF atuador = this.controladorFactory.getAtuador();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			sensor.medir(temperatura);
			ambiente.modificar(atuador.atuar(temperatura));
			Thread.sleep(500);
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		(new Aplicacao()).rodar();
	}

}
