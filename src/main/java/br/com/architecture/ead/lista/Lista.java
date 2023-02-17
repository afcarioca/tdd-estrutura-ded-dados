package br.com.architecture.ead.lista;


public interface Lista<T> {
	
	public boolean adicionaNoInicio(T t);

	public boolean adicionaNoFim(T t);

	public Object[] obtemLista();

	public int obtemTamanho();
	
	public Object obtemElemento(T t);
	
	public Object obtemElementoNaPosicao(int posicao);

	public boolean adicionaNaPosicao(T t, int posicao);

	public boolean removeElementoDaPosicao(int posicao);

}
