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

package Exceptions;
/**
 * Excecao para caso o Grafo esteja vazio
 * @author Felipe Silva Queiroz e Jo�o V�tor Santos de Andrade
 */
public class GrafoVazioException extends Exception {

	
	public GrafoVazioException() {
		
	}
	@Override
	public String getMessage()
	{
		return "Nao existe pontos no Grafo!";
	}
}
