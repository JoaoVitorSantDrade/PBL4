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

public class Iterador implements Iterator<Object>{

	private Node Current;
	private Node Head = new Node();
	/**
	 * 
	 * @param No Adiciona um N� para ser Iterado
	 */
	public Iterador(Node No) {
		Current = Head;
		Current.setNext(No);
	}
	
	@Override
	/**
	 * verifica se existe um proximo No
	 * 
	 * 
	 */
	public boolean hasNext() {
	if(Current.getNext() != null)
	{
		return true;
	}
	
	else
		return false;
	}

	@Override
	public Object next() {
		if(hasNext() == true)
		{
			Current = Current.getNext();
			return Current.getDado(); // aqui
		}
		else
		{
			Current = Current.getNext();
			Node aux = Current;
			Current = Head;
			return aux;
		}
	}
	/**
	 * 
	 * @return O no Atual
	 */
	public Node CurrentNode()
	{
		return Current;
	}
	

}
