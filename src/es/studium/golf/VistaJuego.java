package es.studium.golf;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class VistaJuego extends Frame
{
	private static final long serialVersionUID = 1L;
	Toolkit herramientas;
	Image tapete, reverso;
	// A --> Diamantes || B --> Corazones || C --> Tréboles || D --> Picas
	Image A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13;
	Image B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13;
	Image C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13;
	Image D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12, D13;
	int imagenAmostrarJug1Pos00 = 0;
	int imagenAmostrarJug1Pos01 = 0;
	int imagenAmostrarJug1Pos02 = 0;
	int imagenAmostrarJug1Pos10 = 0;
	int imagenAmostrarJug1Pos11 = 0;
	int imagenAmostrarJug1Pos12 = 0;
	
	int imagenAmostrarJug2Pos00 = 0;
	int imagenAmostrarJug2Pos01 = 0;
	int imagenAmostrarJug2Pos02 = 0;
	int imagenAmostrarJug2Pos10 = 0;
	int imagenAmostrarJug2Pos11 = 0;
	int imagenAmostrarJug2Pos12 = 0;
	
	int imagenAmostrarDescarte = 0;
	int imagenAmostrarTemporal = 0;
	int puntosJugador1;
	int puntosJugador2;
	
	//Posiciones de las cartas:
	int posXDescarte = 497;
	int posYDescarte = 350;
	int posXTemporal = 730;
	int posYTemporal = 370;
	
	int posXCartasIzquierda = 440;
	int posXCartasCentro = 531;
	int posXCartasDerecha = 622;
	
	//Nombres de los Jugadores
	String nombreJug1 = "";
	String nombreJug2 = "";
	
	Dialog dlgMensaje = new Dialog(this, "Fin", true);
	Label lblMensaje = new Label("");
	Label lblPuntosJ1 = new Label("");
	Label lblPuntosJ2 = new Label("Puntos de " + nombreJug2 + puntosJugador2);
	
	public VistaJuego()
	{
		herramientas = getToolkit();
		tapete = herramientas.getImage("img/fondoMinimal.png");
		reverso = herramientas.getImage("img/reverso.png");
		cargarCartas();
		this.setTitle("Golf de Seis Cartas");
		this.setSize(1200,800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(false);
		
		dlgMensaje.setLayout(new FlowLayout());
		dlgMensaje.setSize(200,150);
		dlgMensaje.setLocationRelativeTo(null);
		dlgMensaje.setResizable(false);
		dlgMensaje.add(lblMensaje);
		dlgMensaje.add(lblPuntosJ1);
		dlgMensaje.add(lblPuntosJ2);
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(tapete, 0, 30, this); //Dibujamos imagen fondo
		g.drawImage(reverso, 590, 350, this); //Dibujamos Mazo
		//Rectangulo para los nombres
		Color colorRec = new Color(211,156,6,250);
		g.setColor(colorRec);
		g.fillRect(280, 50, 110, 30);
		g.fillRect(775, 745, 110, 30);
		g.setColor(Color.black);
		g.drawRect(280, 50, 110, 30);
		g.drawRect(775, 745, 110, 30);
		//Dibujamos los nombres
		Font fuente = new Font("Segoe UI", Font.BOLD, 20);
		g.setFont(fuente);
		g.drawString(nombreJug1, 285, 70); 
		g.drawString(nombreJug2, 780, 765);
		
		//Para dibujar las cartas que cambian de valor usaremos bucles 'switch'. 
		//Un bucle por cada carta a mostrar --> Mazo descarte + Carta temporal + (6 x jugador) --> 14.
		switch(imagenAmostrarDescarte)
		{
		case 1:
			g.drawImage(A1, posXDescarte, posYDescarte, this);
			break;
		case 2:
			g.drawImage(A2, posXDescarte, posYDescarte, this);
			break;
		case 3:
			g.drawImage(A3, posXDescarte, posYDescarte, this);
			break;
		case 4:
			g.drawImage(A4, posXDescarte, posYDescarte, this);
			break;
		case 5:
			g.drawImage(A5, posXDescarte, posYDescarte, this);
			break;
		case 6:
			g.drawImage(A6, posXDescarte, posYDescarte, this);
			break;
		case 7:
			g.drawImage(A7, posXDescarte, posYDescarte, this);
			break;
		case 8:
			g.drawImage(A8, posXDescarte, posYDescarte, this);
			break;
		case 9:
			g.drawImage(A9, posXDescarte, posYDescarte, this);
			break;
		case 10:
			g.drawImage(A10, posXDescarte, posYDescarte, this);
			break;
		case 11:
			g.drawImage(A11, posXDescarte, posYDescarte, this);
			break;
		case 12:
			g.drawImage(A12, posXDescarte, posYDescarte, this);
			break;
		case 13:
			g.drawImage(A13, posXDescarte, posYDescarte, this);
			break;
		case 14:
			g.drawImage(B1, posXDescarte, posYDescarte, this);
			break;
		case 15:
			g.drawImage(B2, posXDescarte, posYDescarte, this);
			break;
		case 16:
			g.drawImage(B3, posXDescarte, posYDescarte, this);
			break;
		case 17:
			g.drawImage(B4, posXDescarte, posYDescarte, this);
			break;
		case 18:
			g.drawImage(B5, posXDescarte, posYDescarte, this);
			break;
		case 19:
			g.drawImage(B6, posXDescarte, posYDescarte, this);
			break;
		case 20:
			g.drawImage(B7, posXDescarte, posYDescarte, this);
			break;
		case 21:
			g.drawImage(B8, posXDescarte, posYDescarte, this);
			break;
		case 22:
			g.drawImage(B9, posXDescarte, posYDescarte, this);
			break;
		case 23:
			g.drawImage(B10, posXDescarte, posYDescarte, this);
			break;
		case 24:
			g.drawImage(B11, posXDescarte, posYDescarte, this);
			break;
		case 25:
			g.drawImage(B12, posXDescarte, posYDescarte, this);
			break;
		case 26:
			g.drawImage(B13, posXDescarte, posYDescarte, this);
			break;
		case 27:
			g.drawImage(C1, posXDescarte, posYDescarte, this);
			break;
		case 28:
			g.drawImage(C2, posXDescarte, posYDescarte, this);
			break;
		case 29:
			g.drawImage(C3, posXDescarte, posYDescarte, this);
			break;
		case 30:
			g.drawImage(C4, posXDescarte, posYDescarte, this);
			break;
		case 31:
			g.drawImage(C5, posXDescarte, posYDescarte, this);
			break;
		case 32:
			g.drawImage(C6, posXDescarte, posYDescarte, this);
			break;
		case 33:
			g.drawImage(C7, posXDescarte, posYDescarte, this);
			break;
		case 34:
			g.drawImage(C8, posXDescarte, posYDescarte, this);
			break;
		case 35:
			g.drawImage(C9, posXDescarte, posYDescarte, this);
			break;
		case 36:
			g.drawImage(C10, posXDescarte, posYDescarte, this);
			break;
		case 37:
			g.drawImage(C11, posXDescarte, posYDescarte, this);
			break;
		case 38:
			g.drawImage(C12, posXDescarte, posYDescarte, this);
			break;
		case 39:
			g.drawImage(C13, posXDescarte, posYDescarte, this);
			break;
		case 40:
			g.drawImage(D1, posXDescarte, posYDescarte, this);
			break;
		case 41:
			g.drawImage(D2, posXDescarte, posYDescarte, this);
			break;
		case 42:
			g.drawImage(D3, posXDescarte, posYDescarte, this);
			break;
		case 43:
			g.drawImage(D4, posXDescarte, posYDescarte, this);
			break;
		case 44:
			g.drawImage(D5, posXDescarte, posYDescarte, this);
			break;
		case 45:
			g.drawImage(D6, posXDescarte, posYDescarte, this);
			break;
		case 46:
			g.drawImage(D7, posXDescarte, posYDescarte, this);
			break;
		case 47:
			g.drawImage(D8, posXDescarte, posYDescarte, this);
			break;
		case 48:
			g.drawImage(D9, posXDescarte, posYDescarte, this);
			break;
		case 49:
			g.drawImage(D10, posXDescarte, posYDescarte, this);
			break;
		case 50:
			g.drawImage(D11, posXDescarte, posYDescarte, this);
			break;
		case 51:
			g.drawImage(D12, posXDescarte, posYDescarte, this);
			break;
		case 52:
			g.drawImage(D13, posXDescarte, posYDescarte, this);
			break;
		}
		switch(imagenAmostrarTemporal)
		{
		case 1:
			g.drawImage(A1, posXTemporal, posYTemporal, this);
			break;
		case 2:
			g.drawImage(A2, posXTemporal, posYTemporal, this);
			break;
		case 3:
			g.drawImage(A3, posXTemporal, posYTemporal, this);
			break;
		case 4:
			g.drawImage(A4, posXTemporal, posYTemporal, this);
			break;
		case 5:
			g.drawImage(A5, posXTemporal, posYTemporal, this);
			break;
		case 6:
			g.drawImage(A6, posXTemporal, posYTemporal, this);
			break;
		case 7:
			g.drawImage(A7, posXTemporal, posYTemporal, this);
			break;
		case 8:
			g.drawImage(A8, posXTemporal, posYTemporal, this);
			break;
		case 9:
			g.drawImage(A9, posXTemporal, posYTemporal, this);
			break;
		case 10:
			g.drawImage(A10, posXTemporal, posYTemporal, this);
			break;
		case 11:
			g.drawImage(A11, posXTemporal, posYTemporal, this);
			break;
		case 12:
			g.drawImage(A12, posXTemporal, posYTemporal, this);
			break;
		case 13:
			g.drawImage(A13, posXTemporal, posYTemporal, this);
			break;
		case 14:
			g.drawImage(B1, posXTemporal, posYTemporal, this);
			break;
		case 15:
			g.drawImage(B2, posXTemporal, posYTemporal, this);
			break;
		case 16:
			g.drawImage(B3, posXTemporal, posYTemporal, this);
			break;
		case 17:
			g.drawImage(B4, posXTemporal, posYTemporal, this);
			break;
		case 18:
			g.drawImage(B5, posXTemporal, posYTemporal, this);
			break;
		case 19:
			g.drawImage(B6, posXTemporal, posYTemporal, this);
			break;
		case 20:
			g.drawImage(B7, posXTemporal, posYTemporal, this);
			break;
		case 21:
			g.drawImage(B8, posXTemporal, posYTemporal, this);
			break;
		case 22:
			g.drawImage(B9, posXTemporal, posYTemporal, this);
			break;
		case 23:
			g.drawImage(B10, posXTemporal, posYTemporal, this);
			break;
		case 24:
			g.drawImage(B11, posXTemporal, posYTemporal, this);
			break;
		case 25:
			g.drawImage(B12, posXTemporal, posYTemporal, this);
			break;
		case 26:
			g.drawImage(B13, posXTemporal, posYTemporal, this);
			break;
		case 27:
			g.drawImage(C1, posXTemporal, posYTemporal, this);
			break;
		case 28:
			g.drawImage(C2, posXTemporal, posYTemporal, this);
			break;
		case 29:
			g.drawImage(C3, posXTemporal, posYTemporal, this);
			break;
		case 30:
			g.drawImage(C4, posXTemporal, posYTemporal, this);
			break;
		case 31:
			g.drawImage(C5, posXTemporal, posYTemporal, this);
			break;
		case 32:
			g.drawImage(C6, posXTemporal, posYTemporal, this);
			break;
		case 33:
			g.drawImage(C7, posXTemporal, posYTemporal, this);
			break;
		case 34:
			g.drawImage(C8, posXTemporal, posYTemporal, this);
			break;
		case 35:
			g.drawImage(C9, posXTemporal, posYTemporal, this);
			break;
		case 36:
			g.drawImage(C10, posXTemporal, posYTemporal, this);
			break;
		case 37:
			g.drawImage(C11, posXTemporal, posYTemporal, this);
			break;
		case 38:
			g.drawImage(C12, posXTemporal, posYTemporal, this);
			break;
		case 39:
			g.drawImage(C13, posXTemporal, posYTemporal, this);
			break;
		case 40:
			g.drawImage(D1, posXTemporal, posYTemporal, this);
			break;
		case 41:
			g.drawImage(D2, posXTemporal, posYTemporal, this);
			break;
		case 42:
			g.drawImage(D3, posXTemporal, posYTemporal, this);
			break;
		case 43:
			g.drawImage(D4, posXTemporal, posYTemporal, this);
			break;
		case 44:
			g.drawImage(D5, posXTemporal, posYTemporal, this);
			break;
		case 45:
			g.drawImage(D6, posXTemporal, posYTemporal, this);
			break;
		case 46:
			g.drawImage(D7, posXTemporal, posYTemporal, this);
			break;
		case 47:
			g.drawImage(D8, posXTemporal, posYTemporal, this);
			break;
		case 48:
			g.drawImage(D9, posXTemporal, posYTemporal, this);
			break;
		case 49:
			g.drawImage(D10, posXTemporal, posYTemporal, this);
			break;
		case 50:
			g.drawImage(D11, posXTemporal, posYTemporal, this);
			break;
		case 51:
			g.drawImage(D12, posXTemporal, posYTemporal, this);
			break;
		case 52:
			g.drawImage(D13, posXTemporal, posYTemporal, this);
			break;
		}
		
		//Cartas Jugador 1:
		switch(imagenAmostrarJug1Pos00)
		{
		case 1:
			g.drawImage(A1, posXCartasIzquierda, 50, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasIzquierda, 50, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasIzquierda, 50, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasIzquierda, 50, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasIzquierda, 50, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasIzquierda, 50, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasIzquierda, 50, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasIzquierda, 50, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasIzquierda, 50, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasIzquierda, 50, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasIzquierda, 50, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasIzquierda, 50, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasIzquierda, 50, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasIzquierda, 50, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasIzquierda, 50, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasIzquierda, 50, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasIzquierda, 50, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasIzquierda, 50, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasIzquierda, 50, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasIzquierda, 50, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasIzquierda, 50, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasIzquierda, 50, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasIzquierda, 50, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasIzquierda, 50, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasIzquierda, 50, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasIzquierda, 50, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasIzquierda, 50, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasIzquierda, 50, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasIzquierda, 50, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasIzquierda, 50, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasIzquierda, 50, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasIzquierda, 50, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasIzquierda, 50, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasIzquierda, 50, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasIzquierda, 50, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasIzquierda, 50, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasIzquierda, 50, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasIzquierda, 50, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasIzquierda, 50, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasIzquierda, 50, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasIzquierda, 50, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasIzquierda, 50, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasIzquierda, 50, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasIzquierda, 50, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasIzquierda, 50, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasIzquierda, 50, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasIzquierda, 50, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasIzquierda, 50, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasIzquierda, 50, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasIzquierda, 50, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasIzquierda, 50, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasIzquierda, 50, this);
			break;
		default:
			g.drawImage(reverso, posXCartasIzquierda, 50,this);
		}
		switch(imagenAmostrarJug1Pos01)
		{
		case 1:
			g.drawImage(A1, posXCartasCentro, 50, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasCentro, 50, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasCentro, 50, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasCentro, 50, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasCentro, 50, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasCentro, 50, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasCentro, 50, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasCentro, 50, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasCentro, 50, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasCentro, 50, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasCentro, 50, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasCentro, 50, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasCentro, 50, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasCentro, 50, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasCentro, 50, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasCentro, 50, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasCentro, 50, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasCentro, 50, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasCentro, 50, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasCentro, 50, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasCentro, 50, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasCentro, 50, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasCentro, 50, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasCentro, 50, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasCentro, 50, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasCentro, 50, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasCentro, 50, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasCentro, 50, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasCentro, 50, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasCentro, 50, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasCentro, 50, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasCentro, 50, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasCentro, 50, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasCentro, 50, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasCentro, 50, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasCentro, 50, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasCentro, 50, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasCentro, 50, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasCentro, 50, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasCentro, 50, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasCentro, 50, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasCentro, 50, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasCentro, 50, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasCentro, 50, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasCentro, 50, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasCentro, 50, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasCentro, 50, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasCentro, 50, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasCentro, 50, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasCentro, 50, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasCentro, 50, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasCentro, 50, this);
			break;
		default:
			g.drawImage(reverso, posXCartasCentro, 50,this);
		}
		
		switch(imagenAmostrarJug1Pos02)
		{
		case 1:
			g.drawImage(A1, posXCartasDerecha, 50, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasDerecha, 50, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasDerecha, 50, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasDerecha, 50, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasDerecha, 50, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasDerecha, 50, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasDerecha, 50, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasDerecha, 50, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasDerecha, 50, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasDerecha, 50, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasDerecha, 50, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasDerecha, 50, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasDerecha, 50, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasDerecha, 50, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasDerecha, 50, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasDerecha, 50, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasDerecha, 50, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasDerecha, 50, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasDerecha, 50, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasDerecha, 50, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasDerecha, 50, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasDerecha, 50, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasDerecha, 50, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasDerecha, 50, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasDerecha, 50, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasDerecha, 50, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasDerecha, 50, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasDerecha, 50, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasDerecha, 50, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasDerecha, 50, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasDerecha, 50, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasDerecha, 50, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasDerecha, 50, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasDerecha, 50, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasDerecha, 50, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasDerecha, 50, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasDerecha, 50, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasDerecha, 50, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasDerecha, 50, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasDerecha, 50, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasDerecha, 50, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasDerecha, 50, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasDerecha, 50, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasDerecha, 50, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasDerecha, 50, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasDerecha, 50, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasDerecha, 50, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasDerecha, 50, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasDerecha, 50, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasDerecha, 50, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasDerecha, 50, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasDerecha, 50, this);
			break;
		default:
			g.drawImage(reverso, posXCartasDerecha, 50, this);
		}
		
		switch(imagenAmostrarJug1Pos10)
		{
		case 1:
			g.drawImage(A1, posXCartasIzquierda, 173, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasIzquierda, 173, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasIzquierda, 173, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasIzquierda, 173, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasIzquierda, 173, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasIzquierda, 173, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasIzquierda, 173, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasIzquierda, 173, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasIzquierda, 173, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasIzquierda, 173, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasIzquierda, 173, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasIzquierda, 173, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasIzquierda, 173, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasIzquierda, 173, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasIzquierda, 173, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasIzquierda, 173, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasIzquierda, 173, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasIzquierda, 173, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasIzquierda, 173, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasIzquierda, 173, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasIzquierda, 173, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasIzquierda, 173, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasIzquierda, 173, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasIzquierda, 173, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasIzquierda, 173, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasIzquierda, 173, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasIzquierda, 173, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasIzquierda, 173, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasIzquierda, 173, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasIzquierda, 173, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasIzquierda, 173, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasIzquierda, 173, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasIzquierda, 173, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasIzquierda, 173, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasIzquierda, 173, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasIzquierda, 173, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasIzquierda, 173, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasIzquierda, 173, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasIzquierda, 173, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasIzquierda, 173, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasIzquierda, 173, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasIzquierda, 173, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasIzquierda, 173, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasIzquierda, 173, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasIzquierda, 173, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasIzquierda, 173, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasIzquierda, 173, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasIzquierda, 173, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasIzquierda, 173, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasIzquierda, 173, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasIzquierda, 173, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasIzquierda, 173, this);
			break;
		default:
			g.drawImage(reverso, posXCartasIzquierda, 173,this);
		}
		
		switch(imagenAmostrarJug1Pos11)
		{
		case 1:
			g.drawImage(A1, posXCartasCentro, 173, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasCentro, 173, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasCentro, 173, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasCentro, 173, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasCentro, 173, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasCentro, 173, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasCentro, 173, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasCentro, 173, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasCentro, 173, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasCentro, 173, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasCentro, 173, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasCentro, 173, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasCentro, 173, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasCentro, 173, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasCentro, 173, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasCentro, 173, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasCentro, 173, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasCentro, 173, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasCentro, 173, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasCentro, 173, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasCentro, 173, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasCentro, 173, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasCentro, 173, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasCentro, 173, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasCentro, 173, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasCentro, 173, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasCentro, 173, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasCentro, 173, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasCentro, 173, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasCentro, 173, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasCentro, 173, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasCentro, 173, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasCentro, 173, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasCentro, 173, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasCentro, 173, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasCentro, 173, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasCentro, 173, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasCentro, 173, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasCentro, 173, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasCentro, 173, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasCentro, 173, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasCentro, 173, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasCentro, 173, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasCentro, 173, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasCentro, 173, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasCentro, 173, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasCentro, 173, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasCentro, 173, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasCentro, 173, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasCentro, 173, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasCentro, 173, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasCentro, 173, this);
			break;
		default:
			g.drawImage(reverso, posXCartasCentro, 173,this);
		}
		switch(imagenAmostrarJug1Pos12)
		{
		case 1:
			g.drawImage(A1, posXCartasDerecha, 173, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasDerecha, 173, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasDerecha, 173, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasDerecha, 173, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasDerecha, 173, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasDerecha, 173, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasDerecha, 173, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasDerecha, 173, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasDerecha, 173, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasDerecha, 173, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasDerecha, 173, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasDerecha, 173, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasDerecha, 173, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasDerecha, 173, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasDerecha, 173, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasDerecha, 173, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasDerecha, 173, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasDerecha, 173, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasDerecha, 173, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasDerecha, 173, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasDerecha, 173, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasDerecha, 173, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasDerecha, 173, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasDerecha, 173, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasDerecha, 173, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasDerecha, 173, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasDerecha, 173, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasDerecha, 173, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasDerecha, 173, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasDerecha, 173, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasDerecha, 173, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasDerecha, 173, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasDerecha, 173, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasDerecha, 173, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasDerecha, 173, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasDerecha, 173, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasDerecha, 173, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasDerecha, 173, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasDerecha, 173, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasDerecha, 173, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasDerecha, 173, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasDerecha, 173, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasDerecha, 173, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasDerecha, 173, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasDerecha, 173, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasDerecha, 173, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasDerecha, 173, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasDerecha, 173, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasDerecha, 173, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasDerecha, 173, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasDerecha, 173, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasDerecha, 173, this);
			break;
		default:
			g.drawImage(reverso, posXCartasDerecha, 173,this);
		}
		
		//Cartas Jugador 2:
		switch(imagenAmostrarJug2Pos00)
		{
		case 1:
			g.drawImage(A1, posXCartasIzquierda, 530, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasIzquierda, 530, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasIzquierda, 530, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasIzquierda, 530, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasIzquierda, 530, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasIzquierda, 530, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasIzquierda, 530, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasIzquierda, 530, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasIzquierda, 530, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasIzquierda, 530, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasIzquierda, 530, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasIzquierda, 530, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasIzquierda, 530, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasIzquierda, 530, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasIzquierda, 530, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasIzquierda, 530, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasIzquierda, 530, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasIzquierda, 530, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasIzquierda, 530, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasIzquierda, 530, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasIzquierda, 530, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasIzquierda, 530, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasIzquierda, 530, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasIzquierda, 530, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasIzquierda, 530, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasIzquierda, 530, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasIzquierda, 530, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasIzquierda, 530, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasIzquierda, 530, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasIzquierda, 530, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasIzquierda, 530, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasIzquierda, 530, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasIzquierda, 530, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasIzquierda, 530, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasIzquierda, 530, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasIzquierda, 530, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasIzquierda, 530, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasIzquierda, 530, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasIzquierda, 530, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasIzquierda, 530, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasIzquierda, 530, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasIzquierda, 530, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasIzquierda, 530, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasIzquierda, 530, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasIzquierda, 530, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasIzquierda, 530, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasIzquierda, 530, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasIzquierda, 530, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasIzquierda, 530, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasIzquierda, 530, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasIzquierda, 530, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasIzquierda, 530, this);
			break;
		default:
			g.drawImage(reverso, posXCartasIzquierda, 530,this);
		}
		
		switch(imagenAmostrarJug2Pos01)
		{
		case 1:
			g.drawImage(A1, posXCartasCentro, 530, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasCentro, 530, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasCentro, 530, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasCentro, 530, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasCentro, 530, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasCentro, 530, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasCentro, 530, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasCentro, 530, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasCentro, 530, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasCentro, 530, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasCentro, 530, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasCentro, 530, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasCentro, 530, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasCentro, 530, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasCentro, 530, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasCentro, 530, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasCentro, 530, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasCentro, 530, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasCentro, 530, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasCentro, 530, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasCentro, 530, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasCentro, 530, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasCentro, 530, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasCentro, 530, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasCentro, 530, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasCentro, 530, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasCentro, 530, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasCentro, 530, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasCentro, 530, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasCentro, 530, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasCentro, 530, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasCentro, 530, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasCentro, 530, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasCentro, 530, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasCentro, 530, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasCentro, 530, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasCentro, 530, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasCentro, 530, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasCentro, 530, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasCentro, 530, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasCentro, 530, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasCentro, 530, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasCentro, 530, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasCentro, 530, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasCentro, 530, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasCentro, 530, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasCentro, 530, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasCentro, 530, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasCentro, 530, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasCentro, 530, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasCentro, 530, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasCentro, 530, this);
			break;
		default:
			g.drawImage(reverso, posXCartasCentro, 530, this);
		}
		
		switch(imagenAmostrarJug2Pos02)
		{
		case 1:
			g.drawImage(A1, posXCartasDerecha, 530, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasDerecha, 530, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasDerecha, 530, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasDerecha, 530, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasDerecha, 530, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasDerecha, 530, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasDerecha, 530, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasDerecha, 530, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasDerecha, 530, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasDerecha, 530, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasDerecha, 530, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasDerecha, 530, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasDerecha, 530, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasDerecha, 530, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasDerecha, 530, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasDerecha, 530, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasDerecha, 530, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasDerecha, 530, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasDerecha, 530, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasDerecha, 530, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasDerecha, 530, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasDerecha, 530, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasDerecha, 530, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasDerecha, 530, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasDerecha, 530, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasDerecha, 530, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasDerecha, 530, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasDerecha, 530, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasDerecha, 530, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasDerecha, 530, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasDerecha, 530, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasDerecha, 530, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasDerecha, 530, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasDerecha, 530, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasDerecha, 530, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasDerecha, 530, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasDerecha, 530, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasDerecha, 530, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasDerecha, 530, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasDerecha, 530, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasDerecha, 530, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasDerecha, 530, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasDerecha, 530, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasDerecha, 530, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasDerecha, 530, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasDerecha, 530, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasDerecha, 530, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasDerecha, 530, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasDerecha, 530, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasDerecha, 530, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasDerecha, 530, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasDerecha, 530, this);
			break;
		default:
			g.drawImage(reverso, posXCartasDerecha, 530, this);
		}
		
		switch(imagenAmostrarJug2Pos10)
		{
		case 1:
			g.drawImage(A1, posXCartasIzquierda, 653, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasIzquierda, 653, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasIzquierda, 653, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasIzquierda, 653, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasIzquierda, 653, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasIzquierda, 653, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasIzquierda, 653, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasIzquierda, 653, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasIzquierda, 653, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasIzquierda, 653, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasIzquierda, 653, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasIzquierda, 653, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasIzquierda, 653, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasIzquierda, 653, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasIzquierda, 653, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasIzquierda, 653, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasIzquierda, 653, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasIzquierda, 653, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasIzquierda, 653, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasIzquierda, 653, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasIzquierda, 653, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasIzquierda, 653, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasIzquierda, 653, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasIzquierda, 653, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasIzquierda, 653, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasIzquierda, 653, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasIzquierda, 653, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasIzquierda, 653, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasIzquierda, 653, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasIzquierda, 653, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasIzquierda, 653, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasIzquierda, 653, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasIzquierda, 653, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasIzquierda, 653, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasIzquierda, 653, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasIzquierda, 653, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasIzquierda, 653, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasIzquierda, 653, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasIzquierda, 653, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasIzquierda, 653, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasIzquierda, 653, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasIzquierda, 653, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasIzquierda, 653, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasIzquierda, 653, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasIzquierda, 653, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasIzquierda, 653, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasIzquierda, 653, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasIzquierda, 653, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasIzquierda, 653, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasIzquierda, 653, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasIzquierda, 653, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasIzquierda, 653, this);
			break;
		default:
			g.drawImage(reverso, posXCartasIzquierda, 653,this);
		}
		
		switch(imagenAmostrarJug2Pos11)
		{
		case 1:
			g.drawImage(A1, posXCartasCentro, 653, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasCentro, 653, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasCentro, 653, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasCentro, 653, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasCentro, 653, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasCentro, 653, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasCentro, 653, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasCentro, 653, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasCentro, 653, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasCentro, 653, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasCentro, 653, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasCentro, 653, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasCentro, 653, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasCentro, 653, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasCentro, 653, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasCentro, 653, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasCentro, 653, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasCentro, 653, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasCentro, 653, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasCentro, 653, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasCentro, 653, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasCentro, 653, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasCentro, 653, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasCentro, 653, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasCentro, 653, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasCentro, 653, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasCentro, 653, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasCentro, 653, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasCentro, 653, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasCentro, 653, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasCentro, 653, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasCentro, 653, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasCentro, 653, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasCentro, 653, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasCentro, 653, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasCentro, 653, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasCentro, 653, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasCentro, 653, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasCentro, 653, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasCentro, 653, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasCentro, 653, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasCentro, 653, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasCentro, 653, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasCentro, 653, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasCentro, 653, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasCentro, 653, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasCentro, 653, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasCentro, 653, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasCentro, 653, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasCentro, 653, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasCentro, 653, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasCentro, 653, this);
			break;
		default:
			g.drawImage(reverso, posXCartasCentro, 653, this);
		}
		
		switch(imagenAmostrarJug2Pos12)
		{
		case 1:
			g.drawImage(A1, posXCartasDerecha, 653, this);
			break;
		case 2:
			g.drawImage(A2, posXCartasDerecha, 653, this);
			break;
		case 3:
			g.drawImage(A3, posXCartasDerecha, 653, this);
			break;
		case 4:
			g.drawImage(A4, posXCartasDerecha, 653, this);
			break;
		case 5:
			g.drawImage(A5, posXCartasDerecha, 653, this);
			break;
		case 6:
			g.drawImage(A6, posXCartasDerecha, 653, this);
			break;
		case 7:
			g.drawImage(A7, posXCartasDerecha, 653, this);
			break;
		case 8:
			g.drawImage(A8, posXCartasDerecha, 653, this);
			break;
		case 9:
			g.drawImage(A9, posXCartasDerecha, 653, this);
			break;
		case 10:
			g.drawImage(A10, posXCartasDerecha, 653, this);
			break;
		case 11:
			g.drawImage(A11, posXCartasDerecha, 653, this);
			break;
		case 12:
			g.drawImage(A12, posXCartasDerecha, 653, this);
			break;
		case 13:
			g.drawImage(A13, posXCartasDerecha, 653, this);
			break;
		case 14:
			g.drawImage(B1, posXCartasDerecha, 653, this);
			break;
		case 15:
			g.drawImage(B2, posXCartasDerecha, 653, this);
			break;
		case 16:
			g.drawImage(B3, posXCartasDerecha, 653, this);
			break;
		case 17:
			g.drawImage(B4, posXCartasDerecha, 653, this);
			break;
		case 18:
			g.drawImage(B5, posXCartasDerecha, 653, this);
			break;
		case 19:
			g.drawImage(B6, posXCartasDerecha, 653, this);
			break;
		case 20:
			g.drawImage(B7, posXCartasDerecha, 653, this);
			break;
		case 21:
			g.drawImage(B8, posXCartasDerecha, 653, this);
			break;
		case 22:
			g.drawImage(B9, posXCartasDerecha, 653, this);
			break;
		case 23:
			g.drawImage(B10, posXCartasDerecha, 653, this);
			break;
		case 24:
			g.drawImage(B11, posXCartasDerecha, 653, this);
			break;
		case 25:
			g.drawImage(B12, posXCartasDerecha, 653, this);
			break;
		case 26:
			g.drawImage(B13, posXCartasDerecha, 653, this);
			break;
		case 27:
			g.drawImage(C1, posXCartasDerecha, 653, this);
			break;
		case 28:
			g.drawImage(C2, posXCartasDerecha, 653, this);
			break;
		case 29:
			g.drawImage(C3, posXCartasDerecha, 653, this);
			break;
		case 30:
			g.drawImage(C4, posXCartasDerecha, 653, this);
			break;
		case 31:
			g.drawImage(C5, posXCartasDerecha, 653, this);
			break;
		case 32:
			g.drawImage(C6, posXCartasDerecha, 653, this);
			break;
		case 33:
			g.drawImage(C7, posXCartasDerecha, 653, this);
			break;
		case 34:
			g.drawImage(C8, posXCartasDerecha, 653, this);
			break;
		case 35:
			g.drawImage(C9, posXCartasDerecha, 653, this);
			break;
		case 36:
			g.drawImage(C10, posXCartasDerecha, 653, this);
			break;
		case 37:
			g.drawImage(C11, posXCartasDerecha, 653, this);
			break;
		case 38:
			g.drawImage(C12, posXCartasDerecha, 653, this);
			break;
		case 39:
			g.drawImage(C13, posXCartasDerecha, 653, this);
			break;
		case 40:
			g.drawImage(D1, posXCartasDerecha, 653, this);
			break;
		case 41:
			g.drawImage(D2, posXCartasDerecha, 653, this);
			break;
		case 42:
			g.drawImage(D3, posXCartasDerecha, 653, this);
			break;
		case 43:
			g.drawImage(D4, posXCartasDerecha, 653, this);
			break;
		case 44:
			g.drawImage(D5, posXCartasDerecha, 653, this);
			break;
		case 45:
			g.drawImage(D6, posXCartasDerecha, 653, this);
			break;
		case 46:
			g.drawImage(D7, posXCartasDerecha, 653, this);
			break;
		case 47:
			g.drawImage(D8, posXCartasDerecha, 653, this);
			break;
		case 48:
			g.drawImage(D9, posXCartasDerecha, 653, this);
			break;
		case 49:
			g.drawImage(D10, posXCartasDerecha, 653, this);
			break;
		case 50:
			g.drawImage(D11, posXCartasDerecha, 653, this);
			break;
		case 51:
			g.drawImage(D12, posXCartasDerecha, 653, this);
			break;
		case 52:
			g.drawImage(D13, posXCartasDerecha, 653, this);
			break;
		default:
			g.drawImage(reverso, posXCartasDerecha, 653, this);
		}
		
	}
	
	public void cargarCartas()
	{
		A1 = herramientas.getImage("img/A1.png");
		A2 = herramientas.getImage("img/A2.png");
		A3 = herramientas.getImage("img/A3.png");
		A4 = herramientas.getImage("img/A4.png");
		A5 = herramientas.getImage("img/A5.png");
		A6 = herramientas.getImage("img/A6.png");
		A7 = herramientas.getImage("img/A7.png");
		A8 = herramientas.getImage("img/A8.png");
		A9 = herramientas.getImage("img/A9.png");
		A10 = herramientas.getImage("img/A10.png");
		A11 = herramientas.getImage("img/A11.png");
		A12 = herramientas.getImage("img/A12.png");
		A13 = herramientas.getImage("img/A13.png");
		B1 = herramientas.getImage("img/B1.png");
		B2 = herramientas.getImage("img/B2.png");
		B3 = herramientas.getImage("img/B3.png");
		B4 = herramientas.getImage("img/B4.png");
		B5 = herramientas.getImage("img/B5.png");
		B6 = herramientas.getImage("img/B6.png");
		B7 = herramientas.getImage("img/B7.png");
		B8 = herramientas.getImage("img/B8.png");
		B9 = herramientas.getImage("img/B9.png");
		B10 = herramientas.getImage("img/B10.png");
		B11 = herramientas.getImage("img/B11.png");
		B12 = herramientas.getImage("img/B12.png");
		B13 = herramientas.getImage("img/B13.png");
		C1 = herramientas.getImage("img/C1.png");
		C2 = herramientas.getImage("img/C2.png");
		C3 = herramientas.getImage("img/C3.png");
		C4 = herramientas.getImage("img/C4.png");
		C5 = herramientas.getImage("img/C5.png");
		C6 = herramientas.getImage("img/C6.png");
		C7 = herramientas.getImage("img/C7.png");
		C8 = herramientas.getImage("img/C8.png");
		C9 = herramientas.getImage("img/C9.png");
		C10 = herramientas.getImage("img/C10.png");
		C11 = herramientas.getImage("img/C11.png");
		C12 = herramientas.getImage("img/C12.png");
		C13 = herramientas.getImage("img/C13.png");
		D1 = herramientas.getImage("img/D1.png");
		D2 = herramientas.getImage("img/D2.png");
		D3 = herramientas.getImage("img/D3.png");
		D4 = herramientas.getImage("img/D4.png");
		D5 = herramientas.getImage("img/D5.png");
		D6 = herramientas.getImage("img/D6.png");
		D7 = herramientas.getImage("img/D7.png");
		D8 = herramientas.getImage("img/D8.png");
		D9 = herramientas.getImage("img/D9.png");
		D10 = herramientas.getImage("img/D10.png");
		D11 = herramientas.getImage("img/D11.png");
		D12 = herramientas.getImage("img/D12.png");
		D13 = herramientas.getImage("img/D13.png");
	}
	
	//===================================
	//==Métodos para mostrar las cartas==
	//===================================
	
	//Mostar carta temporal y descarte
		public void mostrarCartaTemporal(int carta)
		{
			imagenAmostrarTemporal = carta;
			repaint();
		}
		public void mostrarCartaDescarte(int carta)
		{
			imagenAmostrarDescarte = carta;
			repaint();
		}
	
	//Cartas Jugador 1
	public void mostrarCartaJug1Pos00(int carta)
	{
		imagenAmostrarJug1Pos00 = carta;
		repaint();
	}
	public void mostrarCartaJug1Pos01(int carta)
	{
		imagenAmostrarJug1Pos01 = carta;
		repaint();
	}
	public void mostrarCartaJug1Pos02(int carta)
	{
		imagenAmostrarJug1Pos02 = carta;
		repaint();
	}
	public void mostrarCartaJug1Pos10(int carta)
	{
		imagenAmostrarJug1Pos10 = carta;
		repaint();
	}
	public void mostrarCartaJug1Pos11(int carta)
	{
		imagenAmostrarJug1Pos11 = carta;
		repaint();
	}
	public void mostrarCartaJug1Pos12(int carta)
	{
		imagenAmostrarJug1Pos12 = carta;
		repaint();
	}
	//Cartas Jugador 2
	public void mostrarCartaJug2Pos00(int carta)
	{
		imagenAmostrarJug2Pos00 = carta;
		repaint();
	}
	public void mostrarCartaJug2Pos01(int carta)
	{
		imagenAmostrarJug2Pos01 = carta;
		repaint();
	}
	public void mostrarCartaJug2Pos02(int carta)
	{
		imagenAmostrarJug2Pos02 = carta;
		repaint();
	}
	public void mostrarCartaJug2Pos10(int carta)
	{
		imagenAmostrarJug2Pos10 = carta;
		repaint();
	}
	public void mostrarCartaJug2Pos11(int carta)
	{
		imagenAmostrarJug2Pos11 = carta;
		repaint();
	}
	public void mostrarCartaJug2Pos12(int carta)
	{
		imagenAmostrarJug2Pos12 = carta;
		repaint();
	}
	
	
	//==Método para modificar los puntos==
	public void setPuntosJugador1(int puntos)
	{
		puntosJugador1 = puntos;
		repaint();
	}
	public void setPuntosJugador2(int puntos)
	{
		puntosJugador2 = puntos;
		repaint();
	}
	public void resetearContadores()
	{
		puntosJugador1 = 0;
		puntosJugador2 = 0;
		repaint();
	}
}

