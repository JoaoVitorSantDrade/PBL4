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
package Controlador;

import java.io.IOException;
import java.util.Stack;

import Algoritmo.MetodoDeBusca;
import Classes.Grafo;
import Classes.Ponto;
import Exceptions.CaminhoImpossivelException;
import Exceptions.GrafoVazioException;
import Exceptions.PontoInexistenteException;
/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class Sistema {

	private static Grafo grafo = new Grafo();
	private static Ponto Estacionamento;
	private static Ponto Coleta;
	private static Ponto Banco;
	

	/**
	 * Busca o menor caminho entre dois pontos utilizando o algoritmo de Dijkstra
	 * @return Uma string que indica o caminho percorrido
	 * @throws PontoInexistenteException
	 * @throws CaminhoImpossivelException
	 * @throws GrafoVazioException
	 */
	public static String MenorCaminhoString() throws PontoInexistenteException, CaminhoImpossivelException, GrafoVazioException { 
		StringBuilder Rota = new StringBuilder();
		Stack<Ponto> Aux = new Stack<Ponto>();
		Double Distancia = 0.0;
		
		if(grafo.getListaDePontos().size() == 0) {
			throw new GrafoVazioException();
		}
		
		if(Estacionamento == null || Coleta == null || Banco == null) {
			throw new PontoInexistenteException();
		}
		
		Aux = BuscaCaminho(Estacionamento.getNome(),Coleta.getNome());
	
		
		while(!Aux.isEmpty()) {
			Ponto pontoAux = Aux.pop();
			//System.out.print("\n--1--> " + pontoAux.getNome() + "\n"); 
			Rota.append("\nPonto ");
			Rota.append(pontoAux.getNome());
			Rota.append(" - ");
			Rota.append(pontoAux.getMinDistance());
			Rota.append(" Minutos\n");
			Distancia = pontoAux.getMinDistance();
		}
		
		Aux = BuscaCaminho(Coleta.getNome(),Banco.getNome());
		
		while(!Aux.isEmpty()) {
			Ponto pontoAux = Aux.pop(); // deve repetir Coleta 2X
			if(pontoAux != Coleta) {
				Rota.append("\nPonto ");
				Rota.append(pontoAux.getNome());
				Rota.append(" - ");
				Rota.append(pontoAux.getMinDistance() + Distancia);
				Rota.append(" Minutos\n");
			}
		}
		return Rota.toString();
	}
	
	private static Stack<Ponto> BuscaCaminho(String string, String string2) throws PontoInexistenteException, CaminhoImpossivelException  {
		Stack<Ponto> Aux = null;
		{
			Aux = MetodoDeBusca.Busca(string, string2, grafo);
		}
		return Aux;
	}
	/**
	 * Adiciona um Ponto ao Grafo
	 * @param NomePonto Nome do Ponto a ser Adicionado
	 * @param TipoDoPonto Tipo do Ponto a ser Adicionado
	 */
	public static void AddPonto(String NomePonto,int TipoDoPonto) {
		grafo.AddPonto(NomePonto,TipoDoPonto);
		Ponto P = grafo.getListaDePontos().BuscaPonto(NomePonto);
		P.setTipo(TipoDoPonto); 
		if(Estacionamento == null && P.getTipo() == 0)
				Estacionamento = P;
		else if(Coleta == null && P.getTipo() == 2) 
				Coleta = P;
		else if(Banco == null && P.getTipo() == 3) 
				Banco = P;
		else if(P.getTipo() != 1) {
			// Nao pode ter mais
		}
		
	}
	/**
	 * Adiciona um Ponto ao Grafo
	 * @param NomePonto Nome do Ponto a ser Adicionado
	 * @param TipoDoPonto Tipo do Ponto a Ser Adicionado
	 * @param PosX Posicao X do Ponto a ser Adicionado
	 * @param PosY Posicao Y do Ponto a ser Adicionado
	 */
	public static void AddPonto(String NomePonto,int TipoDoPonto,double PosX,double PosY) {
		grafo.AddPonto(NomePonto,TipoDoPonto,PosX,PosY);
		Ponto P = grafo.getListaDePontos().BuscaPonto(NomePonto);
		P.setTipo(TipoDoPonto); 
		if(Estacionamento == null && P.getTipo() == 0)
				Estacionamento = P;
		else if(Coleta == null && P.getTipo() == 2) 
				Coleta = P;
		else if(Banco == null && P.getTipo() == 3) 
				Banco = P;
		else if(P.getTipo() != 1) {
			// Nao pode ter mais
		}
		
	}
	/**
	 * Deleta um Ponto
	 * @param NomePonto Nome do Ponto a ser Deletado
	 */
	public static void DelPonto(String NomePonto) {
		Ponto p = grafo.getListaDePontos().BuscaPonto(NomePonto);
		if(p.getTipo() == 0)
			Estacionamento = null;
		else if(p.getTipo() == 2) 
				Coleta = null;
		else if(p.getTipo() == 3) 
				Banco = null;
		grafo.DelPonto(p);
	}
	/**
	 * Deleta um Ponto
	 * @param P Ponto a ser Deletado
	 */
	public static void DelPonto(Ponto P) {
		if(P.getTipo() == 0)
				Estacionamento = null;
		else if(P.getTipo() == 2) 
				Coleta = null;
		else if(P.getTipo() == 3) 
				Banco = null;
		grafo.DelPonto(P);
	}
	/**
	 * Deleta uma Ligacao entre dois Pontos
	 * @param A Ponto Inicial Da Ligacao
	 * @param B Ponto Final Da Ligacao
	 */
	public static void DelLigacao(Ponto A,Ponto B)
	{	
		grafo.DelLigacao(A, B);
	}
	/**
	 * Deleta uma Ligacao entre dois Pontos Pelo Nome
	 * @param PA Nome do Ponto Inicial da Ligacao
	 * @param PB Nome do Ponto Final da Ligacao
	 */
	public static void DelLigacao(String PA, String PB) {
			grafo.DelLigacao(PA, PB);
	}
	/**
	 * Adiciona uma Ligacao entre dois Pontos
	 * @param P1 Nome do Ponto Inicial da Ligacao
	 * @param P2 Nome do Ponto Final da Ligacao
	 * @param Peso Peso da Ligacao
	 */
	public static void AddLigacao(String P1,String P2,int Peso) {
		grafo.AddLigacao(P1, P2, Peso);
	}
	/**
	 * Adiciona uma Ligacao entre dois Pontos
	 * @param A Ponto Inicial da Ligacao
	 * @param B Ponto Final da Ligacao
	 * @param Peso Peso da Ligacao
	 */
	public static void AddLigacao(Ponto A,Ponto B,int Peso) {
		grafo.AddLigacao(A, B, Peso);
	}
	/**
	 * Abre um arquivo TXT onde fica salvo os dados que serao usados no Grafo
	 * @throws Exception
	 */
	public static void LerTxT() throws Exception  {
		Leitor.LerTXT();
		grafo.setListaDePontos(Leitor.getListPonto());
		Estacionamento = grafo.getListaDePontos().BuscaTipoPonto(0);
		Coleta = grafo.getListaDePontos().BuscaTipoPonto(2);
		Banco = grafo.getListaDePontos().BuscaTipoPonto(3);
	}
	/**
	 * Salva os dados do Grafo num arquivo TXT
	 * @throws IOException
	 */
	public static void SalvarTxt() throws IOException {
		Escritor.Salvar(grafo.getListaDePontos());
	}
	/**
	 * Pega o grafo presente na Classe Sistema
	 * @return grafo da Classe Sistema
	 */
	public static Grafo getGrafo() {
		return grafo;
	}
	/**
	 * Coloca um ponto como o Estacionamento
	 * @param P O ponto
	 */
	public static void SetEstacionamento(Ponto P) {
		Estacionamento = P;
	}
	/**
	 * Coloca um Ponto como Banco
	 * @param P O ponto
	 */
	public static void setBanco(Ponto P) {
		Banco = P;
	}
	/**
	 * Coloca um Ponto como Coleta
	 * @param P O ponto
	 */
	public static void setColeta(Ponto P) {
		Coleta = P;
	}

	/**
	 * @return the estacionamento
	 */
	public static Ponto getEstacionamento() {
		return Estacionamento;
	}
	/**
	 * @return the coleta
	 */
	public static Ponto getColeta() {
		return Coleta;
	}

	/**
	 * @return the banco
	 */
	public static Ponto getBanco() {
		return Banco;
	}
}
