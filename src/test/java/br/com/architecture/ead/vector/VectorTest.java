package br.com.architecture.ead.vector;
import org.junit.jupiter.api.Test;

import br.com.architecture.ead.lista.Lista;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


public class VectorTest {
    
    @Test
    public void devolveTamanhoZero(){
        assertEquals(0, new Vector<>().obtemTamanho());
    }
   
    @Test
    public void devolveTamanhoUmQuandoAdicionaUmNovoValorALista(){
        assertEquals(1, new Vector<Integer>(20).obtemTamanho());
    }

    @Test
    public void devolveUmaListaComMaisDeCemElementosAdicinadosNoInicio(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 200; i++){
            lista.adicionaNoInicio(i);
        }

        assertEquals(200, lista.obtemTamanho());
    }

    @Test
    public void devolveUmaListaComOsElementosAdicionadosNoInicioNasPosicoesCorretas(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoInicio(i);
        }

        assertEquals(Arrays.asList(3,2,1,0),  Arrays.asList(lista.obtemLista()));
    }

    @Test
    public void devolveUmaListaComMaisDeCemElementosAdicinadosNoFim(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 200; i++){
            lista.adicionaNoFim(i);
        }

        assertEquals(200, lista.obtemTamanho());
    }

    @Test
    public void devolveUmaListaComOsElementosAdicionadosNoFimNasPosicoesCorretas(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoFim(i);
        }

        assertEquals(Arrays.asList(0,1,2,3),  Arrays.asList(lista.obtemLista()));
    }

    @Test
    public void devolveUmaListaComOsElementoQueFoiAdicionadoNoInicioCorreto(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoFim(i);
        }

        assertEquals(0,   lista.obtemElemento(0));
        assertEquals(1,   lista.obtemElemento(1));
        assertEquals(2,   lista.obtemElemento(2));
        assertEquals(3,   lista.obtemElemento(3));
    }
    @Test
    public void devolveUmaListaComOsElementoQueFoiAdicionadoNoFimCorretamente(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoInicio(i);
        }

        assertEquals(3, lista.obtemElemento(0));
    }

    @Test
    public void devolveUmaExcecaoNaBuscaDeUmaPosicaoQueNaoExiste(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoInicio(i);
        }

        assertThrows(IllegalAccessError.class, () -> lista.obtemElementoNaPosicao(5));

    }
    @Test
    public void devolveOElementoAdicionadoNoInicioDeAcordoComASuaPosicao(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoInicio(i);
        }

        assertEquals(0, lista.obtemElementoNaPosicao(3));
        assertEquals(1, lista.obtemElementoNaPosicao(2));
        assertEquals(2, lista.obtemElementoNaPosicao(1));
        assertEquals(3, lista.obtemElementoNaPosicao(0));

    }
    @Test
    public void devolveOElementoAdicionadoNoFimDeAcordoComASuaPosicao(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoFim(i);
        }

        assertEquals(0, lista.obtemElementoNaPosicao(0));
        assertEquals(1, lista.obtemElementoNaPosicao(1));
        assertEquals(2, lista.obtemElementoNaPosicao(2));
        assertEquals(3, lista.obtemElementoNaPosicao(3));

    }

    @Test
    public void devolveUmaExcecaoAoTentarAdicionarUmElementoNumaPosicaoInexistente(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoInicio(i);
        }

        assertThrows(IllegalAccessError.class, () ->   lista.adicionaNaPosicao(10, 4));
        assertThrows(IllegalAccessError.class, () ->   lista.adicionaNaPosicao(10, -1));
    }

    @Test
    public void devolveTrueAoAdicionarOprimeiroElementoNaLista(){
        Lista<Integer> lista = new Vector<>();
        assertEquals(true,lista.adicionaNaPosicao(10, 0));
     }

    @Test
    public void devolveAListaAtualizadaAoAdicionarUmElementoNumaPosicaoDaLista(){
        Lista<Integer> lista = new Vector<>();
        lista.adicionaNoFim(10);
        lista.adicionaNoFim(5);
        lista.adicionaNoFim(30);
        lista.adicionaNoFim(40);
        lista.adicionaNoFim(50);
        lista.adicionaNaPosicao(2, 1);
        lista.adicionaNaPosicao(3, 0);
        lista.adicionaNaPosicao(80, 5);

        assertEquals(Arrays.asList(3,10,2,5,30,80,40,50), Arrays.asList(lista.obtemLista()));
     }

     @Test
     public void devolveUmaExcecaoAoTentarRemoverUmElementoNumaPosicaoInexistente(){
         Lista<Integer> lista = new Vector<>();
         
         for(int i = 0; i < 4; i++){
             lista.adicionaNoInicio(i);
         }
 
         assertThrows(IllegalAccessError.class, () ->   lista.removeElementoDaPosicao(4));
         assertThrows(IllegalAccessError.class, () ->   lista.removeElementoDaPosicao(-1));
     }

     @Test
     public void devolveUmaNovaListaComVariosElementosAposRemoverOSeuUltimoElemento(){
         Lista<Integer> lista = new Vector<>();
         
         for(int i = 0; i < 4; i++){
             lista.adicionaNoFim(i);
         }
         
         lista.removeElementoDaPosicao(3);

         assertEquals(Arrays.asList(0,1,2), Arrays.asList(lista.obtemLista()));
     }

     @Test
     public void devolveUmaListaVaziaAposRemoverOSeuUnicoElemento(){
         Lista<Integer> lista = new Vector<>();
         
         lista.adicionaNoInicio(5);
         lista.removeElementoDaPosicao(0);

         assertEquals(Arrays.asList(), Arrays.asList(lista.obtemLista()));
     }
     @Test
     public void devolveUmaNovaListaAposRemoverUmDeSeusElementos(){
        Lista<Integer> lista = new Vector<>();
         
        for(int i = 0; i < 4; i++){
            lista.adicionaNoFim(i);
        }
        
        lista.removeElementoDaPosicao(1);
        lista.removeElementoDaPosicao(1);
        lista.removeElementoDaPosicao(0);

        assertEquals(Arrays.asList(3), Arrays.asList(lista.obtemLista()));
     }
}
