package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		try {
			
			session.beginTransaction();
			
			DetallesCliente detallesCliente = session.get(DetallesCliente.class, 3); //clase y id
			
			detallesCliente.getCliente().setDetallesCliente(null);
			
			if (detallesCliente != null) {
				
				session.delete(detallesCliente);
			}

			session.getTransaction().commit();

			if (detallesCliente != null) System.out.println("Registro eliminado correctamente en BBDD");
			else System.out.println("No existe tal registro para eliminar");
			
			session.close();

		} finally {

			factory.close();

		}

	}

}
