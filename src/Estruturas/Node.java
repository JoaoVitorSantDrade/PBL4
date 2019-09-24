/***************************
Autores: Jo�o Pedro Rios Carvalho e Jo�o V�tor Santos de Andrade
Componente Curricular: MI-Programa��o
Concluido em: 18/08/2019
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************/

package Estruturas;

import java.util.Iterator;
/**
 * No que possui informacao do proximo e do anterior, usado na lista duplamente
 * encadeada
 * Jo�o V�tor Santos de Andrade
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
