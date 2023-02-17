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
    public void devolveUmaListaComMaisDeCemElementos(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 200; i++){
            lista.adicionaNoInicio(i);
        }

        assertEquals(200, lista.obtemTamanho());
    }

    @Test
    public void devolveUmaListaComOsElementosNasPosicoesCorretas(){
        Lista<Integer> lista = new Vector<>();
        
        for(int i = 0; i < 4; i++){
            lista.adicionaNoInicio(i);
        }

        assertEquals(Arrays.asList(3,2,1,0),  Arrays.asList(lista.obtemLista()));
    }
}
