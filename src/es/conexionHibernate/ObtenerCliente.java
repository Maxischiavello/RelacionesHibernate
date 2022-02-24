package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		try {

			session.beginTransaction();

			// obtener objeto detallesCliente

			DetallesCliente detallesCliente = session.get(DetallesCliente.class, 1); // clase y id

			System.out.println(detallesCliente);

			System.out.println(detallesCliente.getCliente());
			
			System.out.println("Eliminar en cascada");
			
			session.delete(detallesCliente);

			session.getTransaction().commit();


			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		finally {
			
			session.close();
			
			factory.close();

		}

	}

}
