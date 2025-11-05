public class App {
    public static void main(String[] args) throws Exception {
        ComplexNumber z1 = new Rectangular(1,1);
        ComplexNumber z2 = new Polar(1, 1);
        System.out.println(ComplexNumber.log(new Rectangular(1,1)));
        System.out.println(ComplexNumber.log(z2));
        
    }
}