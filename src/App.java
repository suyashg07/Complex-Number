public class App {
    public static void main(String[] args) throws Exception {
        Rectangular z1 = new Rectangular(1,2);
        Polar z2 = z1.toComplexPolar();
        System.out.println(z1.equals(z2));
    }
}
