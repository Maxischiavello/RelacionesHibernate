package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

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
			
			Cliente clientePorEliminar = session.get(Cliente.class, 2); //clase y id
			
			if (clientePorEliminar != null) {
				session.delete(clientePorEliminar);
			}

			session.getTransaction().commit();

			if (clientePorEliminar != null) System.out.println("Registro eliminado correctamente en BBDD");
			else System.out.println("No existe tal registro para eliminar");
			session.close();

		} finally {

			factory.close();

		}

	}

}
