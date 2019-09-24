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
package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import Classes.Ponto;
import Controlador.Sistema;
import Exceptions.CaminhoImpossivelException;
import Exceptions.GrafoVazioException;
import Exceptions.PontoInexistenteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
/**
 * @author João Vítor Santos de Andrade e Felipe Silva Queiroz
 */
public class SampleController {

    @FXML
    private MenuItem Fechar;

    @FXML
    private MenuItem ColetaButton;

    @FXML
    private MenuItem ArestaButton;

    @FXML
    private MenuItem BancoButton;

    @FXML
    private Button RemoveButton;

    @FXML
    private MenuItem EstacionamentoButton;

    @FXML
    private Group Quadro;

    @FXML
    private MenuItem CruzamentoButton;

    @FXML
    private Label EstacionamentoLabel;

    @FXML
    private Label BancoLabel;

    @FXML
    private Button CaminhoButton;

    @FXML
    private TextArea AreaDeTexto;

    @FXML
    private Pane AnchorPane;

    @FXML
    private ProgressBar ProgressBar;

    @FXML
    private Label ColetaLabel;

    
    
    private boolean remove = false;
    private boolean colocarAresta = false;
    private int Cor = 1;
    private int NomePonto[] = {0,0,0,0};
    private Ponto Anterior = null,Proximo = null;
    
    
    
    
    @FXML
    void MouseClicked(MouseEvent event) { // limitar o numero de estacionamentos // Cria os pontos
    	if(Circle.class != event.getTarget().getClass()) { // para nao deixar criar um encima do outro
    		if(!colocarAresta && !remove) {
    			DesenharCirculo(event);
        	}	
    	}
    }
   
    @FXML
    void MousePressed(MouseEvent event) { // Cria as ligacoes
    	if(colocarAresta && !remove) {
    		if(Anterior == null)
    		{
    			if(Circle.class == event.getTarget().getClass()) {
    				Circle aux = (Circle) event.getTarget();
            		Ponto P1 = Sistema.getGrafo().getListaDePontos().BuscaPonto(aux.getId());
            		Anterior = P1;
    			}
    			
    		}
    		else
    		{
    			if(Circle.class == event.getTarget().getClass()) {
    				Path caminho = new Path();
    				Circle aux = (Circle) event.getTarget();
            		Ponto P2 = Sistema.getGrafo().getListaDePontos().BuscaPonto(aux.getId());
            		Proximo = P2;
            		if(Anterior.equals(Proximo)) {
            			caminho = DesenharArcoLigacao(Anterior,Proximo);
            		}
            		else
            		{
            			caminho = DesenharLigacao(Anterior,Proximo);
            		}
            		// Perguntar o tamanho da ligacao
            		TextInputDialog tamanhoLigacao = new TextInputDialog();
            		tamanhoLigacao.setHeaderText("Duracao entre os pontos");
            		tamanhoLigacao.setContentText("Duracao:");
            		tamanhoLigacao.setResult("10");
            		tamanhoLigacao.setTitle("");
            		//
            		
            		int duracao = 0;
            		Optional<String> OptDuracao = tamanhoLigacao.showAndWait();
            		if(OptDuracao.isPresent()) {
            			if(OptDuracao.get().matches(""))
            			{
            				duracao = 10;
            			}
            			else
            				duracao = Integer.parseInt(OptDuracao.get());
            		}
            		else
            		{
            			duracao = 10;
            		}
            		
            		// Colocar o valor encima da Ligacao
            		Text duracaoLigacao = new Text("" + duracao);
            		double X = ((Anterior.getPosX() + Proximo.getPosX())/2);
            		double Y = ((Anterior.getPosY() + Proximo.getPosY())/2);
            		duracaoLigacao.setX(X+5);
            		duracaoLigacao.setY(Y-5);
            		duracaoLigacao.setStrokeWidth(4);
            		duracaoLigacao.setId(Anterior.getNome() + "Value" + Proximo.getNome());
            		//
            		
            		Quadro.getChildren().add(duracaoLigacao);
                	Sistema.AddLigacao(Anterior, Proximo, duracao); // fazer um popUp pra escolher o tempo
                	Anterior = null;
            		Proximo = null;
    			}
    			
    		}
    	}
    	else if(remove) { // remove as ligacoes e/ou os pontos
    		if(Circle.class == event.getTarget().getClass()) {
				Circle aux = (Circle) event.getTarget();
        		Ponto P = Sistema.getGrafo().getListaDePontos().BuscaPonto(aux.getId());
        		if(P.getTipo() == 0) {
        			Sistema.SetEstacionamento(null);
        			NomePonto[P.getTipo()] --; 
        			
        		}
        		if(P.getTipo() == 2) {
        			Sistema.setColeta(null);
        			NomePonto[P.getTipo()] --; 
        		}
        		if(P.getTipo() == 3) {
        			Sistema.setBanco(null);
        			NomePonto[P.getTipo()] --; 
        		}
        		
        		AtualizarQuantidade(P.getTipo(),NomePonto[P.getTipo()]);
        		
        		Sistema.DelPonto(P);
        		Quadro.getChildren().remove(aux);
        		for(int i = 0; i < Quadro.getChildren().size(); i ++) {
        			String nome = Quadro.getChildren().get(i).getId();
        			if(nome.contains(P.getNome())) {
        				Quadro.getChildren().remove(i);
        				i--;
        			}
        		}
			}
    		else if(Path.class == event.getTarget().getClass()) {
    			 Path aux = (Path)event.getTarget();
    			 String nome[] = aux.getId().split("Ligacao");
    			 Ponto P1 = Sistema.getGrafo().getListaDePontos().BuscaPonto(nome[0]);
    			 Ponto P2 = Sistema.getGrafo().getListaDePontos().BuscaPonto(nome[1]);
    			 Sistema.DelLigacao(P1, P2);
    			 Quadro.getChildren().remove(aux);
    			 for(int i = 0; i < Quadro.getChildren().size(); i ++) {
         			String ID = Quadro.getChildren().get(i).getId();
         			if(ID.contains(P1.getNome())) {
         				if(ID.contains(P2.getNome())) {
         					Quadro.getChildren().remove(i);
             				i--;
         				}
         			}
         		}
    		}
    	}
    }

    @FXML
    void ArestaPressed(ActionEvent event) {
    	colocarAresta = true;
    	remove = false;
    }
    
   private Path DesenharArcoLigacao(Ponto P1,Ponto P2) { // desenhar auto ligacao
	   
	   	MoveTo a = new MoveTo(P1.getPosX(),P1.getPosY());
	   	ArcTo b = new ArcTo();
	   	
	   	b.setRadiusX(20);
	   	b.setRadiusY(20);
	   	b.setX(P2.getPosX() + 2);
	   	b.setY(P2.getPosY() + 2);
	   	b.setLargeArcFlag(true);
	   	
	   	Path linha = new Path();
	   	linha.getElements().add(a);
	   	linha.getElements().add(b);
	   	linha.setId(P1.getNome() + "Ligacao" + P2.getNome());
	   	linha.setStrokeWidth(2);
	   	Quadro.getChildren().add(linha);
		return linha;
   }
   private Path DesenharLigacao(Ponto P1,Ponto P2) { // desenhar ligacao
    	MoveTo a = new MoveTo(P1.getPosX(),P1.getPosY());
    	LineTo b = new LineTo(P2.getPosX(),P2.getPosY());
    	Path linha = new Path();
    	linha.getElements().add(a);
    	linha.getElements().add(b);
	   	linha.setId(P1.getNome() + "Ligacao" + P2.getNome());
	   	linha.setStrokeWidth(2);
    	Quadro.getChildren().add(linha);
		return linha;
    }
   private void DesenharLigacaoTxT() { // Desenha ligacao com base o arquivo TXT
	   
	   for(int i = 0; i < Sistema.getGrafo().getListaDePontos().size(); i++) {
		   Ponto P1 = Sistema.getGrafo().getListaDePontos().get(i);
		   for(int j = 0; j < P1.getAdjacente().size(); j++) {
			   Ponto P2 = P1.getAdjacente().get(j);
			   if(P1 == P2) {
				  DesenharArcoLigacao(P1,P2);
				  
			   }
			   else
			   {
				  DesenharLigacao(P1,P2);
			   }
			    Text duracaoLigacao = new Text("" + P1.getDistanciaAdjacente().get(j));
	       		double X = ((P1.getPosX() + P2.getPosX())/2);
	       		double Y = ((P1.getPosY() + P2.getPosY())/2);
	       		duracaoLigacao.setX(X+5);
	       		duracaoLigacao.setY(Y-5);
	       		duracaoLigacao.setStrokeWidth(4);
	       		duracaoLigacao.setId(P1.getNome() + "Value" + P2.getNome());
	       		Quadro.getChildren().add(duracaoLigacao); 
		   }
	   }
   }
   private void DesenharCirculo(String Nome,int Tipo, Ponto aux) {
	   
	   Circle ponto = new Circle();
	   Text nomePonto = new Text();
	   ponto.setRadius(20);
	   
	   if(Tipo == 1)
	   {
	   	nomePonto.setX(aux.getPosX()-35);
	   	nomePonto.setFill(Color.BLACK);
	   	ponto.setFill(Color.GRAY);
	   }
	   if(Tipo == 0)
	   {
	   	nomePonto.setX(aux.getPosX()-40);
	   	nomePonto.setFill(Color.BLACK);
	   	ponto.setFill(Color.YELLOW);
	   }
	   if(Tipo == 2) {
	   	nomePonto.setX(aux.getPosX()-20);
	   	nomePonto.setFill(Color.BLACK);
	   	ponto.setFill(Color.BLUE);
	   }
	   if(Tipo == 3) {
	   	nomePonto.setX(aux.getPosX()-20);
	   	nomePonto.setFill(Color.BLACK);
	   	ponto.setFill(Color.RED);
	   }
	   
	   nomePonto.setId(Nome); // 
	   nomePonto.setText(Nome);
	   	
	   nomePonto.setY(aux.getPosY()-25);
	   	
	   ponto.setId(Nome); //
	   ponto.setCenterX(aux.getPosX()); 
	   ponto.setCenterY(aux.getPosY());
	   
	   Quadro.getChildren().add(ponto);
	   Quadro.getChildren().add(nomePonto);
	   NomePonto[Tipo] ++;

   }
   
  /**
   * Desenha um circulo
   * @param event
   */
   private void DesenharCirculo(MouseEvent event) {
	   	
		   	Circle ponto = new Circle();
		   	String Nome = "";
		   	Text nomePonto = new Text();
		   	ponto.setRadius(20);
		   
			if(Cor == 1)
		   	{
		   		Nome = Nome + "Cruzamento " + NomePonto[Cor]; 
		   		nomePonto.setX(event.getX()-45);
		   		nomePonto.setFill(Color.BLACK);
		   		ponto.setFill(Color.GRAY);
		   	}
		   	if(Cor == 0)
		   	{
		   		Nome = Nome + "Estacionamento " + NomePonto[Cor];
		   		nomePonto.setX(event.getX()-50);
		   		nomePonto.setFill(Color.BLACK);
		   		ponto.setFill(Color.YELLOW);
		   	}
		   	if(Cor == 2) {
		   		Nome = Nome + "Coleta " + NomePonto[Cor];
		   		nomePonto.setX(event.getX()-30);
		   		nomePonto.setFill(Color.BLACK);
		   		ponto.setFill(Color.BLUE);
		   	}
		   	if(Cor == 3) {
		   		Nome = Nome + "Banco " + NomePonto[Cor];
		   		nomePonto.setX(event.getX()-30);
		   		nomePonto.setFill(Color.BLACK);
		   		ponto.setFill(Color.RED);
		   	}
		   	nomePonto.setId(Nome); // 
		   	nomePonto.setText(Nome);
		   	
		   	nomePonto.setY(event.getY()-35);
		   	
		   	ponto.setId(Nome); //
		   	ponto.setCenterX(event.getX()-10); 
		   	ponto.setCenterY(event.getY()-10);
		   	
		   	if(Cor != 1 && NomePonto[Cor] == 0) {
		   			Sistema.AddPonto(Nome, Cor,event.getX()-10,event.getY()-10);
		   			Quadro.getChildren().add(ponto);
		           	Quadro.getChildren().add(nomePonto);
		   			NomePonto[Cor] ++;
		   			AtualizarQuantidade(Cor,NomePonto[Cor]);
		   		}
		   	
		   else if(Cor == 1)
		   		{
		   			Sistema.AddPonto(Nome, Cor,event.getX()-10,event.getY()-10);
		   			Quadro.getChildren().add(ponto);
		           	Quadro.getChildren().add(nomePonto);
		   			NomePonto[Cor] ++;
		   		}
					
				
   }
    
   
   	private void AtualizarQuantidade(int tipo, int quantidade) {
   		if(tipo == 0) {
   			EstacionamentoLabel.setText("Estacionamento: " + quantidade + "/1");
   		}
   		else if(tipo == 2) {
   			ColetaLabel.setText("Coleta: " + quantidade + "/1");
   		}
   		else if(tipo == 3) {
   			BancoLabel.setText("Banco: " + quantidade + "/1");
   		}
   	}
   
    @FXML
    void FecharPrograma(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void LerArquivo(ActionEvent event) {
    	Quadro.getChildren().clear();
    	NomePonto[0] = 0;
    	NomePonto[2] = 0;
    	NomePonto[3] = 0;
    	
			try {
				Sistema.LerTxT();
			} catch (FileNotFoundException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Algo impossibilitou a leitura do arquivo!");
				alert.setHeaderText(null);
				alert.setContentText("Verifique se os dados de Pontos e Arestas estao no diretorio do progama");
				alert.showAndWait();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    	for(int i = 0; i < Sistema.getGrafo().getListaDePontos().size(); i++) {
    		Ponto aux = Sistema.getGrafo().getListaDePontos().get(i);
    		DesenharCirculo(aux.getNome(),aux.getTipo(),aux);
    	}
    	DesenharLigacaoTxT();
    	AtualizarQuantidade(0,NomePonto[0]);
    	AtualizarQuantidade(2,NomePonto[2]);
    	AtualizarQuantidade(3,NomePonto[3]);
    		
    }

    @FXML
    void SaveButtonPressed(ActionEvent event) {
    	try {
			Sistema.SalvarTxt();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Algo impossibilitou o salvamento do arquivo!");
			alert.setHeaderText(null);
			alert.setContentText("Verifique se o progama possui permissao para salvar no diretorio onde o mesmo se encontra");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void CruzamentoAction(ActionEvent event) {
    	Cor = 1;
    	colocarAresta = false;
    	remove = false;
    }

    @FXML
    void EstacionamentoAction(ActionEvent event) {
    	Cor = 0;
    	colocarAresta = false;
    	remove = false;
    }

    @FXML
    void ColetaAction(ActionEvent event) {
    	Cor = 2;
    	colocarAresta = false;
    	remove = false;
    }

    @FXML
    void BancoAction(ActionEvent event) {
    	Cor = 3;
    	colocarAresta = false;
    	remove = false;
    }

    @FXML
    void RemoveSomething(ActionEvent event) { // fazer
    	colocarAresta = false;
    	remove = true;
    }

    @FXML
    void CalcularCaminho(ActionEvent event) {
    	ProgressBar.setProgress(-1);
    	
		try {
			AreaDeTexto.setText(Sistema.MenorCaminhoString());
		} catch (GrafoVazioException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro com o Grafo");
			alert.setHeaderText(null);
			alert.setContentText("Nao existem pontos no Grafo");
			alert.showAndWait();
			
		} catch (PontoInexistenteException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro com o Grafo");
			alert.setHeaderText(null);
			alert.setContentText("Algum dos pontos importantes (Estacionamento/Coleta/Banco) nao existem no Grafo");
			alert.showAndWait();
			
		} catch (CaminhoImpossivelException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ligacao Inexistente");
			alert.setHeaderText(null);
			alert.setContentText("Falta ligacao/oes para se completar o caminho entre os pontos importantes");
			alert.showAndWait();
		}
		
    	ProgressBar.setProgress(1);
    	
    }
}


