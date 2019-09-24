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
package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Classes.Grafo;
import Classes.Ponto;
/**
 * @author Jo�o V�tor Santos de Andrade e Felipe Silva Queiroz
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
