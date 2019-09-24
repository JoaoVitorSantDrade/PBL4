/***************************
Autores: Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
Componente Curricular: MI-Programa��o
Concluido em: 23/09/2019
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************/
package Classes;

import Estruturas.MyPontoList;
/**
 * @author Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
 */
public class Grafo {

	private MyPontoList ListaDePontos;
	
	
	public Grafo() {	
		ListaDePontos = new MyPontoList();
	}

	/**
	 * @return the listaDePontos
	 */
	public MyPontoList getListaDePontos() {
		return ListaDePontos;
	}

	/**
	 * @param listaDePontos the listaDePontos to set
	 */
	public void setListaDePontos(MyPontoList listaDePontos) {
		ListaDePontos = listaDePontos;
	}
	
	/**
	 * Adiciona um ponto ao Grafo apenas com seu Nome e seu Tipo
	 * @param Nome Nome do Ponto
	 * @param TipoDoPonto Tipo do Ponto
	 */
	public void AddPonto(String Nome,int TipoDoPonto) {
		Ponto Aux = new Ponto(Nome,TipoDoPonto);
		Aux.setTipo(TipoDoPonto);
		if(!ListaDePontos.HavePonto(Aux)) {
			ListaDePontos.add(Aux);
		}
	}
	/**
	 * Adiciona um ponto ao Grafo com seu Nome,Tipo e posicao na Tela
	 * @param Nome Nome do Ponto
	 * @param TipoDoPonto Tipo do Ponto
	 * @param PosX Posicao X do ponto na Tela
	 * @param PosY Posicao Y do ponto na Tela
	 */
	public void AddPonto(String Nome,int TipoDoPonto,double PosX,double PosY) {
		Ponto Aux = new Ponto(Nome,TipoDoPonto,PosX,PosY);
		if(!ListaDePontos.HavePonto(Aux)) {
			ListaDePontos.add(Aux);
		}
	}
	/**
	 * Cria uma ligacao entre dois pontos
	 * @param Aux1 O ponto inicial da Ligacao
	 * @param Aux2 O ponto final da ligacao
	 * @param Peso o Peso da ligacao
	 */
	public void AddLigacao(Ponto Aux1,Ponto Aux2,int Peso) { // ta com problema
		
		if(!Aux1.getAdjacente().contains(Aux2)) {
			
			Aux1.getAdjacente().add(Aux2);
			Aux1.getDistanciaAdjacente().add(-1); // So para manter o tamanho igual
			int pos = Aux1.getAdjacente().indexOf(Aux2);
			Aux1.getDistanciaAdjacente().set(pos, Peso);
		}
		
		if(!Aux2.getAdjacente().contains(Aux1)) {
			
			Aux2.getAdjacente().add(Aux1);
			Aux2.getDistanciaAdjacente().add(-1); // So para manter o tamanho igual
			int pos = Aux2.getAdjacente().indexOf(Aux1);
			Aux2.getDistanciaAdjacente().set(pos, Peso);
		}
		
		
	}
	/**
	 * Cria uma ligacao entre dois pontos com seus nomes
	 * @param Nome1 Nome do ponto Inicial da ligacao
	 * @param Nome2 Nome do ponto Final da ligacao
	 * @param Peso Peso da ligacao
	 */
	public void AddLigacao(String Nome1,String Nome2,int Peso) { // ta com problema
		Ponto Aux1 = ListaDePontos.BuscaPonto(Nome1);
		Ponto Aux2 = ListaDePontos.BuscaPonto(Nome2);
		
		if(!Aux1.getAdjacente().contains(Aux2)) {
			
			Aux1.getAdjacente().add(Aux2);
			Aux1.getDistanciaAdjacente().add(-1); // So para manter o tamanho igual
			int pos = Aux1.getAdjacente().indexOf(Aux2);
			Aux1.getDistanciaAdjacente().set(pos, Peso);
		}
		
		if(!Aux2.getAdjacente().contains(Aux1)) {
			
			Aux2.getAdjacente().add(Aux1);
			Aux2.getDistanciaAdjacente().add(-1); // So para manter o tamanho igual
			int pos = Aux2.getAdjacente().indexOf(Aux1);
			Aux2.getDistanciaAdjacente().set(pos, Peso);
		}
		
		
	}
	/**
	 * Deleta um ponto pelo seu Nome
	 * @param Nome Nome do ponto a ser Deletado do grafo
	 */
	public void DelPonto(String Nome) {
		Ponto aux = ListaDePontos.BuscaPonto(Nome);
		
		for(int i = 0; i < aux.getAdjacente().size(); i++) {
			Ponto vizinho = aux.getAdjacente().get(i);
			int posRemover = vizinho.getAdjacente().indexOf(aux);
			vizinho.getAdjacente().remove(posRemover);
			vizinho.getDistanciaAdjacente().remove(posRemover);
			aux.getAdjacente().remove(i);
			aux.getDistanciaAdjacente().remove(i);
		}	
		ListaDePontos.remove(aux);
	}
	/**
	 * Deleta um ponto
	 * @param A O ponto a ser Deletado do grafo
	 */
	public void DelPonto(Ponto A) {
		String Nome = A.getNome();
		Ponto aux = ListaDePontos.BuscaPonto(Nome);
		for(int i = 0; i < aux.getAdjacente().size(); i++) {
			Ponto vizinho = aux.getAdjacente().get(i);
			int posRemover = vizinho.getAdjacente().indexOf(aux);
			vizinho.getAdjacente().remove(posRemover);
			vizinho.getDistanciaAdjacente().remove(posRemover);
			aux.getAdjacente().remove(i);
			aux.getDistanciaAdjacente().remove(i);
		}	
		ListaDePontos.remove(aux);

	}
	/**
	 * Deleta a ligacao entre dois pontos com seus nomes
	 * @param PA Nome do ponto Inicial da Ligacao
	 * @param PB Nome do ponto Final da Ligacao
	 */
	public void DelLigacao(String PA,String PB) {
		Ponto A = ListaDePontos.BuscaPonto(PA);
		Ponto B = ListaDePontos.BuscaPonto(PB);
		if(A.getAdjacente().contains(B)) {
			int PosBinA = A.getAdjacente().indexOf(B); // posicao de B em A
			A.getAdjacente().remove(PosBinA);
			A.getDistanciaAdjacente().remove(PosBinA);
			int PosAinB = B.getAdjacente().indexOf(A); // posicao de A em B
			B.getAdjacente().remove(PosAinB);
			B.getDistanciaAdjacente().remove(PosAinB);
		}
	}
	/**
	 * Deleta a ligacao entre dois pontos com seus nomes
	 * @param A Ponto Inicial da Ligacao
	 * @param B Ponto Final da Ligacao
	 */
	public void DelLigacao(Ponto A,Ponto B)  {
		if(A.getAdjacente().contains(B)) {
			int PosBinA = A.getAdjacente().indexOf(B); // posicao de B em A
			A.getAdjacente().remove(PosBinA);
			A.getDistanciaAdjacente().remove(PosBinA);
			int PosAinB = B.getAdjacente().indexOf(A); // posicao de A em B
			B.getAdjacente().remove(PosAinB);
			B.getDistanciaAdjacente().remove(PosAinB);
		}
	}
	
}
