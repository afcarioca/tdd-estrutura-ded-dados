package br.com.architecture.ead.no;

public class No<T> {
	
	T t;
	No<T> proximoNo;
	
	public No(T t) {
		this.t = t;
		this.proximoNo = null;
	}

	public T obtemElemento() {
		return this.t;
	}

	public No<T> obtemProximoNo() {
		return this.proximoNo;
	}

	public void insereNovoNo(No<T> novoNo) {
		this.proximoNo = novoNo;
	}

}
