package S_SingleResponsability;

public class S {
    public static void run() {
        Beer beer = new Beer("Modelo", "Corona", 5);
        BeerDb beerDb = new BeerDb(beer);
        BeerRequest beerRequest = new BeerRequest(beer);

        beerDb.save();
        beerRequest.send();
    }
}

class Beer {
    private String name;
    private String brand;
    private int alcohol;

    public Beer(String name, String brand, int alcohol) {
        this.name = name;
        this.brand = brand;
        this.alcohol = alcohol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }
}

class BeerDb {
    private Beer beer;

    public BeerDb(Beer beer) {
        this.beer = beer;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public void save() {
        System.out.println("Guardamos " + this.beer.getName() + " -> " + this.beer.getBrand());
    }
}

class BeerRequest {
    private Beer beer;

    public BeerRequest(Beer beer) {
        this.beer = beer;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public void send() {
        System.out.println("Enviamos " + this.beer.getName() + " -> " + this.beer.getBrand());
    }
}