package com.juan.HibernateRelacionNaN;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import util.HibernateUtil;


public class CrearProducto {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		// Crear la sesion

		Session session = HibernateUtil.getSession();

		try {

			// Iniciar transaccion
			session.beginTransaction();

			Productos tomate = new Productos("Romanescu", "de Almeria", 10);
			Categorias cat = session.get(Categorias.class, 2);
			tomate.setCategoria(cat);
			session.save(tomate);

			Productos conejo = new Productos("Conejo", "Soriano", 5);
			Productos yogur = new Productos("Yogur", "Desnatado Pascual", 7);
			
			cat.addProductos(conejo);
			cat.addProductos(yogur);
			session.save(conejo);
			session.save(yogur);
			// commit de la transacci�n
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
