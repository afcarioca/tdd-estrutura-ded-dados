package br.com.architecture.ead.lista;

import br.com.architecture.ead.no.No;

public class ListaLigada<T> implements Lista<T> {

	No<T> ultimo;
	No<T> primeiro;
	int tamanho;

	public boolean adicionaNoFim(T t) {
		No<T> no = new No<>(t);
		this.tamanho++;

		if (this.primeiro == null) {
			this.primeiro = no;
			this.ultimo = this.primeiro;
			return true;
		}

		this.ultimo.insereNovoNo(no);
		this.ultimo = no;

		return true;

	}

	@Override
	public Object[] obtemLista() {

		No<T> cursor = this.primeiro;
		Object[] elementos = new Object[this.tamanho];
		int contador = 0;
		while (cursor != null) {
			elementos[contador] = cursor.obtemElemento();
			cursor = cursor.obtemProximoNo();
			contador++;
		}

		return elementos;
	}

	@Override
	public boolean adicionaNoInicio(T t) {
		if (this.primeiro == null) {
			this.adicionaNoFim(t);
			return true;
		}

		No<T> novoNo = new No<>(t);
		novoNo.insereNovoNo(this.primeiro);
		this.primeiro = novoNo;
		this.tamanho++;

		return true;
	}

	@Override
	public int obtemTamanho() {
		return this.tamanho;
	}

	public No<T> obtemElemento(T t) {
		No<T> cursor = this.primeiro;

		while (cursor != null) {
			if (cursor.obtemElemento() == t)
				return cursor;

			cursor = cursor.obtemProximoNo();
		}

		return null;
	}

	public No<T> obtemElementoNaPosicao(int posicao) {

		if (this.tamanho <= posicao || posicao < 0)
			throw new IllegalAccessError("Posição Inexistente");

		No<T> cursor = this.primeiro;
		int contador = 0;
		while (cursor != null) {
			if (contador == posicao)
				return cursor;
			contador++;
			cursor = cursor.obtemProximoNo();
		}

		return null;
	}

	public boolean adicionaNaPosicao(T t, int posicao) {
		if ((this.tamanho <= posicao && posicao != 0) || posicao < 0)
			throw new IllegalAccessError("Posição Inexistente");

		if (posicao == 0) {
			this.adicionaNoInicio(t);
			return true;

		}

		No<T> cursor = this.primeiro;
		No<T> noAnterior = null;
		int contador = 0;

		while (cursor != null) {

			if (contador == posicao) {
				No<T> noNovo = new No<>(t);
				noNovo.insereNovoNo(cursor);
				noAnterior.insereNovoNo(noNovo);
				this.tamanho++;
				break;

			}

			noAnterior = cursor;
			cursor = cursor.obtemProximoNo();
			contador++;

		}

		return true;
	}

	public boolean removeElementoDaPosicao(int posicao) {

		if (this.tamanho <= posicao || posicao < 0)
			throw new IllegalAccessError("Posicão Inexistente");

		if (this.tamanho == 1) {
			this.primeiro = null;
			this.ultimo = this.primeiro;
			this.tamanho--;

			return true;

		}

		if (posicao == 0) {
			this.primeiro = this.ultimo;
			this.tamanho--;

			return true;

		}

		No<T> cursor = this.primeiro;
		No<T> noAnterior = null;
		int contador = 0;

		while (cursor != null) {
			if (contador == posicao) {
				if (this.tamanho - 1 == contador) {
					noAnterior.insereNovoNo(null);
					this.ultimo = noAnterior;
				} else {
					noAnterior.insereNovoNo(cursor.obtemProximoNo());
					cursor.insereNovoNo(null);
				}

				this.tamanho--;
				break;
			}

			contador++;
			noAnterior = cursor;
			cursor = cursor.obtemProximoNo();
		}

		return true;
	}

}
