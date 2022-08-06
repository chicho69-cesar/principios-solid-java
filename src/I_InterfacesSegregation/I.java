package I_InterfacesSegregation;

import java.util.ArrayList;
import java.util.Date;

public class I {
    public static void run() {
        UserService userService = new UserService();
        userService.add(new User());
        userService.update(new User());

        SaleService saleService = new SaleService();
        saleService.add(new Sale());
    }
}

interface IBasicActions<T> {
    public T get(int id);
    public ArrayList<T> getList();
    public void add(T entity);
}

interface IEditableActions<T> {
    public void update(T entity);
    public void delete(T entity);
}

class User {
    public int id;
    public String name;
    public String email;
}

class Sale {
    public double amount;
    public Date date;
}

class UserService implements IBasicActions<User>, IEditableActions<User> {
    public User get(int id) {
        System.out.println("Obtenemos el usuario con id " + id);
        return new User();
    }

    public ArrayList<User> getList() {
        System.out.println("Obtenemos a todos los usuarios");
        return new ArrayList<User>();
    }

    public void add(User entity) {
        System.out.println("Agregamos al usuario");
    }

    public void update(User entity) {
        System.out.println("Modificamos al usuario");
    }

    public void delete(User entity) {
        System.out.println("Eliminamos al usuario");
    }
}

class SaleService implements IBasicActions<Sale> {
    public Sale get(int id) {
        return new Sale();
    }

    public ArrayList<Sale> getList() {
        return new ArrayList<Sale>();
    }

    public void add(Sale entity) {
        System.out.println("Agregamos una nueva venta");
    }
}