package lec.lec1.Ex1;


/** 
 * Это точка 2D
*/
public class Point2D {
    private int x, y; // Это координата х и у

    /**
     * Это конструктор задания позиции точки
     * @param valueX это координата Х
     * @param valueY это координата Y
     */
    public Point2D(int valueX, int valueY) {
        x = valueX;
        y = valueY;
    }
    public Point2D(int value) {
        this(value, value);
    }
    public Point2D() {
        this(0);
    }

    /** 
     * Это методы получения позиции точки
    */
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    /** 
     * Это методы задания позиции точки
    */
    public void setX(int value){
        this.x = value;
    }
    public void setY(int value){
        this.y = value;
    }

    
    private String getInfo(){
        return String.format("x: %d; y: %d", x, y);
    }

    /** 
     * Это перераспределения метода .toString
    */
    @Override
    public String toString() {
        return getInfo();
    }

    /** 
     * Это метод вычисления дистанции
    */
    public static double distance(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
