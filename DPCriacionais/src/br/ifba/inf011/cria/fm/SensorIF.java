package br.ifba.inf011.cria.fm;

// PRODUCT em um Factory Method
public interface SensorIF {
	public void medir(double temperatura);
	public void ajuste(double temperaturaLimite);
}
