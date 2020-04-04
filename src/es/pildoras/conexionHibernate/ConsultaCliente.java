package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaCliente {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();		
		Session sesion = factory.openSession();
		
		try{
			
			// comenzar sesion
			sesion.beginTransaction();
			
			// consultar cliente
			List<Cliente> objList = sesion.createQuery("From Cliente").getResultList();
			
			// mostrar los clientes
			recorreClientesConsultados(objList);
			
			// Consulta: Bonilla. Hay que utilizar el nombre de la propiedad en la clase.
			objList = sesion.createQuery("From Cliente cl where cl.apellido = 'Bonilla'").getResultList();
			recorreClientesConsultados(objList);
			
			// Muestra: Direccion Viento y Apellido Valle
			objList = sesion.createQuery("From Cliente cl where cl.apellido = 'Valle' or cl.direccion='Nautica'").getResultList();
			recorreClientesConsultados(objList);
			
			
			// commit
			sesion.getTransaction().commit();
			
			// cerrar sesion
			sesion.close();
			
		}finally {
			
			factory.close();
		}

	}

	/**
	 * 
	 * @param objList
	 */
	private static void recorreClientesConsultados(List<Cliente> objList) {
		for(Cliente obj: objList) {
			System.out.println(obj);
		}
	}

}
