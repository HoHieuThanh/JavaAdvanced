public class DigitalProduct extends Product {
    private double size;

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Sản phẩm số - ID: " + id + " | Tên: " + name + " | Giá: " + price + " | Dung lượng: " + size + " MB");
    }
}
