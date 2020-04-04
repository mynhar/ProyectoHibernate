package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaClientePrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session sesion = factory.openSession();
		
		try{
			
			Cliente obj = new Cliente("Fulano","Perez","Sierra");
			
			sesion.beginTransaction();
			
			sesion.save(obj);
			
			sesion.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en BBDD");
			
			//Lectura de registro
			sesion.beginTransaction();
			System.out.println("Lectura del registro con Id:"+ obj.getId());
			
			Cliente objInsertado = sesion.get(Cliente.class, obj.getId());
			
			System.out.println("Registro:"+ objInsertado.toString());
			
			sesion.getTransaction().commit();
			
			System.out.println("Terminado!");
			
			sesion.close();
			
		}finally {
			
			factory.close();
		}

	}

}
