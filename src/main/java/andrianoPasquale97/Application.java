package andrianoPasquale97;

import com.github.javafaker.Faker;
import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();
        LocalDate date=LocalDate.now();
        List<String> categoryList=new ArrayList<>();
        categoryList.add("Baby");
        categoryList.add("Toys");
        categoryList.add("Electronics");
        List <String> statusList=new ArrayList<>();
        statusList.add("Pending");
        statusList.add("Shipped");
        statusList.add("Delivered");
        Supplier<Customer> customerSupplier=()->{
            Faker faker = new Faker(Locale.ITALY);
            return new Customer(faker.name().firstName());

        };
        Supplier<Product> productSupplier=()->{
            Faker faker = new Faker(Locale.ITALY);
            return new Product(faker.commerce().productName(), categoryList.get(random.nextInt(0,3)),faker.number().randomDouble(10,1,1000));
        };
        List<Product> productList=new ArrayList<>();
        List<Product> productList2=new ArrayList<>();
        List<Product> productList3=new ArrayList<>();



        List<Order> order=new ArrayList<>();
        List<Customer> customers=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            customers.add(customerSupplier.get());
        }
        for (int i = 0; i < 10; i++) {
            productList.add(productSupplier.get());
        }
        for (int i = 0; i < 10; i++) {
            productList2.add(productSupplier.get());
        }
        for (int i = 0; i < 10; i++) {
            productList3.add(productSupplier.get());
        }
        Faker faker = new Faker(Locale.ITALY);
        Order order1= new Order(statusList.get(random.nextInt(0,3)), date  ,productList,customers.get(random.nextInt(0,3)));
        Order order2= new Order(statusList.get(random.nextInt(0,3)), date  ,productList3,customers.get(random.nextInt(0,3)));
        Order order3= new Order(statusList.get(random.nextInt(0,3)), date  ,productList2,customers.get(random.nextInt(0,3)));
        order.add(order1);
        order.add(order2);
        order.add(order3);

        productList.forEach(System.out::println);
        customers.forEach(System.out::println);
        order.forEach(System.out::println);

        Map<String, List<Order>> orderByCustomer=order.stream().collect(Collectors.groupingBy(orderS->orderS.getCustomer().getName()));
        Map<String, Double> totalOrder=order.stream().collect(Collectors.groupingBy(orderS->orderS.getCustomer().getName(), Collectors.summingDouble(orderS->orderS.getProducts().stream().mapToDouble(productS->productS.getPrice()).sum())));

        orderByCustomer.forEach((utente,ordini)-> System.out.println("Customer "+utente +" " + ordini.stream().toList()));
        totalOrder.forEach((utente,ordini)-> System.out.println("Customer "+utente +" ha speso:" + ordini));
    }
    }
