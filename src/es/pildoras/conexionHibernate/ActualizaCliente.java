package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session sesion = factory.openSession();
		
		try{			
			
			//int id = 1;
			
			sesion.beginTransaction();
			
			// Consultar el cliente
			
			/*
			Cliente obj = sesion.get(Cliente.class,id);			
			obj.setNombre("Harold Millin");
			obj.setDireccion("Santa Cruz, Guanacaste");
			*/
			
			//sesion.createQuery("update Cliente set Apellido = 'Bonilla' where Direccion LIKE 'S%'").executeUpdate();
			sesion.createQuery("delete Cliente where Direccion = 'Sierra'").executeUpdate();
			
			sesion.getTransaction().commit();
			
			System.out.println("Registro eliminado correctamente en BBDD");
			
			
			
			sesion.close();
			
		}finally {
			
			factory.close();
		}

	}

}
