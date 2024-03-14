package entities;

import java.util.Random;

public class Customer {
    private Long id;
    private String name;

    private Integer tier;

    Random random = new Random();
    public Customer(String name) {
        id = random.nextLong(1, 1000000000000000000L);
        tier= random.nextInt(1,5);
        this.name = name;        this.tier = tier;

    }

    public Integer getTier() {
        return tier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
