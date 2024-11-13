package com.juan.HibernateRelacionNaN;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import model.*;

public class CrearProductoProveedor {

	public static void main(String[] args) {



		SessionFactory factory = HibernateUtil.getSessionFactory();
			// Crear la sesion

		Session session = HibernateUtil.getSession();


		try {

			// Iniciar transaccion
			session.beginTransaction();

			Proveedores paco= new Proveedores("Ana", "221133", "Valladolid");
			
			session.save(paco);

			Productos pepino = new Productos("Pepino", "Frances", 5);
			Productos endivia = new Productos("Endivia", "Nada envidiosa", 7);
			
			paco.addProducto(pepino);
			paco.addProducto(endivia);
			session.save(pepino);
			session.save(endivia);
			// commit de la transaccion
			session.getTransaction().commit();
			session.close();

		} finally {
			factory.close();
		}
	}

}
