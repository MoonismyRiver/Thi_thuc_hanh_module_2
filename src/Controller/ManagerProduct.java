package Controller;

import IO.ReadAndWriteProduct;
import Soft.SoftByPrice;
import model.Product;
import Validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    List<Product> arrayProduct = new ArrayList<>();
    Validate validate = new Validate();
    ReadAndWriteProduct readAndWriteProduct = new ReadAndWriteProduct();

    public void menu() {
        System.out.println("__________CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM_________");
        System.out.println("Chọn chức năng theo số ( để tiếp tục)");
        System.out.println("1.Xem danh sách.");
        System.out.println("2.Thêm mới.");
        System.out.println("3.Chỉnh sửa.");
        System.out.println("4.Xóa.");
        System.out.println("5.Sắp xếp sản phẩm theo giá từ thấp đến cao.");
        System.out.println("6.Sản phẩm có giá cao nhất.");
        System.out.println("7.Đọc dữ liệu từ file.");
        System.out.println("8.Ghi dữ liệu hiện tại vào file.");
        System.out.println("9.Thoát");


        while (true) {
            try {
                System.out.println("Chọn chức năng:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showAll();
                        break;
                    case 2:
                        add();
                        break;
                    case 3:
                        editProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        softbyPrice();
                        break;
                    case 6:
                        showMostExpensive();
                        break;
                    case 7:
                        System.out.println("Đọc dữ liệu từ file có thể xóa dứ liệu chưa thêm.Có chắc đọc ?");
                        System.out.println("1.Ok");
                        System.out.println("2.Nope");
                        int input = Integer.parseInt(scanner.nextLine());
                        switch (input) {
                            case 1:
                                arrayProduct = readAndWriteProduct.read();
                                System.out.println("Đọc thành công !");
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 8:
                        readAndWriteProduct.write(arrayProduct);
                        System.out.println("Ghi thành công! ");
                        break;

                    case 9:
                        System.exit(0);
                        break;

                }
            } catch (Exception e) {
                System.out.println("Nhập sai rồi !");

            }
        }
    }

    public void showAll() {
        for (int i = 0; i < arrayProduct.size(); i++) {
            if ((i + 1) % 5 == 0) {
                System.out.println(arrayProduct.get(i));
                scanner.nextLine();
            } else {
                System.out.println(arrayProduct.get(i));
            }

        }
    }

    public Product creatProduct() {
        int id = validate.validateID(arrayProduct);
        String name = validate.validateString("name");
        double price = validate.validatePrice();
        int amount = validate.validateAmount();
        return new Product(id, name, price, amount);

    }

    public void add() {
        arrayProduct.add(creatProduct());
        System.out.println("thêm thành công !");
    }

    public void editProduct() {
        System.out.println("nhập id cần sửa :");
        int id = scanner.nextInt();
        int index = validate.getIndexId(id, arrayProduct);
        if (index != -1) {
            arrayProduct.set(index, creatProduct());
        } else {
            System.err.println("id không tồn tại !");
        }
    }

    public void deleteProduct() {
        System.out.println("nhập id sản phẩm muốn xóa:");
        int id = scanner.nextInt();
        int index = validate.getIndexId(id, arrayProduct);
        if (index != -1) {
            System.out.println("Có chắc xóa không ?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    arrayProduct.remove(index);
                    break;
                case 2:
                    break;
            }
        } else {
            System.err.println("id không tồn tại");
        }

    }

    public void softbyPrice() {
        arrayProduct.sort(new SoftByPrice());
        System.out.println("sắp xếp thành công !");
        showAll();
    }

    public void showMostExpensive() {
        double max = arrayProduct.get(0).getPrice();
        for (int i = 0; i < arrayProduct.size(); i++) {
            if (arrayProduct.get(i).getPrice() > max) {
                max = arrayProduct.get(i).getPrice();
            }
        }
        System.out.println("Các sản phẩm có giá cao nhất là :");
        for (int i = 0; i < arrayProduct.size(); i++) {
            if (arrayProduct.get(i).getPrice() == max) {
                System.out.println(arrayProduct.get(i));
            }
        }
    }


}
