public class Point {
    private int x;
    private int y;

    public Point(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем, является ли объект экземпляром класса Point
        if (this == obj) return true; // Сравнение по ссылке
        if (!(obj instanceof Point)) return false; // Проверка на тип
        Point other = (Point) obj; // Приведение типа
        // Сравнение координат
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        // Генерация хэш-кода на основе координат
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }
}
