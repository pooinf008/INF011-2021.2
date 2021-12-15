package br.edu.ifba.inf011.aval2.prototype;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.aval2.Curso;

public class CatalogoCursos {
	
	private static CatalogoCursos catalogo;
	
	private Map<String, Curso> cursos;
	
	public static CatalogoCursos getCatalogo() {
		if(CatalogoCursos.catalogo == null)
			CatalogoCursos.catalogo = new CatalogoCursos();
		return CatalogoCursos.catalogo;
	}
	
	private CatalogoCursos() {
		this.cursos = new HashMap<String, Curso>();
	}
	
	public void registrar(Curso curso) {
		this.cursos.put(curso.getCodigo(), curso);
	}
	
	public Curso recuperar(String codigo) {
		Curso curso = this.cursos.get(codigo);
		return (Curso) ((curso != null) ? curso.prototipar() : null);
	}
	
	

}
