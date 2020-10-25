package edu.FPT.AI1501.DTO;

public class Product {
    String id;
    String name;
    Double price;
    String categoryID;

    public Product(String id, String name, Double price, String categoryID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
    }

    public Product(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public boolean equals(Object product) {
        return this.getId().equals(((Product) product).getId());
    }

   

    

}
