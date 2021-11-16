package br.ifba.inf011.cria.fm;

//CLIENT em um Factory Method
public class AplicacaoBase {
	
	public void rodar() throws InterruptedException {
		Ambiente ambiente = new Ambiente();
		SensorIF[] sensorTemperatura = new SensorIF[2];
		
		sensorTemperatura[0] = (new SensorTemperaturaFactory(30)).createSensor();
		sensorTemperatura[1] = (new SensorTemperaturaLockFactory(30)).createSensor();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			sensorTemperatura[0].medir(temperatura);
			sensorTemperatura[1].medir(temperatura);
			Thread.sleep(200);
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		(new AplicacaoBase()).rodar();
	}

}
