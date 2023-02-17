package br.com.architecture.ead.lista;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.architecture.ead.no.No;

class ListaLigadaTest {

	@Test
	public void devolveOPrimeiroValorDeUmaListaComUmElemento() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);
		No<Integer> primeiroElemento = lista.primeiro;

		assertEquals(primeiroElemento.obtemElemento(), 10);
	}

	@Test
	public void devolveOUltimoValorDeUmaListaComUmElemento() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);
		No<Integer> ultimo = lista.ultimo;

		assertEquals(ultimo.obtemElemento(), 10);
	}

	@Test
	public void verificaNumaListaComUmElementoSeOPrimeiroEIgualAoUltimoAdicionandoNoFim() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);

		assertEquals(lista.primeiro == lista.ultimo, true);
	}

	@Test
	public void verificaNumaListaComUmElementoSeOPrimeiroEIgualAoUltimoAdicionandoNoIncio() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoInicio(10);

		assertEquals(lista.primeiro == lista.ultimo, true);
	}

	@Test
	public void devolveOUltimoElementoDaListaComValorDeVinteAdicionandoOsElementosNoFim() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);
		lista.adicionaNoFim(20);

		assertEquals(lista.ultimo.obtemElemento(), 20);
	}

	@Test
	public void devolveOUltimoElementoDaListaComValorDe10AdicionandoOsElementosNoInicio() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoInicio(10);
		lista.adicionaNoInicio(20);

		assertEquals(lista.ultimo.obtemElemento(), 10);
	}

	@Test
	public void devolveUmaListaQueAdicionaOsSeusElementosNoInicio() {
		Lista<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);
		lista.adicionaNoFim(20);
		lista.adicionaNoFim(30);
		lista.adicionaNoFim(40);

		Object[] listaElementos = lista.obtemLista();

		assertArrayEquals(listaElementos, Arrays.asList(10, 20, 30, 40).toArray());
	}

	@Test
	public void devolveUmaListaQueAdicionaOsSeusElementosNoFim() {
		Lista<Integer> lista = new ListaLigada<>();
		lista.adicionaNoInicio(10);
		lista.adicionaNoInicio(20);
		lista.adicionaNoInicio(30);
		lista.adicionaNoInicio(40);

		Object[] listaElementos = lista.obtemLista();

		assertArrayEquals(listaElementos, Arrays.asList(40, 30, 20, 10).toArray());
	}

	@Test
	public void devolveUmaListaQueAdicionaOsSeusElementosNoInicioENoFim() {
		Lista<Integer> lista = new ListaLigada<>();
		lista.adicionaNoInicio(10);
		lista.adicionaNoFim(20);
		lista.adicionaNoInicio(30);
		lista.adicionaNoInicio(40);

		Object[] listaElementos = lista.obtemLista();

		assertArrayEquals(listaElementos, Arrays.asList(40, 30, 10, 20).toArray());
	}

	@Test
	public void devolveOTamanhoDaLista() {
		Lista<Integer> lista = new ListaLigada<>();
		lista.adicionaNoInicio(10);
		lista.adicionaNoFim(20);
		lista.adicionaNoInicio(30);
		lista.adicionaNoInicio(40);

		assertEquals(lista.obtemTamanho(), 4);
	}

	@Test
	public void devolveONoDeUmElemenentoDaLista() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoInicio(10);
		lista.adicionaNoFim(20);

		No<Integer> noVinte = lista.ultimo;

		lista.adicionaNoInicio(30);
		lista.adicionaNoInicio(40);

		assertEquals(lista.obtemElemento(20), noVinte);
	}

	/**
	 * 
	 */
	@Test
	public void devolveExcecaoQuandoAPosicaoNaoExisteNaLista() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);
		lista.adicionaNoFim(20);
		lista.adicionaNoFim(30);

		assertThrows(IllegalAccessError.class, () -> lista.obtemElementoNaPosicao(10));

	}

	@Test
	public void devolveONoDeUmElemenentoDaListaIndicandoASuaPosicao() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(10);
		lista.adicionaNoFim(20);
		No<Integer> noVinte = lista.ultimo;
		lista.adicionaNoFim(30); // 2
		lista.adicionaNoFim(40);

		assertEquals(lista.obtemElementoNaPosicao(1), noVinte);

	}

	@Test
	public void devolveUmaExcecaoQuandoAPosicaoNaoExisteNaListaNoMomentoDaInSercaoDeUmValorNumaPosicaoInexistenteDaLista() {
		ListaLigada<Integer> lista = new ListaLigada<>();

		assertThrows(IllegalAccessError.class, () -> lista.adicionaNaPosicao(10, 1));

	}

	@Test
	public void devolveAListaQuandoAdicionadoNaPrimeiraPosicao() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNaPosicao(10, 0);

		assertArrayEquals(lista.obtemLista(), Arrays.asList(10).toArray());

	}

	@Test
	public void devolveListaAtualizadoComAInsercaoDeUmElementoNaPrimeiraPosicao() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20);
		lista.adicionaNoFim(30);
		lista.adicionaNaPosicao(10, 0);

		assertArrayEquals(lista.obtemLista(), Arrays.asList(10, 20, 30).toArray());

	}

	@Test
	public void devolveUmaListaTendoComoCasoAInsercaoDeUmElementoNumaPosicaoEspecifica() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20);
		lista.adicionaNoFim(30);
		lista.adicionaNoFim(40); // 2
		lista.adicionaNoFim(60);
		lista.adicionaNaPosicao(10, 2);

		assertArrayEquals(lista.obtemLista(), Arrays.asList(20, 30, 10, 40, 60).toArray());

	}

	@Test
	public void devolveUmaExcecaoCasoTenteRemoverUmElementoNumaPosicaoInexistente() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20);

		assertThrows(IllegalAccessError.class, () -> lista.removeElementoDaPosicao(10));

	}

	@Test
	public void devolveUmaListaVaziaComOElementoDaPrimeiraPosicaoRemovido() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20); // Removido

		lista.removeElementoDaPosicao(0);

		assertArrayEquals(lista.obtemLista(), Arrays.asList().toArray());

	}

	@Test
	public void devolveUmaListaComOElementoDaPrimeiraPosicaoRemovido() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20); // Remove
		lista.adicionaNoFim(30);

		lista.removeElementoDaPosicao(0);

		assertArrayEquals(lista.obtemLista(), Arrays.asList(30).toArray());

	}

	@Test
	public void devolveUmaListaComOElementoDaUtimaPosicaoRemovido() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20);
		lista.adicionaNoFim(30); // Remove

		lista.removeElementoDaPosicao(1);

		assertArrayEquals(lista.obtemLista(), Arrays.asList(20).toArray());

	}

	@Test
	public void devolveUmaListaComOElementoDeUmPosicaoEspecificaRemovido() {
		ListaLigada<Integer> lista = new ListaLigada<>();
		lista.adicionaNoFim(20); //0
		lista.adicionaNoFim(30); // Remove
		lista.adicionaNoFim(10);
		lista.adicionaNoFim(40);
		lista.adicionaNoFim(50); // Remove
		lista.adicionaNoFim(60);
		lista.removeElementoDaPosicao(1);
		lista.removeElementoDaPosicao(3);

		assertArrayEquals(lista.obtemLista(), Arrays.asList(20, 10, 40, 60).toArray());

	}

}
