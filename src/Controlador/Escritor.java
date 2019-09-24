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
package Controlador;

import java.io.FileWriter;
import java.io.IOException;

import Classes.Ponto;
import Estruturas.MyPontoList;
/**
 * @author Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
 */
public class Escritor {

	private static FileWriter teste;
	
	private static void SalvarPontos(MyPontoList ListaPontos) throws IOException { 
		teste = new FileWriter("Pontos.txt");
		for(int i = 0; i < ListaPontos.size(); i++) {
			Ponto aux = ListaPontos.get(i);
			teste.append(aux.getNome());
			teste.append(",");
			teste.append("" + aux.getTipo());
			teste.append(",");
			teste.append("" + aux.getPosX());
			teste.append(",");
			teste.append("" + aux.getPosY());
			teste.append("\n");
		}
		teste.close();
	}
	private static void SalvarArestas(MyPontoList ListaPontos) throws IOException { // trocar p/ private
		teste = new FileWriter("Arestas.txt");
		for(int i = 0; i < ListaPontos.size(); i++) {
			Ponto aux = ListaPontos.get(i);
			for(int j = 0; j < aux.getAdjacente().size(); j++) {
				Ponto aux2 = aux.getAdjacente().get(j);
				teste.append(aux.getNome());
				teste.append("," + aux2.getNome());
				teste.append("," + aux.getDistanciaAdjacente().get(j));
				teste.append("\n");
			}
		}
		teste.close();
	}
	
	/**
	 * Salva os dados do grafo em dois TxTs nomeados "Pontos.txt" e "Arestas.txt"
	 * @param ListaPontos A lista de pontos que deseja salvar
	 * @throws IOException
	 */
	public static void Salvar(MyPontoList ListaPontos) throws IOException {
		SalvarPontos(ListaPontos);
		SalvarArestas(ListaPontos);
	}
	
}
