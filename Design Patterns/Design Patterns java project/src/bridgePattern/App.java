package bridgePattern;

public class App {
    public static void main(String[] args) {
        Shape circle1 = new Circle(1, 2, 3, new DrawingAPI1());
        Shape circle2 = new Circle(5, 7, 11, new DrawingAPI2());

        circle1.draw();
        circle2.draw();
    }
}
