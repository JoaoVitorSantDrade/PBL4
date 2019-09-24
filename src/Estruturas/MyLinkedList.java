/***************************
Autores: João Pedro Rios Carvalho e João Vítor Santos de Andrade
Componente Curricular: MI-Programação
Concluido em: 18/08/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************/

package Estruturas;

import java.util.Iterator;

/**
 * Lista Duplamente Encadeada Comum
 * @author Felipe Silva Queiroz e João Vítor Santos de Andrade
 *
 */
public class MyLinkedList implements IList {

	protected Node Head;
	protected Node Tail;
	protected int tamanho = 0;
	
	public MyLinkedList()
	{
		
	}
	/**
	 * 
	 * @param Head O inicio do No
	 * @param Tail O fim do No
	 * @param tamanho o Tamanho do No
	 */
	public MyLinkedList(Node Head,Node Tail,int tamanho)
	{
		this.Head = Head;
		this.Tail = Tail;
		this.tamanho = tamanho;
	}
	@Override
	public int size() { 
		
		return tamanho;
		
	}
	@Override
	public void add(Object obj) {
		if(Head == null)  
		{
			Node aux = new Node(obj);
			Tail = Head = aux;
			tamanho ++;
		}
		else
		{
			Node aux = new Node(obj);
			aux.setPrev(Tail);
			Tail.setNext(aux);
			Tail = aux;
			tamanho ++;
		}
	}

	@Override
	public boolean add(int pos, Object obj) { 
		
		if(pos < 0 || pos > tamanho)
		{
			return false;
		}
		else
		{
			if (pos == 0 || Head == null) 
	        { 
				Node aux = new Node(obj);
				aux.setNext(Head);
				Head = aux;
	        }
			else
			{
				Node aux = Head;
				Node aux2 = new Node(obj);
				for (int i=0;i<pos-1; i++)
	            {
	            	aux = aux.getNext();
	            }
				if(aux.getNext() == null) // aux é o anterior
				{
					aux.setNext(aux2);
				}
				else
				{
					aux2.setNext(aux.getNext());
					aux.setNext(aux2);
				}
			}
            tamanho ++;
            return true;
		}
	}

	@Override
	public Object remove(int pos) { 
        if (Head == null)
        {
        	return null;
        }
             
        Node aux = Head; 
        
        if (pos == 0) 
        { 
            Head = aux.getNext();   
        } 
        else
        {
        	for (int i=0;i<pos-1; i++)
            {
            	aux = aux.getNext();
            }
        	if(aux.getNext() == null || aux == null) // é o anterior
    		{
    			return null;
    		}
            Node aux2 = aux.getNext();
            if(aux2.getNext() == null)
            {
            	aux.setNext(null);
            }
            else
            {
            	aux.setNext(aux2.getNext());
            }
            tamanho --;
            return aux2.getDado();   
        }
        tamanho --;
        return aux.getDado();
	}

	@Override
	public Object get(int index) { // throws EstruturaVaziaException {
		
		if(Head == null)
		{
			return null;
		}
		Node aux = Head; 
		for(int i = 0;i < index;i ++)
		{
			if(aux.getNext() == null)
			{
				return null;
			}
			aux = aux.getNext();
		}
		return aux.getDado();
	}

	@Override
	public boolean isEmpty() {
		if(Head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public Iterator<?> iterator() {
		Iterador it = new Iterador(Head);
		return (Iterator<?>)it;
	}

}
