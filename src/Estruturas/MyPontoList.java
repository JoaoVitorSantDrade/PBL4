/***************************
Autores: João Vítor Santos de Andrade e Felipe Silva Queiroz
Componente Curricular: MI-Programação
Concluido em: 23/09/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************/
package Estruturas;


import java.util.LinkedList;

import Classes.Ponto;

/**
 * Lista Duplamente Encadeada Comum <Ponto>
 * @author Felipe Silva Queiroz e João Vítor Santos de Andrade
 *
 */
public class MyPontoList extends MyLinkedList {

	LinkedList<Integer> ListaAux = new LinkedList<Integer>();
	
	/**
	 * 
	 */

	public MyPontoList() {
		// TODO Auto-generated constructor stub
	}

	public MyPontoList(Node Head, Node Tail, int tamanho) {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Retorna uma lista do tipo Integer que representa a distancia do ponto inicial até o ponto em tal posicao
	 * @return LinkedList<Integer>
	 */
	public LinkedList<Integer> getListaAux() {
		return ListaAux;
	}

	/**
	 * Adiciona um Ponto na lista
	 * @param obj Ponto para ser adicionado
	 */
	public void add(Ponto obj) {
		if(Head == null)  
		{
			Node aux = new Node(obj);
			Tail = Head = aux;
			tamanho ++;
		}
        else if (HavePonto(obj)) {
        	// ja existe
        	}
		else 
		{
			Node aux = new Node(obj);
			aux.setPrev(Tail);
			Tail.setNext(aux);
			Tail = aux;
			tamanho ++;
		}
		
		ListaAux.add(0); // pra lista de integer tambem crescer
	
	}
	/**
	 * Remover um ponto da lista
	 * @param p Ponto para ser removido
	 * @return
	 */
	public Ponto remove(Ponto p) {
		if (Head == null)
        {
			return null;
        }
		Node aux = Head;
		Node aux2 = null;
        for(int i = 0; i < size(); i++)
        {
        	if(p.getNome() == ((Ponto)aux.getDado()).getNome())
        		aux2 = aux;
        	else
        		aux = aux.getNext();
        }
        if(Head == Tail && Head == aux2) {
        	Head = null;
        	Tail = null;
        }
        else if(Head == aux2) {
        	aux2.getNext().setPrev(null);
        	Head = aux2.getNext();
        	aux2.setNext(null);
        }
        else if(Tail == aux2) {
        	aux2.getPrev().setNext(null);
        	Tail = aux.getPrev();
        	aux.setPrev(null);
        }
        else {
        	aux2.getPrev().setNext(aux2.getNext());
            aux2.getNext().setPrev(aux2.getPrev());
            aux2.setNext(null);
            aux2.setPrev(null);
        }
        tamanho --;
        Ponto AuxPc = (Ponto)aux.getDado();
		return AuxPc; 
	}
	/**
	 * Pega um ponto numa posicao especifica
	 * @param pos Posicao em que se deve pegar um ponto
	 */
	public Ponto get(int pos) {
		if (Head == null)
        {
			return null;
        }
		Node aux = Head;
        for(int i = 0; i < pos; i++)
        {
        	aux = aux.getNext();
        }
        Ponto AuxPc = (Ponto)aux.getDado();
		return AuxPc;
	}
	
	/**
	 * Semelhante ao Contains()
	 * @param obj Objeto que deve ser verificado se existe na Lista.
	 * @return True se sim, False se não.
	 */
	public boolean HavePonto(Ponto obj) {
        boolean acha = false;
        for(int i = 0; i < size(); i++) {
            if(get(i).getNome().equals(obj.getNome()))
                acha = true;
        }
        return acha;
    }
	
	/**
	 * Busca um ponto na lista, e depois o retorna
	 * @param obj Ponto a ser buscado
	 * @return o ponto na lista
	 * @throws Exception
	 */
	public Ponto BuscaPonto(Ponto obj) throws Exception{
        Ponto P1 = null;
        for(int i = 0; i < size(); i++) {
            if(get(i).getNome().equals(obj.getNome()))
                P1 = get(i);
        }
        if (P1 == null)
            return null;
        else
            return P1;
    }
	
	/**
	 * Similar ao IndexOf
	 * @param obj Ponto onde se procura o Index
	 * @return o Index do Ponto
	 */
	public int BuscaPosPonto(Ponto obj) {
        for(int i = 0; i < size(); i++) {
            if(get(i).getNome().equals(obj.getNome())) {
            	return i;
            }
        }
        return -1; 
    }
	
	
	/**
	 * Busca um ponto pelo Nome
	 * @param Nome do ponto a ser buscado
	 * @return o Ponto
	 */
	public Ponto BuscaPonto(String Nome) {
		Ponto P1 = null;
        for(int i = 0; i < size(); i++) {
            if(get(i).getNome().equals(Nome))
                P1 = get(i);
        }
        if (P1 == null)
            return null;
        else
            return P1;
	}
	
	/**
	 * Busca um ponto pelo seu Tipo
	 * @param tipo Tipo do Ponto
	 * @return o Ponto Buscado
	 * @throws Exception
	 */
	public Ponto BuscaTipoPonto(int tipo) throws Exception{
        Ponto P1 = null;
        for(int i = 0; i < size(); i++) {
            if(get(i).getTipo() == tipo) {
            	P1 = get(i);
            	return P1;
            }     
        }
        return null;
    }
	
}
