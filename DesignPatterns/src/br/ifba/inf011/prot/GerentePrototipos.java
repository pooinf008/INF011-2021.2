package br.ifba.inf011.prot;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.prot.atuador.AtuadorFactory;
import br.ifba.inf011.prot.atuador.AtuadorIF;
import br.ifba.inf011.prot.atuador.TipoAtuador;
import br.ifba.inf011.prot.sensor.SensorFactory;
import br.ifba.inf011.prot.sensor.SensorIF;
import br.ifba.inf011.prot.sensor.TipoSensor;

//CLIENT em um PROTOTYPE
public class GerentePrototipos {
	
	public static final double MIN_TEMP = 26;
	public static final double MAX_TEMP = 30;
	
	private Map<TipoSensor, SensorIF> sensores;  
	private Map<TipoAtuador, AtuadorIF> atuadores;	
	
	public GerentePrototipos() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.sensores = new HashMap<TipoSensor, SensorIF>();
		this.atuadores = new HashMap<TipoAtuador, AtuadorIF>();
		this.load();
	}
	
	public void load() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		for(TipoSensor tipoSensor : TipoSensor.values())
			this.put(tipoSensor);
		for(TipoAtuador tipoAtuador : TipoAtuador.values())
			this.put(tipoAtuador);
	}
	
	public void put(TipoSensor tipo) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		SensorFactory factory = (SensorFactory) (Class.forName(tipo.getFactoryName()).newInstance());
		SensorIF sensor = factory.getSensor(GerentePrototipos.MIN_TEMP, 
											GerentePrototipos.MAX_TEMP);
		this.sensores.put(tipo, sensor);
	}
	
	public void put(TipoAtuador tipo) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		AtuadorFactory factory = (AtuadorFactory) (Class.forName(tipo.getFactoryName()).newInstance());
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
