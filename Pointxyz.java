public class Pointxyz {
    private int x;
    private int y;
    private int z;

    public Pointxyz(double x, double y, double z) {
        this.x = (int) x;
        this.y = (int) y;
        this.z = (int) z;
    }

    @Override public String toString() {
        return "{" + x + "; " + y + "; " + z + "}";
    }
}
