package L_LiskovSustitution;

public class L {
    public static void run() {
        SaleWithtax sale = new LocalSale(1200, "Cesar", 0.16);

        sale.generate();
        sale.calculateTaxes();

        sale = new ForeignSale(sale.amount, sale.customer, sale.taxes);

        sale.generate();
        sale.calculateTaxes();
    }
}

abstract class AbstractSale {
    protected double amount;
    protected String customer;

    public abstract void generate();
}

abstract class SaleWithtax extends AbstractSale {
    protected double taxes;

    public abstract void calculateTaxes();
}

class LocalSale extends SaleWithtax {
    public LocalSale(double amount, String customer, double taxes) {
        this.amount = amount;
        this.customer = customer;
        this.taxes = taxes;
    }

    @Override
    public void generate() {
        System.out.println("Se genera la venta");
    }

    @Override
    public void calculateTaxes() {
        System.out.println("Se calculan los impuestos");
    }
}

class ForeignSale extends SaleWithtax {
    public ForeignSale(double amount, String customer, double taxes) {
        this.amount = amount;
        this.customer = customer;
        this.taxes = taxes;
    }

    @Override
    public void generate() {
        System.out.println("Se genera la venta foranea");
    }

    @Override
    public void calculateTaxes() {
        System.out.println("Se calcula los impuestos para la foranea");
    }
}