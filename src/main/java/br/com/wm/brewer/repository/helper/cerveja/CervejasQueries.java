package br.com.wm.brewer.repository.helper.cerveja;

import java.util.List;

import br.com.wm.brewer.model.Cerveja;
import br.com.wm.brewer.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public List<Cerveja> filtrar(CervejaFilter filtro);
	
}
