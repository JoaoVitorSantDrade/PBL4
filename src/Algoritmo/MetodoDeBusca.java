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
package Algoritmo;

import java.util.PriorityQueue;
import java.util.Stack;

import Classes.Grafo;
import Classes.Ponto;
import Exceptions.CaminhoImpossivelException;
import Exceptions.PontoInexistenteException;
/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class MetodoDeBusca {

	static PriorityQueue<Ponto> Nao_Visitado = new PriorityQueue<Ponto>();
	
	

	/**
	 * Busca o caminho mais curto entre dois pontos utilizando do Algoritmo de Dijkstra
	 * @param A Ponto Inicial
	 * @param B Ponto Final
	 * @param G Grafo em que os pontos se localizam
	 * @return Uma Pilha com o caminho mais curto
	 * @throws PontoInexistenteException
	 * @throws CaminhoImpossivelException
	 */
	public static Stack<Ponto> Busca(String A,String B,Grafo G) throws PontoInexistenteException, CaminhoImpossivelException {
		
		Reiniciar(G);
		
		Ponto source = G.getListaDePontos().BuscaPonto(A);
		source.setMinDistance(0);
		Nao_Visitado.add(source);
		
		
	/*	while(!Nao_Visitado.isEmpty()) { // o problema é, o Nao_Visitado nao ta atualizando pelo que tem a 
			// menor distancia, por algum motivo :c
			System.out.print("\nPontos na fila de prioridade: " + Nao_Visitado.poll().getNome() + "\n");
		} */
		
		while(!Nao_Visitado.isEmpty()) {
			
			Ponto P1 = Nao_Visitado.poll();
		//	System.out.print("\n" + P1.getNome() + " - " + P1.getMinDistance() + "Km do ponto " + A + "\n"); Debug
			
			for(int i = 0; i < P1.getAdjacente().size(); i++) { // para ir em todos os adjacentes do ponto
				Ponto PontoB = P1.getAdjacente().get(i);
			//	System.out.print(PontoB.getNome() + " é o " + (i+1) + "° vizinho de " + P1.getNome() + " "); Debug
				
				if(PontoB.getMinDistance() > P1.getDistanciaAdjacente().get(i) + P1.getMinDistance() && !PontoB.isVisited()) {
						Nao_Visitado.remove(PontoB);
						PontoB.setMinDistance(P1.getDistanciaAdjacente().get(i) + P1.getMinDistance());
						PontoB.setAnterior(P1);
						Nao_Visitado.add(PontoB);
					}
		//	System.out.print("e tem distancia de: " + PontoB.getMinDistance() + "Km\n"); Debug
			}
			P1.setVisited(true);
			
		} 
		
		Stack<Ponto> Caminho = new Stack<Ponto>();
		Ponto Antecessor = G.getListaDePontos().BuscaPonto(B);
		while(Antecessor != null) {
		//	System.out.print( "\n" + Antecessor.getNome() + "\n"); Debug
			Caminho.push(Antecessor);
			Antecessor = Antecessor.getAnterior();
		}
		if(!Caminho.contains(source)) {
			throw new CaminhoImpossivelException();
		}
		return Caminho; 
	}
	
	private static void Reiniciar(Grafo G) {
		
		for(int i = 0; i < G.getListaDePontos().size(); i++) { // reiniciar os valores no Grafo
			
			G.getListaDePontos().get(i).setMinDistance(Double.POSITIVE_INFINITY);
			G.getListaDePontos().get(i).setVisited(false);
			G.getListaDePontos().get(i).setAnterior(null);
		}
	}
}
