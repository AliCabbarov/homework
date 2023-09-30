package bridgePattern;

public class DrawingAPI2 implements DrawingAPI{
        @Override
        public void drawCircle(int x, int y, int radius) {
            System.out.printf("API2: Circle çiz (%d,%d,%d)%n", x, y, radius);
        }
}
