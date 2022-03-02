package es.conexionHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

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
			Cliente cliente = session.get(Cliente.class, 3);
			
			// crear pedidos del cliente
			Pedido pedido01 = new Pedido(new Date(120,6,4)); // clase obsoleta
			Pedido pedido02 = new Pedido(new Date(120,5,3));
			Pedido pedido03 = new Pedido(new Date(120,7,2));
			
			// agregar pedidos al cliente
			cliente.agregarPedidos(pedido01);
			cliente.agregarPedidos(pedido02);
			cliente.agregarPedidos(pedido03);
			
			// guardar los pedidos en la bbdd
			session.save(pedido01);
			session.save(pedido02);
			session.save(pedido03);

			session.getTransaction().commit();

			System.out.println("Registros insertados correctamente en BBDD");

		} catch(Exception e){
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			factory.close();

		}

	}

}
