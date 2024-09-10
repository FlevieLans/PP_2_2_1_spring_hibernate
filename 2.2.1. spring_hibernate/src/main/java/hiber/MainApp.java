package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car carname1 = new Car("Carname1", 1);
      Car carname2 = new Car("Carname2", 2);
      Car carname3 = new Car("Carname3", 3);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", carname1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", carname2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if (!(user.getUserCar() == null)) {
            System.out.println("Car = " + user.getUserCar());
         }
         System.out.println();
      }

      System.out.println("Авто, модель которой " + carname2.getModel() + ", а серия " + carname2.getSeries() + "\n" +
              "принадлежит пользователю:");
      System.out.println(userService.findUserByCar(carname2));

      context.close();
   }
}