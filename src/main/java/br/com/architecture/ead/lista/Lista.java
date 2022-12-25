package br.com.architecture.ead.lista;

import br.com.architecture.ead.no.No;

public interface Lista<T> {
	
	public boolean adicionaNoInicio(T t);

	public boolean adicionaNoFim(T t);

	public Object[] obtemLista();

	public int obtemTamanho();
	
	public No<T> obtemElemento(T t);

}
