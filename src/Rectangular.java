/**
 * @author Suyash Gupta
 * 
 */

public class Rectangular extends ComplexNumber {

    /** The real part of the complex number. */
    final private double real;

    /** The imaginary part of the complex number. */
    final private double imag;

    /**
     * Constructs a rectangular complex number with the given real and imaginary parts.
     *
     * @param real the real part of the complex number
     * @param imag the imaginary part of the complex number
     */
    public Rectangular(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Returns the real part of this complex number.
     *
     * @return the real part as a {@code double}
     */
    @Override
    public double real() {
        return this.real;
    }

    /**
     * Returns the imaginary part of this complex number.
     *
     * @return the imaginary part as a {@code double}
     */
    @Override
    public double imag() {
        return this.imag;
    }

    /**
     * Returns the phase (also called argument) of this complex number in radians.
     * <p>
     * The phase is the angle θ between the positive real axis and the line representing
     * the complex number in the complex plane, calculated using:
     * <pre>
     *     θ = atan(imag / real)
     * </pre>
     * Adjustments are made to account for the correct quadrant.
     *
     * @return the phase of the complex number in radians as a {@code double}
     */
    @Override
    public double phase() {
        if (real < 0) {
            if (imag >= 0)
                return Math.atan(this.imag/this.real) + Math.PI;
            else
                return Math.atan(this.imag/this.real) - Math.PI;
        }
        else if(this.real == 0 && this.imag == 0)
            return 0;
        return Math.atan(this.imag/this.real);
    }

    /**
     * Returns the modulus (magnitude) of this complex number.
     * <p>
     * The modulus is defined as:
     * <pre>
     *     |z| = √(real² + imag²)
     * </pre>
     * where {@code real} and {@code imag} are the real and imaginary parts of the complex number.
     *
     * @return the modulus of the complex number as a {@code double}
     */
    @Override
    public double modulus() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    /**
     * Returns the complex conjugate of this complex number.
     * <p>
     * The complex conjugate of a number {@code z = a + bi} is {@code a - bi}.
     *
     * @return a new {@link Rectangular} representing the complex conjugate
     */
    @Override
    public Rectangular conjugate() {
        return new Rectangular(this.real, -this.imag);
    }

    /**
     * Returns this complex number in rectangular (Cartesian) form.
     * <p>
     * Since this instance is already in rectangular form, this method simply returns
     * {@code this}. This method is useful when the specific format of a complex number
     * is unknown and a rectangular representation is needed.
     *
     * @return this complex number as a {@link Rectangular}
     */
    @Override
    public Rectangular toComplexRect() {
        return this;
    }

    /**
     * Converts this complex number to polar form.
     * <p>
     * The modulus and phase are computed from the rectangular coordinates:
     * <pre>
     *     r = √(real² + imag²)
     *     θ = atan2(imag, real)
     * </pre>
     *
     * @return a new {@link Polar} representing this complex number
     */
    @Override
    public Polar toComplexPolar() {
        return new Polar(this.modulus(), this.phase());
    }

    /**
     * Returns the multiplicative inverse (reciprocal) of this complex number.
     * <p>
     * The inverse is defined as {@code 1 / z}, where {@code z} is this complex number.
     *
     * @return a new {@link Rectangular} representing the multiplicative inverse
     */
    @Override
    public Rectangular inverse() {
        return (Rectangular) ComplexNumber.divide(1, this);
    }

    /**
     * Returns a string representation of this complex number in rectangular form.
     * <p>
     * The format is {@code a+bi} or {@code a-bi}, depending on the sign of the imaginary part.
     *
     * @return a {@link String} representing this complex number
     */
    @Override
    public String toString() {
        if (this.imag < 0)
            return "" + this.real + "-" + -this.imag + "i";
            
        return "" + this.real + "+" + this.imag + "i";
    }
}