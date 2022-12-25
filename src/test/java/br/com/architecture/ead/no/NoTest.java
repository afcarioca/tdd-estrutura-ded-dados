package br.com.architecture.ead.no;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	public void devolveElementoDoNo() {
		No<Integer> no = new No<>(10);
		int elemento = no.obtemElemento();

		assertEquals(elemento, 10);

	}

	@Test
	public void devolveProximoNoNulo() {
		No<Integer> no = new No<>(10);
		No<?> proximoNo = no.obtemProximoNo();

		assertEquals(proximoNo, null);

	}

	@Test
	public void devolveProximoNoDiferenteDeNulo() {
		No<Integer> no = new No<>(10);
		no.insereNovoNo(new No<>(20));

		assertEquals(no.proximoNo.obtemElemento(), 20);

	}

	@Test
	public void devolveProximoNulo() {
		No<Integer> no = new No<>(10);
		no.insereNovoNo(new No<>(20));

		assertEquals(no.proximoNo.proximoNo, null);

	}

}
