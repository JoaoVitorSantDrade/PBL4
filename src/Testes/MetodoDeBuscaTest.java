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
package Testes;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import Algoritmo.MetodoDeBusca;
import Classes.Grafo;
import Classes.Ponto;
import Exceptions.CaminhoImpossivelException;
import Exceptions.PontoInexistenteException;

/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class MetodoDeBuscaTest {
	
	Grafo G;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link Algoritmo.MetodoDeBusca#Busca(java.lang.String, java.lang.String, Classes.Grafo)}.
	 */
	@Test
	public void testBusca() {

		Random rand = new Random();
		
		// Obtain a number between [0 - 49].
		int n = rand.nextInt(50);
		Grafo G = new Grafo();
		for(int i = 0;i < 15;i++) {
			G.AddPonto("Nome " + i, 1);
		}
		for(int j = 0;j < 40;j++) {
			int i = rand.nextInt(15);
			int k = rand.nextInt(15);
			G.AddLigacao("Nome " + i, "Nome " + k, (i*(i+k))/(k+1));
		}

		try {
			MetodoDeBusca.Busca("Nome 1","Nome 13" , G);
		} catch (PontoInexistenteException e) {
			fail("Nao deve vir parar aqui");
			e.printStackTrace();
		} catch (CaminhoImpossivelException e) {
			fail("Nao deve vir parar aqui");
			e.printStackTrace();
		}
		try {
			MetodoDeBusca.Busca("Nome 1","Nome 16" , G);
			fail("Nao deve vir parar aqui");
			
		} catch (PontoInexistenteException e) {
			e.printStackTrace();
		} catch (CaminhoImpossivelException e) {
			e.printStackTrace();
		}
		
	}

}
