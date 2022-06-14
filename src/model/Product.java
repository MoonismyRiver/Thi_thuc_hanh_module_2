package model;

public class Product {
    private int productID;
    private String nameproduct;
    private double price;
    private int amount;

    public Product() {
    }

    public Product(int productID, String nameproduct, double price, int amount) {
        this.productID = productID;
        this.nameproduct = nameproduct;
        this.price = price;
        this.amount = amount;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "product{" +
                "productID=" + productID +
                ", nameproduct='" + nameproduct + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }


    public String write() {
        return nameproduct + "," + productID + "," + price + "," + amount ;
    }
}
