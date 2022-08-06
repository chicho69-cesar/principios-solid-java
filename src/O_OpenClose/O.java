package O_OpenClose;

import java.util.ArrayList;

public class O {
    public static void run() {
        var drinks = new ArrayList<IDrink>();
        drinks.add(new Water("Ciel", 12, 1));
        drinks.add(new Alcohol("Corona", 20, 1.16, 1.5));
        drinks.add(new Sugary("Sprite", 14, 1, 2.25));

        var invoice = new Invoice();
        System.out.println("El total a pagar es: $" + invoice.getTotal(drinks));
    }
}

interface IDrink {
    double getPrice();
}

class Water implements IDrink {
    String name;
    double price;
    double invoice;

    public Water(String name, double price, double invoice) {
        this.name = name;
        this.price = price;
        this.invoice = invoice;
    }

    @Override
    public double getPrice() {
        return this.price * this.invoice;
    }
}

class Alcohol implements IDrink {
    String name;
    double price;
    double invoice;
    double promo;

    public Alcohol(String name, double price, double invoice, double promo) {
        this.name = name;
        this.price = price;
        this.invoice = invoice;
        this.promo = promo;
    }

    @Override
    public double getPrice() {
        return (this.price * this.invoice) - this.promo;
    }
}

class Sugary implements IDrink {
    String name;
    double price;
    double invoice;
    double expiration;

    public Sugary(String name, double price, double invoice, double expiration) {
        this.name = name;
        this.price = price;
        this.invoice = invoice;
        this.expiration = expiration;
    }

    @Override
    public double getPrice() {
        return (this.price * this.invoice) - this.expiration;
    }
}

class Energizin implements IDrink {
    String name;
    double price;
    double invoice;

    public Energizin(String name, double price, double invoice) {
        this.name = name;
        this.price = price;
        this.invoice = invoice;
    }

    @Override
    public double getPrice() {
        return this.price * this.invoice;
    }
}

class Invoice {
    public double getTotal(ArrayList<IDrink> drinks) {
        double total = 0;

        for (IDrink drink : drinks) {
            total += drink.getPrice();
        }

        return total;
    }
}