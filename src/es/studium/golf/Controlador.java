package es.studium.golf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.ArrayList;

public class Controlador implements WindowListener, ActionListener, MouseListener

{
	VistaInicio vistaInicio;
	VistaJuego vistaJuego;
	Modelo modelo;

	Connection conexion = null;

	ArrayList<Integer> mazo = new ArrayList<Integer>(); // Mazo de cartas
	ArrayList<Integer> cartasJ1 = new ArrayList<Integer>(); // Cartas del Jugador 1
	ArrayList<Integer> cartasJ2 = new ArrayList<Integer>(); // Cartas del Jugador2
	boolean estanCartasJ1BocaArriba[] =
	{ false, false, false, false, false, false };
	boolean estanCartasJ2BocaArriba[] =
	{ false, false, false, false, false, false };

	int numeroJugadores = 0;
	int turno = 1;
	boolean isCartaTemporalActive = false;
	int cartaTemporal;
	int descarte;
	int cartasBocaArribaJ1;
	int cartasBocaArribaJ2;

	public Controlador(VistaInicio vi, VistaJuego vj, Modelo m)
	{
		this.vistaInicio = vi;
		this.vistaJuego = vj;
		this.modelo = m;

		// Listeners VistaInicio
		this.vistaInicio.ventana.addWindowListener(this);
		this.vistaInicio.btnPuntajes.addActionListener(this);
		this.vistaInicio.btnNuevaPartida.addActionListener(this);

		this.vistaInicio.ventanaRanking.addWindowListener(this);
		this.vistaInicio.btnVolverPuntajes.addActionListener(this);

		this.vistaInicio.ventanaElegirNumeroJugadores.addWindowListener(this);
		this.vistaInicio.btnContinuar.addActionListener(this);

		this.vistaInicio.ventanaInfoJugadores.addWindowListener(this);
		this.vistaInicio.btnComenzarPartida.addActionListener(this);

		// Listeners VistaJuego
		this.vistaJuego.addMouseListener(this);
		this.vistaJuego.addWindowListener(this);

		// Barajamos el mazo
		this.modelo.barajar(mazo);
		// Repartimos 6 cartas a cada jugador
		this.modelo.repartir(mazo, cartasJ1, cartasJ2);
		// Agregamos carta al mazo de descarte y la mostramos
		descarte = this.modelo.agregarDescarte(mazo, descarte);
		this.vistaJuego.mostrarCartaDescarte(descarte);
	}

	// =============================
	// ===Action Listener Methods===
	// =============================
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if (vistaInicio.btnPuntajes.equals(evento.getSource()))
		{
			// Llamamos al método que muestra los puntajes
			this.vistaInicio.MostrarRanking();

			// Conectar BD
			conexion = this.modelo.conectar();
			// Realizar consulta, y sacar información
			String informacion = "";
			informacion = this.modelo.consulta(conexion);
			// Rellenaremos TextArea
			this.vistaInicio.txaConsulta.append(informacion);
			// Cerrar la conexión
			this.modelo.cerrar(conexion);
		} else if (vistaInicio.btnVolverPuntajes.equals(evento.getSource()))
		{
			this.vistaInicio.txaConsulta.selectAll();
			this.vistaInicio.txaConsulta.setText("");
			this.vistaInicio.ventanaRanking.setVisible(false);
		} else if (vistaInicio.btnNuevaPartida.equals(evento.getSource()))
		{
			this.vistaInicio.ventanaElegirNumeroJugadores.removeAll();
			this.vistaInicio.VentanaElegirNumeroJugadores();
		} else if (vistaInicio.btnContinuar.equals(evento.getSource()))
		{
			if (this.vistaInicio.choJugadores.getSelectedItem().equals("Dos Jugadores"))
			{
				numeroJugadores = 2;
				this.vistaInicio.VentanaInfoDosJugadores();
			} else if (this.vistaInicio.choJugadores.getSelectedItem().equals("Tres Jugadores"))
			{
				numeroJugadores = 3;
				this.vistaInicio.VentanaInfoTresJugadores();
			} else if (this.vistaInicio.choJugadores.getSelectedItem().equals("Cuatro Jugadores"))
			{
				numeroJugadores = 4;
				this.vistaInicio.VentanaInfoCuatroJugadores();
			}
		} else if (vistaInicio.btnComenzarPartida.equals(evento.getSource()))
		{
			this.vistaInicio.ventana.setVisible(false);
			this.vistaInicio.ventanaElegirNumeroJugadores.setVisible(false);
			this.vistaInicio.ventanaInfoJugadores.setVisible(false);
			this.vistaJuego.setVisible(true);
			if (numeroJugadores == 2)
			{
				this.vistaJuego.nombreJug1 = this.vistaInicio.txtJugador1.getText();
				this.vistaJuego.nombreJug2 = this.vistaInicio.txtJugador2.getText();
			}
		}
	}

	// ============================
	// === MouseListener Methods===
	// ============================
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();

		// Dar Vuelta las primeras dos cartas si es el turno del jugador y hay menos de
		// 2 cartas dadas vueltas
		// Dar vuelta cartas jugador 1
		if ((x >= 440) && (x <= 521) && (y >= 50) && (y <= 161) && turno == 1 && cartasBocaArribaJ1 < 2)
		{
			this.vistaJuego.mostrarCartaJug1Pos00(cartasJ1.get(0));
			estanCartasJ1BocaArriba[0] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ1 == 2)
			{
				turno = 2;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 50) && (y <= 161) && turno == 1 && cartasBocaArribaJ1 < 2)
		{
			this.vistaJuego.mostrarCartaJug1Pos01(cartasJ1.get(1));
			estanCartasJ1BocaArriba[1] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ1 == 2)
			{
				turno = 2;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 50) && (y <= 161) && turno == 1 && cartasBocaArribaJ1 < 2)
		{
			this.vistaJuego.mostrarCartaJug1Pos02(cartasJ1.get(2));
			estanCartasJ1BocaArriba[2] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ1 == 2)
			{
				turno = 2;
			}
		} else if ((x >= 440) && (x <= 521) && (y >= 173) && (y <= 284) && turno == 1 && cartasBocaArribaJ1 < 2)
		{
			this.vistaJuego.mostrarCartaJug1Pos10(cartasJ1.get(3));
			estanCartasJ1BocaArriba[3] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ1 == 2)
			{
				turno = 2;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 173) && (y <= 284) && turno == 1 && cartasBocaArribaJ1 < 2)
		{
			this.vistaJuego.mostrarCartaJug1Pos11(cartasJ1.get(4));
			estanCartasJ1BocaArriba[4] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ1 == 2)
			{
				turno = 2;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 173) && (y <= 284) && turno == 1 && cartasBocaArribaJ1 < 2)
		{
			this.vistaJuego.mostrarCartaJug1Pos12(cartasJ1.get(5));
			estanCartasJ1BocaArriba[5] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ1 == 2)
			{
				turno = 2;
			}
		}

		// Dar vuelta cartas jugador 2
		else if ((x >= 440) && (x <= 521) && (y >= 530) && (y <= 641) && turno == 2 && cartasBocaArribaJ2 < 2)
		{
			this.vistaJuego.mostrarCartaJug2Pos00(cartasJ2.get(0));
			estanCartasJ2BocaArriba[0] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ2 == 2)
			{
				turno = 1;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 530) && (y <= 641) && turno == 2 && cartasBocaArribaJ2 < 2)
		{
			this.vistaJuego.mostrarCartaJug2Pos01(cartasJ2.get(1));
			estanCartasJ2BocaArriba[1] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ2 == 2)
			{
				turno = 1;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 530) && (y <= 641) && turno == 2 && cartasBocaArribaJ2 < 2)
		{
			this.vistaJuego.mostrarCartaJug2Pos02(cartasJ2.get(2));
			estanCartasJ2BocaArriba[2] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ2 == 2)
			{
				turno = 1;
			}
		} else if ((x >= 440) && (x <= 521) && (y >= 653) && (y <= 764) && turno == 2 && cartasBocaArribaJ2 < 2)
		{
			this.vistaJuego.mostrarCartaJug2Pos10(cartasJ2.get(3));
			estanCartasJ2BocaArriba[3] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ2 == 2)
			{
				turno = 1;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 653) && (y <= 764) && turno == 2 && cartasBocaArribaJ2 < 2)
		{
			this.vistaJuego.mostrarCartaJug2Pos11(cartasJ2.get(4));
			estanCartasJ2BocaArriba[4] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ2 == 2)
			{
				turno = 1;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 653) && (y <= 764) && turno == 2 && cartasBocaArribaJ2 < 2)
		{
			this.vistaJuego.mostrarCartaJug2Pos12(cartasJ2.get(5));
			estanCartasJ2BocaArriba[5] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ2 == 2)
			{
				turno = 1;
			}
		}

		// Click en el mazo
		else if ((x >= 590) && (x <= 671) && (y >= 350) && (y <= 461) && isCartaTemporalActive == false)
		{
			if (mazo.size() > 1)
			{
				// Guardamos en la variable cartaTemporal
				cartaTemporal = mazo.get(mazo.size() - 1);
				// Mostrar la carta temporal
				this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
				// Eliminamos la carta del mazo
				mazo.remove(mazo.size() - 1);

				isCartaTemporalActive = true;
			} else if (mazo.size() == 1) // Ultima carta del mazo:
			{
				// BARAJAR DE NUEVO Y QUITAR LAS CARTAS DEl J1, J2 y DESCARTE --> HACER METODO,
				// pasando las cosas a quitar como parametro
			}
		}

		// Intercambio entre Cartas Jugador 1 y Mazo Descarte:
		else if ((x >= 440) && (x <= 521) && (y >= 50) && (y <= 161) && turno == 1 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ1.get(0);
			cartasJ1.set(0, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug1Pos00(cartasJ1.get(0));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ1BocaArriba[0] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 50) && (y <= 161) && turno == 1 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ1.get(1);
			cartasJ1.set(1, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug1Pos01(cartasJ1.get(1));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ1BocaArriba[1] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 50) && (y <= 161) && turno == 1 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ1.get(2);
			cartasJ1.set(2, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug1Pos02(cartasJ1.get(2));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ1BocaArriba[2] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 440) && (x <= 521) && (y >= 173) && (y <= 284) && turno == 1 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ1.get(3);
			cartasJ1.set(3, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug1Pos10(cartasJ1.get(3));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ1BocaArriba[3] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 173) && (y <= 284) && turno == 1 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ1.get(4);
			cartasJ1.set(4, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug1Pos11(cartasJ1.get(4));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ1BocaArriba[4] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 173) && (y <= 284) && turno == 1 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ1.get(5);
			cartasJ1.set(5, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug1Pos12(cartasJ1.get(5));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ1BocaArriba[5] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		}

		// Intercambio entre Cartas Jugador 2 y Mazo Descarte
		else if ((x >= 440) && (x <= 521) && (y >= 530) && (y <= 641) && turno == 2 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ2.get(0);
			cartasJ2.set(0, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug2Pos00(cartasJ2.get(0));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ2BocaArriba[0] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 530) && (y <= 641) && turno == 2 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ2.get(1);
			cartasJ2.set(1, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug2Pos01(cartasJ2.get(1));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ2BocaArriba[1] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 530) && (y <= 641) && turno == 2 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ2.get(2);
			cartasJ2.set(2, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug2Pos02(cartasJ2.get(2));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ2BocaArriba[2] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 440) && (x <= 521) && (y >= 653) && (y <= 764) && turno == 2 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ2.get(3);
			cartasJ2.set(3, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug2Pos10(cartasJ2.get(3));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ2BocaArriba[3] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 653) && (y <= 764) && turno == 2 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ2.get(4);
			cartasJ2.set(4, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug2Pos11(cartasJ2.get(4));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ2BocaArriba[4] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 653) && (y <= 764) && turno == 2 && isCartaTemporalActive == false)
		{
			int auxiliar = cartasJ2.get(5);
			cartasJ2.set(5, descarte);
			descarte = auxiliar;
			this.vistaJuego.mostrarCartaJug2Pos12(cartasJ2.get(5));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			estanCartasJ2BocaArriba[5] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		}

		// Intercambio entre Carta Temporal y Carta seleccionada J1
		else if ((x >= 440) && (x <= 521) && (y >= 50) && (y <= 161) && turno == 1 && isCartaTemporalActive == true)
		{
			descarte = cartasJ1.get(0);
			cartasJ1.set(0, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug1Pos00(cartasJ1.get(0));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ1BocaArriba[0] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 50) && (y <= 161) && turno == 1 && isCartaTemporalActive == true)
		{
			descarte = cartasJ1.get(1);
			cartasJ1.set(1, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug1Pos01(cartasJ1.get(1));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ1BocaArriba[1] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 50) && (y <= 161) && turno == 1 && isCartaTemporalActive == true)
		{
			descarte = cartasJ1.get(2);
			cartasJ1.set(2, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug1Pos02(cartasJ1.get(2));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ1BocaArriba[2] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 440) && (x <= 521) && (y >= 173) && (y <= 284) && turno == 1 && isCartaTemporalActive == true)
		{
			descarte = cartasJ1.get(3);
			cartasJ1.set(3, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug1Pos10(cartasJ1.get(3));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ1BocaArriba[3] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 173) && (y <= 284) && turno == 1 && isCartaTemporalActive == true)
		{
			descarte = cartasJ1.get(4);
			cartasJ1.set(4, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug1Pos11(cartasJ1.get(4));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ1BocaArriba[4] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 173) && (y <= 284) && turno == 1 && isCartaTemporalActive == true)
		{
			descarte = cartasJ1.get(5);
			cartasJ1.set(5, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug1Pos12(cartasJ1.get(5));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ1BocaArriba[5] = true;
			cartasBocaArribaJ1 = this.modelo.actualizarCartasBocaArriba(estanCartasJ1BocaArriba);
			if (cartasBocaArribaJ2 < 6)
			{
				turno = 2;
			}
		}

		// Intercambio entre Carta Temporal y Carta seleccionada J2
		else if ((x >= 440) && (x <= 521) && (y >= 530) && (y <= 641) && turno == 2 && isCartaTemporalActive == true)
		{
			descarte = cartasJ2.get(0);
			cartasJ2.set(0, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug2Pos00(cartasJ2.get(0));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ2BocaArriba[0] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 530) && (y <= 641) && turno == 2 && isCartaTemporalActive == true)
		{
			descarte = cartasJ2.get(1);
			cartasJ2.set(1, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug2Pos01(cartasJ2.get(1));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ2BocaArriba[1] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 530) && (y <= 641) && turno == 2 && isCartaTemporalActive == true)
		{
			descarte = cartasJ2.get(2);
			cartasJ2.set(2, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug2Pos02(cartasJ2.get(2));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ2BocaArriba[2] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 440) && (x <= 521) && (y >= 653) && (y <= 764) && turno == 2 && isCartaTemporalActive == true)
		{
			descarte = cartasJ2.get(3);
			cartasJ2.set(3, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug2Pos10(cartasJ2.get(3));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ2BocaArriba[3] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 531) && (x <= 612) && (y >= 653) && (y <= 764) && turno == 2 && isCartaTemporalActive == true)
		{
			descarte = cartasJ2.get(4);
			cartasJ2.set(4, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug2Pos11(cartasJ2.get(4));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ2BocaArriba[4] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		} else if ((x >= 622) && (x <= 703) && (y >= 653) && (y <= 764) && turno == 2 && isCartaTemporalActive == true)
		{
			descarte = cartasJ2.get(5);
			cartasJ2.set(5, cartaTemporal);
			cartaTemporal = 0;
			this.vistaJuego.mostrarCartaJug2Pos12(cartasJ2.get(5));
			this.vistaJuego.mostrarCartaDescarte(descarte);
			this.vistaJuego.mostrarCartaTemporal(cartaTemporal);
			isCartaTemporalActive = false;
			estanCartasJ2BocaArriba[5] = true;
			cartasBocaArribaJ2 = this.modelo.actualizarCartasBocaArriba(estanCartasJ2BocaArriba);
			if (cartasBocaArribaJ1 < 6)
			{
				turno = 1;
			}
		}
		
		//Descartar Carta Temporal
		
		
		//Si todas las cartas estan boca arriba, calculamos el puntaje de la partida y mostramos un dialogo:
		if(cartasBocaArribaJ1 == 6 & cartasBocaArribaJ2 == 6)
		{
			int puntosJ1 = this.modelo.totalJugador(cartasJ1);
			int puntosJ2 = this.modelo.totalJugador(cartasJ2);
			this.vistaJuego.lblPuntosJ1.setText("Puntos de " + this.vistaJuego.nombreJug1+ ": " + puntosJ1);
			this.vistaJuego.lblPuntosJ2.setText("Puntos de " + this.vistaJuego.nombreJug2+ ": " + puntosJ2);
			if(puntosJ1 < puntosJ2) {
				this.vistaJuego.lblMensaje.setText("Ha ganado " + this.vistaJuego.nombreJug1);
			}
			else if(puntosJ1 > puntosJ2) {
				this.vistaJuego.lblMensaje.setText("Ha ganado " + this.vistaJuego.nombreJug2);
			}else {
				this.vistaJuego.lblMensaje.setText("Ha sido un empate");
			}
			this.vistaJuego.dlgMensaje.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
	}

	// =============================
	// == Window Listener Methods ==
	// =============================
	@Override
	public void windowActivated(WindowEvent arg0)
	{
	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if (this.vistaInicio.ventanaRanking.isVisible())
		{
			this.vistaInicio.txaConsulta.selectAll();
			this.vistaInicio.txaConsulta.setText("");
			this.vistaInicio.ventanaRanking.setVisible(false);
		} else if (this.vistaInicio.ventanaElegirNumeroJugadores.isVisible())
		{
			this.vistaInicio.ventanaElegirNumeroJugadores.setVisible(false);
		} else if (this.vistaInicio.ventanaInfoJugadores.isVisible())
		{
			this.vistaInicio.ventanaInfoJugadores.setVisible(false);
			this.vistaInicio.ventanaInfoJugadores.removeAll();
		} else
		{
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
	}

}