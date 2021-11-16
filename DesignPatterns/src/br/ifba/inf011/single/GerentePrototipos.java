package br.ifba.inf011.single;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.single.atuador.AtuadorFactory;
import br.ifba.inf011.single.atuador.AtuadorIF;
import br.ifba.inf011.single.atuador.TipoAtuador;
import br.ifba.inf011.single.sensor.SensorFactory;
import br.ifba.inf011.single.sensor.SensorIF;
import br.ifba.inf011.single.sensor.TipoSensor;

//CLIENT em um PROTOTYPE
public class GerentePrototipos {
	
	public static final double MIN_TEMP = 26;
	public static final double MAX_TEMP = 30;
	
	private static GerentePrototipos gerente;
	
	public static GerentePrototipos getGerente() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(GerentePrototipos.gerente == null)
			GerentePrototipos.gerente = new GerentePrototipos();
		return GerentePrototipos.gerente; 
	}
	
	private Map<TipoSensor, SensorIF> sensores;  
	private Map<TipoAtuador, AtuadorIF> atuadores;	
	
	private GerentePrototipos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.sensores = new HashMap<TipoSensor, SensorIF>();
		this.atuadores = new HashMap<TipoAtuador, AtuadorIF>();
		this.load();
	}
	
	public void load() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for(TipoSensor tipoSensor : TipoSensor.values())
			this.put(tipoSensor);
		for(TipoAtuador tipoAtuador : TipoAtuador.values())
			this.put(tipoAtuador);
	}
	
	public void put(TipoSensor tipo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		SensorFactory factory = (SensorFactory) (Class.forName(tipo.getFactoryName()).getConstructor().newInstance());
		SensorIF sensor = factory.getSensor(GerentePrototipos.MIN_TEMP, 
											GerentePrototipos.MAX_TEMP);
		this.sensores.put(tipo, sensor);
	}
	
	public void put(TipoAtuador tipo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		AtuadorFactory factory = (AtuadorFactory) (Class.forName(tipo.getFactoryName()).getConstructor().newInstance());
		AtuadorIF atuador = factory.getAtuador(GerentePrototipos.MIN_TEMP, 
											   GerentePrototipos.MAX_TEMP);
		this.atuadores.put(tipo, atuador);
	}
	
	
	public SensorIF get(TipoSensor tipo) {
		SensorIF sensor = this.sensores.get(tipo);
		return (SensorIF) sensor.prototipar();
	}
	
	
	public AtuadorIF get(TipoAtuador tipo) {
		AtuadorIF atuador = this.atuadores.get(tipo);
		return (AtuadorIF) atuador.prototipar();
	
	}
	
	public ControladorIF get(TipoSensor tipoSensor, TipoAtuador tipoAtuador) {
		ControladorGenerico controlador = new ControladorGenerico(this.get(tipoSensor),
																  this.get(tipoAtuador));
		return controlador;
	}
	

}
