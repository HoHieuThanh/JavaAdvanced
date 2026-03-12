package service;

import exception.InvalidProductException;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {

    private List<Product> productList = new ArrayList<>();


    public void addProduct(int id, String name, double price, int quantity, String category)
            throws InvalidProductException {

        boolean exists = productList.stream()
                .anyMatch(p -> p.getId() == id);

        if (exists) {
            throw new InvalidProductException("ID đã tồn tại");
        }

        Product product = new Product(id, name, price, quantity, category);

        productList.add(product);
    }



    public void displayProducts() {

        if (productList.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        System.out.println("ID | Sản phẩm | Danh mục | Giá | Số lượng");
        productList.forEach(System.out::println);
    }


    public void updateQuantity(int id, int newQuantity) throws InvalidProductException {

        Optional<Product> productOptional = productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (productOptional.isPresent()) {

            Product product = productOptional.get();
            product.setQuantity(newQuantity);

        } else {
            throw new InvalidProductException("Không tim thấy sản phẩm");
        }
    }


    public void deleteProduct(int id) {

        productList.removeIf(p -> p.getId() == id);
    }
}

