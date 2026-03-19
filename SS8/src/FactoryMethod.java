public class FactoryMethod {
    public static Shape create(String type){
        switch (type.toLowerCase()){
            case "circle":
                return new Circle();
            case "triangle":
                return new Triangle();
            default:
                throw new RuntimeException("Không hợp lệ");
        }
    }

    public static void main(String[] args) {
        Shape shape = FactoryMethod.create("circle");
        shape.draw();
        Shape shape1 = FactoryMethod.create("d");
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {

    }
}
class Triangle implements Shape{

    @Override
    public void draw() {

    }
}
