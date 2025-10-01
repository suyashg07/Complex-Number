/**
 * @author Suyash Gupta
 * 
 */

public class Rectangular extends ComplexNumber {

    final private double real;
    final private double imag;

    public Rectangular(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public double real() {
        return this.real;
    }

    @Override
    public double imag() {
        return this.imag;
    }

    @Override
    public double phase() {
        if (real < 0) {
            if (imag >= 0) return Math.atan(this.imag/this.real) + Math.PI;
            else return Math.atan(this.imag/this.real) - Math.PI;
        }
        else if(this.real == 0 && this.imag == 0) return 0;
        return Math.atan(this.imag/this.real);
    }

    @Override
    public double modulus() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    @Override
    public Rectangular conjugate() {
        return new Rectangular(this.real, -this.imag);
    }

    @Override
    public Rectangular toComplexRect() {
        return this;
    }

    /**
     * Returns the complex number in polar format.
     */
    @Override
    public Polar toComplexPolar() {
        return new Polar(this.modulus(), this.phase());
    }

    @Override
    public Rectangular inverse() {
        return new Rectangular(this.real/Math.pow(this.modulus(),2), -this.imag/Math.pow(this.modulus(), 2));
    }

    @Override
    public String toString() {
        if (imag < 0)
            return "" + this.real + " - " + -this.imag + "i";
        return "" + this.real + " + " + this.imag + "i";
    }
}