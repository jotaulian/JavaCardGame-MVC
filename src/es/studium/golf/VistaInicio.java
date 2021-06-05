package es.studium.golf;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class VistaInicio
{
	//Componentes
	Frame ventana = new Frame("Golf de Seis Cartas");
	
	Panel pnlP1 = new Panel();
	Panel pnlP2 = new Panel();
	Panel pnlP3 = new Panel();
	Panel pnlP4 = new Panel();
	Panel pnlBotones = new Panel();
	
	Label lblTitulo = new Label("\s\s\s\sMENÚ PRINCIPAL");
	Label lblEspacioIzquierda = new Label("\t\t\t\t");
	Label lblEspacioDerecha = new Label("\t\t\t\t");
	Button btnNuevaPartida = new Button("Nueva Partida");
	Button btnPuntajes = new Button("Mejores Puntajes");
	Button btnAyuda = new Button("Ayuda");
	Button btnSalir = new Button("Salir");
	
	// Componentes para MostrarRanking()
	Frame ventanaRanking = new Frame("Golf: Ranking");
	TextArea txaConsulta = new TextArea(15,40);
	Button btnVolverPuntajes = new Button("Volver");

	// Componentes para VentanaElegirNumeroJugadores()
	Frame ventanaElegirNumeroJugadores = new Frame("Golf: Nueva Partida");
	Label lblElegirNumeroJugadores = new Label("Elegir el número de jugadores: ");
	Choice choJugadores = new Choice();
	Button btnContinuar = new Button("Continuar");
		
	// Componentes para VentanaElegirNumeroJugadores()
	Frame ventanaInfoJugadores = new Frame("Golf: Nueva Partida");
	Label lblIngresarNombreJugadores = new Label("Ingresar el nombre de los jugadores: ");
	Label lblJugador1 = new Label("Jugador 1: ");
	TextField txtJugador1 = new TextField(20);
	Label lblJugador2 = new Label("Jugador 2: ");
	TextField txtJugador2 = new TextField(20);
	Label lblJugador3 = new Label("Jugador 3: ");
	TextField txtJugador3 = new TextField(20);
	Label lblJugador4 = new Label("Jugador 4: ");
	TextField txtJugador4 = new TextField(20);
	Button btnComenzarPartida = new Button("Comenzar Partida");		
	
	// Constructor de la clase
	 public VistaInicio()
	 {
		 ventana.setLayout (new BorderLayout());
		 
		 pnlP1.add(lblTitulo);
		 ventana.add( "North", pnlP1);
		 pnlP3.add(lblEspacioIzquierda);
		 ventana. add( "East", pnlP3);
		 pnlP4.add(lblEspacioDerecha);
		 ventana.add( "West", pnlP4);
		 pnlBotones.add(btnNuevaPartida);
		 pnlBotones.add(btnPuntajes);
		 pnlBotones.add(btnAyuda);
		 ventana. add( "Center", pnlBotones);
		 pnlP2.add(btnSalir);
		 ventana.add( "South", pnlP2);
		 
		 ventana.setSize(290,200);
		 ventana.setLocationRelativeTo(null);
		 ventana.setResizable(false);
		 ventana.setVisible(true);
	 
	  }
	 
	 //Método para mostrar ranking
	 public void MostrarRanking()
		{
			ventanaRanking.setLayout(new FlowLayout());
			ventanaRanking.setSize(400,320);
			txaConsulta.append("#ID\t\tNombre\t\tPuntos\n");
			ventanaRanking.add(txaConsulta);
			ventanaRanking.add(btnVolverPuntajes);
			ventanaRanking.setVisible(true);
			ventanaRanking.setResizable(false);
			ventanaRanking.setLocationRelativeTo(null);
		}
	 
	 //Método que abre ventana para indicar la cantidad de jugadores
	 public void VentanaElegirNumeroJugadores() {
		 ventanaElegirNumeroJugadores.setLayout(new FlowLayout());
		 ventanaElegirNumeroJugadores.setSize(300,150);
		 ventanaElegirNumeroJugadores.add(lblElegirNumeroJugadores);
		 choJugadores.removeAll();
		 choJugadores.add("Dos Jugadores");
		 choJugadores.add("Tres Jugadores");
		 choJugadores.add("Cuatro Jugadores");
		 ventanaElegirNumeroJugadores.add(choJugadores);
		 ventanaElegirNumeroJugadores.add(btnContinuar);
		 ventanaElegirNumeroJugadores.setLocationRelativeTo(null);
		 ventanaElegirNumeroJugadores.setVisible(true);
	 }
	 
	//Métodos para indicar la cantidad de jugadores
		 public void VentanaInfoDosJugadores() {
			 ventanaInfoJugadores.setLayout(new FlowLayout());
			 ventanaInfoJugadores.setSize(300,200);
			 ventanaInfoJugadores.add(lblIngresarNombreJugadores);
			 ventanaInfoJugadores.add(lblJugador1);
			 ventanaInfoJugadores.add(txtJugador1);
			 ventanaInfoJugadores.add(lblJugador2);
			 ventanaInfoJugadores.add(txtJugador2);
			 ventanaInfoJugadores.add(btnComenzarPartida);
			 ventanaInfoJugadores.setLocationRelativeTo(null);
			 ventanaInfoJugadores.setResizable(false);
			 ventanaInfoJugadores.setVisible(true);
		 }
		 public void VentanaInfoTresJugadores() {
			 ventanaInfoJugadores.setLayout(new FlowLayout());
			 ventanaInfoJugadores.setSize(300,200);
			 ventanaInfoJugadores.add(lblIngresarNombreJugadores);
			 ventanaInfoJugadores.add(lblJugador1);
			 ventanaInfoJugadores.add(txtJugador1);
			 ventanaInfoJugadores.add(lblJugador2);
			 ventanaInfoJugadores.add(txtJugador2);
			 ventanaInfoJugadores.add(lblJugador3);
			 ventanaInfoJugadores.add(txtJugador3);
			 ventanaInfoJugadores.add(btnComenzarPartida);
			 ventanaInfoJugadores.setLocationRelativeTo(null);
			 ventanaInfoJugadores.setResizable(false);
			 ventanaInfoJugadores.setVisible(true);
		 }
		 public void VentanaInfoCuatroJugadores() {
			 ventanaInfoJugadores.setLayout(new FlowLayout());
			 ventanaInfoJugadores.setSize(300,250);
			 ventanaInfoJugadores.add(lblIngresarNombreJugadores);
			 ventanaInfoJugadores.add(lblJugador1);
			 ventanaInfoJugadores.add(txtJugador1);
			 ventanaInfoJugadores.add(lblJugador2);
			 ventanaInfoJugadores.add(txtJugador2);
			 ventanaInfoJugadores.add(lblJugador3);
			 ventanaInfoJugadores.add(txtJugador3);
			 ventanaInfoJugadores.add(lblJugador4);
			 ventanaInfoJugadores.add(txtJugador4);
			 ventanaInfoJugadores.add(btnComenzarPartida);
			 ventanaInfoJugadores.setLocationRelativeTo(null);
			 ventanaInfoJugadores.setResizable(false);
			 ventanaInfoJugadores.setVisible(true);
		 }
	 
	 
}
