package br.ifba.inf011.strategy;

//CLIENT em um Abstract Factory
public class Aplicacao {
	
	
	public Aplicacao(){
	}
	
	public void rodar() throws InterruptedException {
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			System.out.println("[Temperatura Ambiente]: " + temperatura);
			Thread.sleep(500);
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		(new Aplicacao()).rodar();
	}

}
