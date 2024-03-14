package entities;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;

    private Customer customer;
Random random = new Random();
    public Order(String status, LocalDate orderDate, List<Product> products, Customer customer) {
        this.id= random.nextLong(1,1000000000000000000L);
        this.status = status;
        this.orderDate = orderDate;
        this.products = products;
            this.customer = customer;
            this.deliveryDate = orderDate.plusDays(7);
    }
public List<Product> getProducts() {
        return this.products;}
public List<List<Product>> getBabyOrder (List<List<Product>> babyOrders) {
        List<Product> productList=this.products.stream().filter(p -> p.getCategory().equals("Baby")).toList();
       babyOrders.add(productList);
       return babyOrders;

}

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }


    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}




