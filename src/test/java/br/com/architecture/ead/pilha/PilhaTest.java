package br.com.architecture.ead.pilha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PilhaTest {
    
    @Test
    public void devolveNuloOElementoDoTopoDeUmaPilhaVazia(){
       Pilha<Integer> pilha = new Pilha<>();
       
       assertEquals(null, pilha.peek());
    }

    @Test
    public void devolveOValorDoElementoDoTopoDeUmaPilhaComApenasUmElemento(){
       Pilha<Integer> pilha = new Pilha<>(10);
       
       assertEquals(10, pilha.peek().obtemElemento());
    }
    @Test
    public void devolveOValorDoElementoDoTopoDeUmaPilhaComVariosElementos(){
       Pilha<Integer> pilha = new Pilha<>(10);
       pilha.push(11);
       pilha.push(12);
       
       assertEquals(12, pilha.peek().obtemElemento());
    }
    @Test
    public void devolveOTamanhoDaPilha(){
       Pilha<Integer> pilha = new Pilha<>(10);
       pilha.push(11);
       pilha.push(12);
       
       assertEquals(3, pilha.size());
    }
    @Test
    public void devolveUmaExcecaoAoRemoverUmEleementoDeUmaPilhaVazia(){
       Pilha<Integer> pilha = new Pilha<>();
      
       assertThrows(IllegalAccessError.class, () -> pilha.pop());
    }

    @Test
    public void devolveOUltimoElementoDaPilhaAposARemocaoDoAnterior(){
        Pilha<Integer> pilha = new Pilha<>(10);
        pilha.push(11);
        pilha.push(12);
        pilha.pop();
        
      
        assertEquals(11, pilha.peek().obtemElemento());
    }
    
    @Test
    public void devolveTrueParaUmaPilhaVazia(){
        Pilha<Integer> pilha = new Pilha<>();
        
        assertEquals(true, pilha.isEmpty());
    }
}
