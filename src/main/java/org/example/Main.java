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

            // Iniciar transaccion
            transaction = session.beginTransaction();

            User user = new User("juan", "juan", "juan@gmail.com");
            session.save(user);


            Group group = new Group("Profesores");
            session.save(group);


            UserGroup userGroup = new UserGroup();
            userGroup.setGroup(group);
            userGroup.setUser(user);

            userGroup.setCuota(300);

            session.save(userGroup);
            transaction.commit();


            // this user is obtained from the database with ID 1
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, 1);

            // this group is obtained from the database with ID 14
            group = (Group) session.get(Group.class, 2);

             //añadimos a tabla usuarios grupos
            userGroup = new UserGroup();
            userGroup.setGroup(group);
            userGroup.setUser(user);

            userGroup.setCuota(200);

            session.save(userGroup);
            transaction.commit();



//borrar un registro de la tabla usuarios_grupos
            transaction = session.beginTransaction();
            UserGroup usugrup1 = session.get(UserGroup.class, 1);

            session.delete(usugrup1);

            transaction.commit();


   //BORRAMOS un usuario. Se supone que al ser en cascada me borraria algun registro de la tabla usuarios_grupos

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