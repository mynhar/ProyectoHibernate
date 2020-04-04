package es.pildoras.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;


public class PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/pruebasHibernate?useSSL=false";
		String usuario = "root";
		String contrasena = "123";
		
		try {
			System.out.println("Intentando conectar con la BBDD");
			
			Connection miConeccion = DriverManager.getConnection(jdbcUrl, usuario, contrasena);
			
			System.out.println("Conexion exitosa!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
