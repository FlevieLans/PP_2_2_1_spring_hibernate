package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
      return query.getResultList();
   }


   @Override
   @SuppressWarnings("unchecked")
   public User findUserByCar(Car car) {
         TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user where user.userCar.model = :model and user.userCar.series = :series");
         query.setParameter("model", car.getModel()).setParameter("series", car.getSeries());
         return query.getSingleResult();
   }

}