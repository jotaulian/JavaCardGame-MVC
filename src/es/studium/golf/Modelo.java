package es.studium.golf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Modelo
{
	Random rnd = new Random();
	
	//Introducimos 52 cartas en el mazo
	public void barajar(ArrayList<Integer> mazo)
	{		
		for(int i = 0; i < 52; i++)
		{
			mazo.add(i+1);
		}
		rebarajar(mazo);
		rebarajar(mazo);
		rebarajar(mazo);
	}
	
	//Intercambiamos los elementos de forma aleatoria
	public void rebarajar(ArrayList<Integer> t)
	{
		int aleatorio, auxiliar;
		for(int i=0; i<52; i++)
		{
			aleatorio = rnd.nextInt(51)+1;
			auxiliar = t.get(i);
			t.set(i, t.get(aleatorio));
			t.set(aleatorio, auxiliar);
		}
	}
	
	//Repartimos 6 cartas a cada jugador y eliminamos dichas cartas del mazo
	public void repartir(ArrayList<Integer> mazo, ArrayList<Integer> cartasJ1, ArrayList<Integer> cartasJ2) {
		for(int i=0; i<6; i++)
		{
			cartasJ1.add(mazo.get(i));
			mazo.remove(i);
		}
		for(int i=6; i<12; i++)
		{
			cartasJ2.add(mazo.get(i));
			mazo.remove(i);
		}
	}
	
	public int agregarDescarte(ArrayList<Integer> mazo,int descarte) {
		//Agregamos carta al mazo de descarte y la eliminamos del mazo
		descarte = mazo.get(mazo.size()-1);
		mazo.remove(mazo.get(mazo.size()-1));
		return descarte;
	}
	
	public int actualizarCartasBocaArriba(boolean[] estadoCartas) {
		int cartasBocaArriba = 0;
		for (Boolean carta : estadoCartas) 
		{
			if(carta==true) {
				cartasBocaArriba++;
			}
		}
		return cartasBocaArriba;
	}
	
	/* Calculo de puntos:
	 * Toma un ArrayList con las cartas de un jugadaor como parametro y suma:
	 * A(pos[0]+pos[3]) + B(pos[1]+pos[4]) + C(pos[2]+pos[5])
	 * Pero antes de sumar comprueba si los numeros son iguales. En caso de serlo,  ese bloque será igual a 0.
	 * De lo contrario suma los valores
	 * [0], [1], [2]
	 * [3], [4], [5] 
	 * */
	public int totalJugador(ArrayList<Integer> cartasJugador) {
		int a, b, c;
		// A
		if(cartasJugador.get(0) == cartasJugador.get(3)) {
			a = 0;
		}else {
			a = (valor(cartasJugador.get(0)) + valor(cartasJugador.get(3)));
		}
		//B
		if(cartasJugador.get(1) == cartasJugador.get(4)) {
			b = 0;
		}else {
			b = (valor(cartasJugador.get(1)) + valor(cartasJugador.get(4)));
		}
		//C
		if(cartasJugador.get(2) == cartasJugador.get(5)) {
			c = 0;
		}else {
			c = (valor(cartasJugador.get(2)) + valor(cartasJugador.get(5)));
		}
		int total = (a + b + c);
		return total;
	}
	
	//Valor de cada carta
	public int valor(int numero) {
		int valor = 0;
		switch(numero)
		{
		case 1:
			valor = 1;
			break;
		case 2:
			valor = -2;
			break;
		case 3:
			valor = 3;
			break;
		case 4:
			valor = 4;
			break;
		case 5:
			valor = 5;
			break;
		case 6:
			valor = 6;
			break;
		case 7:
			valor = 7;
			break;
		case 8:
			valor = 8;
			break;
		case 9:
			valor = 9;
			break;
		case 10:
			valor = 10;
			break;
		case 11:
			valor = 10;
			break;
		case 12:
			valor = 10;
			break;
		case 13:
			valor = 0;
			break;
		case 14:
			valor = 1;
			break;
		case 15:
			valor = -2;
			break;
		case 16:
			valor = 3;
			break;
		case 17:
			valor = 4;
			break;
		case 18:
			valor = 5;
			break;
		case 19:
			valor = 6;
			break;
		case 20:
			valor = 7;
			break;
		case 21:
			valor = 8;
			break;
		case 22:
			valor = 9;
			break;
		case 23:
			valor = 10;
			break;
		case 24:
			valor = 10;
			break;
		case 25:
			valor = 10;
			break;
		case 26:
			valor = 0;
			break;
		case 27:
			valor = 1;
			break;
		case 28:
			valor = -2;
			break;
		case 29:
			valor = 3;
			break;
		case 30:
			valor = 4;
			break;
		case 31:
			valor = 5;
			break;
		case 32:
			valor = 6;
			break;
		case 33:
			valor = 7;
			break;
		case 34:
			valor = 8;
			break;
		case 35:
			valor = 9;
			break;
		case 36:
			valor = 10;
			break;
		case 37:
			valor = 10;
			break;
		case 38:
			valor = 10;
			break;
		case 39:
			valor = 0;
			break;
		case 40:
			valor = 1;
			break;
		case 41:
			valor = -2;
			break;
		case 42:
			valor = 3;
			break;
		case 43:
			valor = 4;
			break;
		case 44:
			valor = 5;
			break;
		case 45:
			valor = 6;
			break;
		case 46:	
			valor = 7;
			break;
		case 47:
			valor = 8;
			break;
		case 48:
			valor = 9;
			break;
		case 49:
			valor = 10;
			break;
		case 50:
			valor = 10;
			break;
		case 51:
			valor = 10;
			break;
		case 52:
			valor = 0;
			break;
		}
		return valor;
	}
	
	
	//===============================
	//=========BD Puntajes===========
	//===============================
	
	// Método conectar BD
	public Connection conectar()
	{
		Connection c = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/juegogolf?serverTimezone=UTC";
		String login = "root";
		String password = "Lu1994Juli1993";
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD clientes
			c = DriverManager.getConnection(url, login, password);
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		return (c);
	}

	// Método desconectar BD
	public void cerrar(Connection conexion)
	{
		try
		{
			if(conexion!=null)
			{
				conexion.close();
			}
		}
		catch (SQLException error)
		{
			System.out.println("Error 3-"+error.getMessage());
		}
	}

	// Método obtener datos BD
	public String consulta(Connection conexion)
	{
		String datos = "";
		Statement statement = null;
		ResultSet rs = null;
		String sentencia = "SELECT * FROM jugadores";
		try
		{
			//Crear una sentencia
			statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				datos = datos + rs.getInt("idJugador") + "\t" + "\t";
				datos = datos + rs.getString("nombreJugador")+ "\t\t";
				datos = datos + rs.getInt("puntosJugador") + "\n";
			}
		}
		catch (SQLException error)
		{
			System.out.println("Error 4-"+error.getMessage());
		}
		return (datos);
	}
	
}