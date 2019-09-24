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

public class Iterador implements Iterator<Object>{

	private Node Current;
	private Node Head = new Node();
	/**
	 * 
	 * @param No Adiciona um Nó para ser Iterado
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
