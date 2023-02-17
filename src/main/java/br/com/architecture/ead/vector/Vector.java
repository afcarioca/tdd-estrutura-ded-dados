package br.com.architecture.ead.vector;

import br.com.architecture.ead.lista.Lista;

public class Vector<T> implements Lista<T>{

    private T t;
    private Object [] lista; 
    private int tamanho;

    public Vector(){
        this.lista = new Object[100];
        this.tamanho = 0;
    }
   

    public Vector(T t){
        this.t = t;
        this.lista = new Object[100];
        this.lista[0] = t;
        this.tamanho++;
    }

    private void redimensiona(){
        if(this.tamanho + 1 == this.lista.length){
            Object [] novaLista = new Object[this.tamanho*2];
            for(int i = 0; i < this.tamanho; i++){
                novaLista[i] =  this.lista[i];
            }
            this.lista = novaLista;
        }
    } 
  
    @Override
    public boolean adicionaNoInicio(T t) {
        this.redimensiona();

        for(int i = this.tamanho -1; i >= 0; i--){
            this.lista[i+1] = this.lista[i];
        }
        this.lista[0] = t;
        this.tamanho++;
        return true;
    }

    @Override
    public boolean adicionaNoFim(Object t) {
        this.redimensiona();
        this.lista[this.tamanho++] = t;
        return true;
    }

    @Override
    public Object[] obtemLista() {
        Object [] copiaLista = new Object[this.tamanho];
        for(int i = 0; i < this.tamanho; i++){
            copiaLista[i] = this.lista[i];
        }
        
        return  copiaLista;
    }

    @Override
    public int obtemTamanho() {
        return this.tamanho;
    }

    @Override
    public Object obtemElemento(T t) {
        
        for(int i = 0; i < this.tamanho; i++){
            if(this.lista[i] == t){
                return i;
            }
        }

        return null;
    }


    @Override
    public Object obtemElementoNaPosicao(int posicao) {
        
        if (this.tamanho <= posicao || posicao < 0)
            throw new IllegalAccessError("Posição Inexistente");

        return this.lista[posicao];
    }


    @Override
    public boolean adicionaNaPosicao(T t, int posicao) {
        if ((this.tamanho <= posicao && posicao != 0) || posicao < 0)
			throw new IllegalAccessError("Posição Inexistente");

		if (posicao == 0) {
			this.adicionaNoInicio(t);
			return true;
        }

        this.redimensiona();

        for(int i = this.tamanho -1 ; i >= posicao; i--){
            this.lista[i + 1] = this.lista[i];
        }

        this.lista[posicao] = t;
        this.tamanho++;
        return true;
    }


    @Override
    public boolean removeElementoDaPosicao(int posicao) {
        if (this.tamanho <= posicao || posicao < 0)
			throw new IllegalAccessError("Posicão Inexistente");
        

        if(this.tamanho -1 == posicao || this.tamanho == 1){
            this.tamanho--;
            return true;
        }

        for(int i = posicao; i < this.tamanho -1; i++){
            this.lista[i] = this.lista[i+1];
        }
        
        this.tamanho--;
        
        return true;
    }
    
}
