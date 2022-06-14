package Validate;

import model.Product;

import java.util.List;
import java.util.Scanner;

public class Validate {
    Scanner scanner = new Scanner(System.in);

    public int validateID(List<Product> product) {
        while (true) {
            try {
                System.out.print("Nhập id(la:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, product) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai id rồi");
            }
        }
    }

    public int getIndexId(int id, List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == id) {
                return i;
            }
        }
        return -1;
    }

    public String validateString(String nameproduct) {
        while (true) {
            System.out.print("Nhập " + nameproduct);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("không để trống");
                continue;
            } else {
                return str;
            }
        }
    }

    public double validatePrice() {
        while (true) {
            try {
                System.out.print("Nhập price:");
                double price = Integer.parseInt(scanner.nextLine());
                return price;
            } catch (Exception e) {
                System.err.println("Nhập sai price rồi");
            }
        }
    }

    public int validateAmount() {
        while (true) {
            try {
                System.out.print("Nhập số lượng:");
                int price = Integer.parseInt(scanner.nextLine());
                return price;
            } catch (Exception e) {
                System.err.println("Nhập sai số lượng rồi");
            }
        }
    }
}