package es.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		try {
			
			session.beginTransaction();
			
			// obtener el cliente de la tabla cliente de la bbdd
			Cliente cliente = session.get(Cliente.class, 4);
			
			System.out.println("Cliente: " + cliente);
			
			System.out.println("Pedidos: " + cliente.getPedidos());

			session.getTransaction().commit();

			System.out.println("Registros obtenidos correctamente en BBDD");

		} catch(Exception e){
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			factory.close();

		}

	}

}
