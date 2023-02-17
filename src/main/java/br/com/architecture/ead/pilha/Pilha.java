package br.com.architecture.ead.pilha;

import br.com.architecture.ead.no.No;

public class Pilha<T> {
    private No<T> no;
    private No<T> ultimo;
    private int tamanho;

    public Pilha(){
       this.no = null;
       this.ultimo = this.no;
       this.tamanho = 0;
    }

    public Pilha(T t){
      this.no = new No<T>(t) ;
      this.ultimo = this.no;
      this.tamanho++;
    }

    public No<T> peek(){
        return this.ultimo;
    }

    public boolean push(T t){
        if(tamanho == 0){
            this.no = new No<T>(t);
            this.ultimo = this.no;
            this.tamanho++;
            return true;
        }

        No<T> novoNo = new No<T>(t);
        novoNo.insereNovoNo(this.no);
        this.no = novoNo;
        this.ultimo = this.no;

        this.tamanho++;
       
        return true;
    }

    public No<T> pop(){
        if(this.tamanho == 0)
            throw new IllegalAccessError("Pilha Vazia");

        No<T> proximoNo = this.no.obtemProximoNo();
        this.no = proximoNo;
        this.ultimo = no;    
        
        this.tamanho--;
        
        return this.ultimo;
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }
    
}
