package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		try {

			Cliente cliente01 = new Cliente("Alana", "Xoxo", "Calle falsa 123");
			
			DetallesCliente detallesCliente01 = new DetallesCliente("www.alana.com", "321321", "cliente vital");
			
			// asociar los objetos 
			cliente01.setDetallesCliente(detallesCliente01);
			
			session.beginTransaction();
			
			// guarda la info en las dos tablas relacionadas
			session.save(cliente01);

			session.getTransaction().commit();

			System.out.println("Registro insertado correctamente en BBDD");

			session.close();

		} finally {

			factory.close();

		}

	}

}
