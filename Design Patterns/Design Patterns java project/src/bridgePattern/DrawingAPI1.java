package bridgePattern;

class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.printf("API1: Circle çiz (%d,%d,%d)%n", x, y, radius);
    }
}
