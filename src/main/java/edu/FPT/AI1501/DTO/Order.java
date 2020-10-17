package edu.FPT.AI1501.DTO;

public class Order {
    Product product;
    String name;

    public Order(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
