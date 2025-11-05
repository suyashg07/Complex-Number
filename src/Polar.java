/**
 * @author Suyash Gupta
 */

public class Polar extends ComplexNumber {

    /** The polar radius of the complex number */
    final private double r;

    /** The phase angle of the polar complex number in radians*/
    private double theta;

    /**
     * Constructs a polar complex number with the given radius and phase.
     *
     * @param r the polar radius of the complex number, can be negative
     * @param theta the phase (angle) of the complex number in radians
     */
    public Polar(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    /**
     * Returns the real part of this complex number.
     * <p>
     * The real part is computed from the polar coordinates as:
     * <pre>
     *     real = r * cos(θ)
     * </pre>
     * Special handling is included: if {@code sin(θ)} is ±1, the real part is
     * treated as exactly 0 to avoid floating-point inaccuracies.
     *
     * @return the real part as a {@code double}
     */
    @Override
    public double real() {
        if (Math.abs(Math.sin(this.theta)) == 1)
            return 0;
        return this.r*Math.cos(this.theta);
    }

    /**
     * Returns the imaginary part of this complex number.
     * <p>
     * The imaginary part is computed from the polar coordinates as:
     * <pre>
     *     real = r * sin(θ)
     * </pre>
     * Special handling is included: if {@code cos(θ)} is ±1, the imaginary part is
     * treated as exactly 0 to avoid floating-point inaccuracies.
     *
     * @return the imaginary part as a {@code double}
     */
    @Override
    public double imag() {
        if (Math.abs(Math.cos(this.theta)) == 1)
            return 0;
        return this.r*Math.sin(this.theta);
    }

    /**
     * Returns the phase (angle) of this complex number in radians.
     * <p>
     * The phase is normalized to the range {@code [-π, π]}. If the modulus {@code r}
     * is negative, the phase {@code θ} is effectively rotated by π radians.
     * If the modulus is zero, the phase is defined as 0.
     *
     * @return the phase of the complex number in radians, normalized to [-π, π]
     */
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

    /**
     * Returns the modulus (magnitude) of this complex number.
     * <p>
     * The modulus is the absolute value of {@code r}, ensuring a non-negative result
     * even if the stored modulus {@code r} is negative.
     *
     * @return the modulus of the complex number as a {@code double}
     */
    @Override
    public double modulus() {
        return Math.abs(this.r);
    }

    /**
     * Returns the complex conjugate of this complex number.
     * <p>
     * The complex conjugate of a number in polar form {@code r ∠ θ} is
     * {@code r ∠ -θ}.
     *
     * @return a new {@link Polar} representing the complex conjugate
     */
    @Override
    public Polar conjugate() {
        return new Polar(this.r, -this.theta);
    }

    /**
     * Converts this complex number to rectangular (Cartesian) form.
     * <p>
     * The real and imaginary parts are computed from the polar coordinates:
     * <pre>
     *     real = r * cos(θ)
     *     imag = r * sin(θ)
     * </pre>
     *
     * @return a new {@link Rectangular} representing this complex number
     */
    @Override
    public Rectangular toComplexRect() {
        return new Rectangular(this.real(), this.imag());
    }

    /**
     * Returns this complex number in polar form.
     * <p>
     * Since this instance is already in polar form, this method simply returns
     * {@code this}. This is useful when the specific format of a complex number
     * is unknown and a polar representation is needed.
     *
     * @return this complex number as a {@link Polar}
     */
    @Override
    public Polar toComplexPolar() {
        return this;
    }

    /**
     * Returns the multiplicative inverse (reciprocal) of this complex number.
     * <p>
     * For a complex number in polar form {@code r ∠ θ}, the inverse is:
     * <pre>
     *     1/z = (1/r) ∠ -θ
     * </pre>
     *
     * @return a new {@link Polar} representing the multiplicative inverse
     */
    @Override
    public Polar inverse() {
        return new Polar(1/r, -theta);
    }

    /**
     * Returns a string representation of this complex number in polar form.
     * <p>
     * The format is {@code "r e^θi"}, where {@code r} is the modulus and
     * {@code θ} is the phase in radians.
     *
     * @return a {@link String} representing this complex number in polar form
     */
    @Override
    public String toString() {
        return "" + this.modulus() + "e^" + this.phase() + "i";
    }
}