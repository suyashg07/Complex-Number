/**
 * @author Suyash Gupta
 */

public class Polar extends ComplexNumber {

    private double r;
    private double theta;
    public Polar(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    @Override
    public double real() {
        if (Math.abs(Math.sin(this.theta)) == 1)
            return 0;
        return this.r*Math.cos(this.theta);
    }

    @Override
    public double imag() {
        if (Math.abs(Math.cos(this.theta)) == 1)
            return 0;
        return this.r*Math.sin(this.theta);
    }

    @Override
    public double phase() {
        if (r == 0) return 0;
        if (r < 0) this.theta += Math.PI;
        if (this.theta > Math.PI)
            while(this.theta > Math.PI) this.theta -= 2*Math.PI;
        if (this.theta < -Math.PI)
            while(this.theta < -Math.PI) this.theta += 2*Math.PI;
        return this.theta;
    }

    @Override
    public double modulus() {
        return Math.abs(this.r);
    }

    @Override
    public Polar conjugate() {
        return new Polar(this.r, -this.theta);
    }

    /**
     * Returns the complex number in rectangular form.
     * @return  the complex number in rectangular form.
     */
    @Override
    public Rectangular toComplexRect() {
        return new Rectangular(this.real(), this.imag());
    }

    @Override
    public Polar toComplexPolar() {
        return this;
    }

    @Override
    public Polar inverse() {
        return new Polar(1/modulus(), -phase());
    }

    @Override
    public String toString() {
        return "" + this.modulus() + "e^" + this.phase() + "i";
    }
}
