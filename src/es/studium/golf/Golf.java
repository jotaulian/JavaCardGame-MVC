package es.studium.golf;

public class Golf
{
	public static void main(String[] args)
	{
		new Controlador(new VistaInicio(), new VistaJuego(), new Modelo());
	}
}