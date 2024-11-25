package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import model.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = null;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        // Crear la sesion

        Session session = HibernateUtil.getSession();


        try {
            //INSERTAR
            //inicio la transacción
            transaction = session.beginTransaction();

            //creo y guardo un usuario
            User user = new User("juan", "juan", "juan@gmail.com");
            session.save(user);

            //creo y guardo un grupo
            Group group = new Group("Profesores");
            session.save(group);

            //creo y guaro el grupo y el usuario en los campos de la tabla UserGroup
            UserGroup userGroup = new UserGroup();
            userGroup.setGroup(group);
            userGroup.setUser(user);

            userGroup.setCuota(300);

            session.save(userGroup);

            //finalizo la transacción
            transaction.commit();




            //
            // this user is obtained from the database with ID 1
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, 1);

            // this group is obtained from the database with ID 14
            group = (Group) session.get(Group.class, 2);




            //añadimos a tabla UserGroup
            userGroup = new UserGroup();
            userGroup.setGroup(group);
            userGroup.setUser(user);

            userGroup.setCuota(200);

            session.save(userGroup);
            transaction.commit();




            //BORRAR UN REGISTRO DE LA TABLA usuarios_grupos
            transaction = session.beginTransaction();
            UserGroup usugrup1 = session.get(UserGroup.class, 1);

            session.delete(usugrup1);

            transaction.commit();




            //BORRAMOS UN USUARIO. SE SUPONE QUE AL SER EN CASCADA ME BORRARÁ ALGÚN REGISTRO DE LA TABLA usuarios_grupos
            transaction = session.beginTransaction();
            User user1=session.get(User.class,1);
            session.delete(user1);

            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            factory.close();
        }
    }
}