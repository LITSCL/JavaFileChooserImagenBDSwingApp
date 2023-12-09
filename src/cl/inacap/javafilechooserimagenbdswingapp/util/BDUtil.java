package cl.inacap.javafilechooserimagenbdswingapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDUtil {
	private final String servidor = "localhost"; //Dirección del servidor.
	private final String baseDeDatos = "dbjavafilechooserimagenbdswingapp"; //Nombre de la base de datos.
	private final String usuario = "root"; //Usuario para conectarse al dbms.
	private final String clave = "root"; //Contraseña para conectarse al dbms.
	private Connection conexion;
	
	public Connection getConexion() {
		return conexion;
	}
	
	//Método que conecta el programa a la base de datos.
	public boolean conectar() {
		try {
			String url = "jdbc:mysql://" + servidor + ":3306/" + baseDeDatos; //Esta es la url de conexión para la base de datos.
			Class.forName("com.mysql.cj.jdbc.Driver"); //Class.forname es necesario para registrar el driver a utilizar.
			this.conexion=DriverManager.getConnection(url, usuario, clave); //Este método trata de establecer la conexión a la base de datos entregada utilizando el driver registrado.
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void desconectar() {
		try {
			this.conexion.close();	//Esta instrucción avisa al dbms que se va a desconectar.
		} catch(Exception ex) {
			
		}
	}
}
