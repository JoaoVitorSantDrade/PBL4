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

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Classes.Grafo;
import Classes.Ponto;
/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class GrafoTest {

	Grafo G;
	Ponto A = new Ponto("A");
	Ponto B = new Ponto("B");
	
	@Before
	public void setUp() throws Exception {
		G = new Grafo();
		A = new Ponto("A");
		B = new Ponto("B");
	}

	@Test
	public void testListaDePontos() {
		assertEquals(0,G.getListaDePontos().size());
		
		try {
			G.getListaDePontos().add(A);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			G.getListaDePontos().add(B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2,G.getListaDePontos().size());
	}

	@Test
	public void testAddPonto() {
		assertEquals(0,G.getListaDePontos().size());
		try {
			G.AddPonto("Biscoito", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			G.AddPonto("Bolacha", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2,G.getListaDePontos().size());
	}

	@Test
	public void testAddLigacaoPontoPontoInt() {
		assertEquals(0,G.getListaDePontos().size());
		try {
			G.AddPonto("Biscoito", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			G.AddPonto("Bolacha", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2,G.getListaDePontos().size());
		
		G.AddLigacao("Biscoito", "Bolacha", 15);
		Ponto Aux = G.getListaDePontos().get(0);
		assertEquals("Bolacha",Aux.getAdjacente().get(0).getNome());
		assertEquals(15,Aux.getDistanciaAdjacente().get(0),0.001);
	}

	@Test
	public void testDelPontoPonto() {
		assertEquals(0,G.getListaDePontos().size());
		try {
			G.AddPonto("Biscoito", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			G.AddPonto("Bolacha", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2,G.getListaDePontos().size());
		
		assertEquals("Biscoito", G.getListaDePontos().get(0).getNome());
		G.DelPonto("Biscoito");
		assertEquals("Bolacha", G.getListaDePontos().get(0).getNome());
	}

	@Test
	public void testDelLigacaoStringString() {
		assertEquals(0,G.getListaDePontos().size());
		try {
			G.AddPonto("Biscoito", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			G.AddPonto("Bolacha", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2,G.getListaDePontos().size());
		
		G.AddLigacao("Biscoito", "Bolacha", 15);
		Ponto Aux = G.getListaDePontos().get(0);
		assertEquals("Bolacha",Aux.getAdjacente().get(0).getNome());
		assertEquals(15,Aux.getDistanciaAdjacente().get(0),0.001);
		
		try {
			G.DelLigacao("Biscoito", "Bolacha");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,Aux.getAdjacente().size(),0.001);

	}

}
