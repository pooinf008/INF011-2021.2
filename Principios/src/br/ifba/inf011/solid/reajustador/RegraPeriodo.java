package br.ifba.inf011.solid.reajustador;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import br.ifba.inf011.solid.exception.ValidacaoException;
import br.ifba.inf011.solid.model.Reajustavel;

public class RegraPeriodo implements RegraReajuste{
	
	public void validar(Reajustavel funcionario, BigDecimal indice, Date data) throws ValidacaoException{
		
	    long diffInMillies = Math.abs(data.getTime() - funcionario.getDataUltReajuste().getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);		
		if(diff < 180)
			throw new ValidacaoException("PERIODO MENOR QUE O PERMITIDO");		
	}
}
