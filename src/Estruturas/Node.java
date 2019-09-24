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
 * No que possui informacao do proximo e do anterior, usado na lista duplamente
 * encadeada
 * João Vítor Santos de Andrade
 */
public class Node implements Iterator<Object> {
	
	private Node prev;
	private Node next;
	private Object dado;
	
	public Node()
	{
		
	}
	/**
	 * 
	 * @param dado Algum Objeto para ser salvo pelo No
	 */
	public Node(Object dado)
	{
		this.dado = dado;
	}
	/**
	 * 
	 * @param a O No que devera ser o proximo do No atual
	 */
	public void setNext(Node a)
	{
		this.next = a;
	}
	/**
	 * 
	 * @param a O No que devera ser o anterior do No atual
	 */
	public void setPrev(Node a)
	{
		this.prev = a;
	}
	/**
	 * 
	 * @param a Altera/Coloca este Objeto no lugar do Dado do No atual
	 */
	public void setDado(Object a)
	{
		this.dado = a;
	}
	/**
	 * 
	 * @return O No posterior a este
	 */
	public Node getNext()
	{
		return this.next;
	}
	/**
	 * 
	 * @return O No anterior a este
	 */
	public Node getPrev()
	{
		return this.prev;
	}
	/**
	 * 
	 * @return A informacao salva por este No
	 */
	public Object getDado()
	{
		return this.dado;
	}
	/**
	 * Verifica se o No possui um No a sua frente
	 */
	public boolean hasNext() 
	{
		if(next == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public Object next() 
	{
		return next;
	}
	
}
