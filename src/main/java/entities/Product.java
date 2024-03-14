package entities;

import java.util.List;
import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;
Random random = new Random();
    public Product(String name, String category, double price) {
        this.id =random.nextLong(1,100000000000L);        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Product> sameCategory(List<Product> products) {
      return  products.stream().filter(p -> p.getCategory().equals("Books")&&(p.getPrice()>100)).toList();
    }

    public List<Product> sameCategoryB (List<Product> products) {
        return  products.stream().filter(p -> p.getCategory().equals("Baby")).toList();
    }

    public List<Product> boysCategorySale(List<Product> products) {
        List<Product> boysList=products.stream().filter(p -> p.getCategory().equals("Boys")).toList();
        boysList.stream().forEach(p -> p.setPrice(p.getPrice()*0.9));
        return boysList;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
