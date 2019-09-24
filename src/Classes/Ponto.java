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
package Classes;

import java.util.ArrayList;
import java.util.List;
/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class Ponto implements Comparable<Ponto> {
	private String Nome;
	private int Tipo = 1;
	double PosY;
	double PosX;
    private List<Ponto> Adjacente; 
    private List<Integer> DistanciaAdjacente;
    private Ponto Anterior = null;
    private double minDistance = Double.POSITIVE_INFINITY;
    private boolean visited = false;
    
    
	public Ponto(String Nome,int Tipo, double posX,double posY) {
		this.Nome = Nome;
		this.Tipo = Tipo;
		this.PosX = posX;
		this.PosY = posY;
		Adjacente = new ArrayList<Ponto>();
		DistanciaAdjacente = new ArrayList<Integer>();
	}
	
	public Ponto(String name) {
		this.Nome = name;
		Adjacente = new ArrayList<Ponto>();
		DistanciaAdjacente = new ArrayList<Integer>();
	}

	public Ponto(String nome, int tipoDoPonto) {
		this.Nome = nome;
		this.Tipo = tipoDoPonto;
		Adjacente = new ArrayList<Ponto>();
		DistanciaAdjacente = new ArrayList<Integer>();
	}

	public Ponto() {
		Adjacente = new ArrayList<Ponto>();
		DistanciaAdjacente = new ArrayList<Integer>();
	}

	/**
	 * Compara este ponto com o ponto fornecido
	 * @param B O ponto a ser Comparado
	 * @return True Se o Ponto for o mesmo. 
	 * False Se o Ponto nao for o mesmo
	 */
	public boolean equals(Ponto B) {
		if(this.Nome == B.Nome && this.Tipo == B.Tipo) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Ponto arg0) {
		Ponto B = arg0;
		if(this.minDistance < B.minDistance)
			return -1;
		else if(this.minDistance > B.minDistance)
			return 1;
		else
		return 0;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return Nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		Nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return Tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	/**
	 * @return the posX
	 */
	public double getPosX() {
		return PosX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		PosX = posX;
	}

	/**
	 * @return the posY
	 */
	public double getPosY() {
		return PosY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		PosY = posY;
	}

	/**
	 * @return the adjacente
	 */
	public List<Ponto> getAdjacente() {
		return Adjacente;
	}

	/**
	 * @param adjacente the adjacente to set
	 */
	public void setAdjacente(List<Ponto> adjacente) {
		Adjacente = adjacente;
	}

	/**
	 * @return the distanciaAdjacente
	 */
	public List<Integer> getDistanciaAdjacente() {
		return DistanciaAdjacente;
	}

	/**
	 * @param distanciaAdjacente the distanciaAdjacente to set
	 */
	public void setDistanciaAdjacente(List<Integer> distanciaAdjacente) {
		DistanciaAdjacente = distanciaAdjacente;
	}

	/**
	 * @return the anterior
	 */
	public Ponto getAnterior() {
		return Anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(Ponto anterior) {
		Anterior = anterior;
	}

	/**
	 * @return the minDistance
	 */
	public double getMinDistance() {
		return minDistance;
	}

	/**
	 * @param minDistance the minDistance to set
	 */
	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * @param string Nome do Ponto
	 * @return Compara o nome do Ponto para saber se é igual ou nao
	 */
	public boolean compareNome(String string) {
		if(this.Nome == string) {
			return true;
		}
		return false;
	}

}
	
	