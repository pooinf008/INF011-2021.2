package br.ifba.inf011.solid.reajustador;

import java.math.BigDecimal;
import java.util.Date;

import br.ifba.inf011.solid.exception.ValidacaoException;
import br.ifba.inf011.solid.model.Reajustavel;

public class RegraPercentual implements RegraReajuste{
	
	public void validar(Reajustavel funcionario, BigDecimal indice, Date data) throws ValidacaoException {
		BigDecimal indiceMaximo = new BigDecimal(0.15);
		if(indice.compareTo(indiceMaximo) > 0)
			throw new ValidacaoException("PERCENTUAL MAIOR QUE O PERMITIDO");
	}
	

}
