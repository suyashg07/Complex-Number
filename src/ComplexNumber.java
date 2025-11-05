
public abstract class ComplexNumber {

    public static final Polar I = new Polar(1, Math.PI/2);

    /**
     * Determines the real component of the complex number.
     * @return the real component as a double.
     */
    public abstract double real();

    /**
     * Determines the imaginary component of the complex number.
     * @return the imaginary component as a double.
     */
    public abstract double imag();

    /**
     * Calculates the absolute value of the complex number.
     * @return the absolute value as a double.
     */
    public abstract double modulus();

    /**
     * Calculates the phase angle of the complex number.
     * @return the phase angle as a double in range [-π, π].
     */
    public abstract double phase();

    /**
     * Returns the conjugate of the complex number.
     * @return the conjugate in the same format as the complex number.
     */
    public abstract ComplexNumber conjugate();

    /**
     * Calculates the inverse of the complex number.
     * @return the inverse in the same format as the complex number.
     */
    public abstract ComplexNumber inverse();

    /**
     * Returns the complex number in rectangular format. This is
     * useful when the type of complex number is unknown.
     * @return a complex number in rectangular format.
     */
    public abstract Rectangular toComplexRect();

    /**
     * Returns the complex number in polar format. This is
     * useful when the type of complex number is unknown.
     * @return a complex number in polar format.
     */
    public abstract Polar toComplexPolar();

    /**
     * Compares this complex number to another object for equality.
     * <p>
     * Two complex numbers are considered equal if their real and imaginary parts
     * are equal within a tolerance of {@code 1e-6}.
     *
     * @param other the object to compare with
     * @return {@code true} if {@code other} is a {@link ComplexNumber} and
     *         its real and imaginary parts are equal to this complex number
     *         within a tolerance of {@code 1e-6}, {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof ComplexNumber oth) {
            return Math.abs(this.real()-oth.real()) < 0.000001 && Math.abs(this.imag()-oth.imag()) < 0.000001;
        }
        return false;
    }
    
    //HELPER METHOD
    private static ComplexNumber addH(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input complex numbers must not be null.");

        if(a instanceof Polar && b instanceof Polar)
            return new Rectangular(a.real() + b.real(), a.imag() + b.imag()).toComplexPolar();

        return new Rectangular(a.real() + b.real(), a.imag() + b.imag());
    }


    /**
     * Adds one or more complex numbers and/or real numbers together.
     * <p>
     * Each argument can be a {@link ComplexNumber}, {@code Double}, or {@code Integer}.
     * Real numbers are treated as complex numbers with zero imaginary part.
     * The addition is performed in sequence from left to right.
     * </p>
     *
     * @param args one or more {@link ComplexNumber}, {@code Double}, or {@code Integer} values to add
     * @return the sum as a {@link ComplexNumber}
     * @throws IllegalArgumentException if {@code args} is {@code null}, empty, or contains an unsupported type
     */
    public static ComplexNumber add(Object... args) throws IllegalArgumentException {
        if(args == null || args.length == 0)
            throw new IllegalArgumentException("There has to be at least one argument.");

        ComplexNumber sum = new Polar(0, 0);

        for(Object arg : args) {
            ComplexNumber z;

            if(arg instanceof ComplexNumber z1)
                z = z1;
            else if(arg instanceof Double d)
                z = new Polar(d, 0);
            else if(arg instanceof Integer i)
                z = new Polar(i, 0);
            else
                throw new IllegalArgumentException("Input arguments need to be either a complex number or a real number");

            sum = addH(z, sum);
        }

        return sum;
    }

    /**
     * Subtracts one complex number from another and returns the result.
     * <p>
     * This method computes {@code a - b} for two {@link ComplexNumber} objects.
     * It supports both rectangular and polar forms:
     * <ul>
     *   <li>If both inputs are instances of {@link Polar}, the subtraction is performed
     *       in rectangular coordinates and the result is converted back to a {@link Polar} form.</li>
     *   <li>Otherwise, the result is returned as a {@link Rectangular} complex number.</li>
     * </ul>
     *
     * @param a the minuend (the complex number to subtract from)
     * @param b the subtrahend (the complex number to subtract)
     * @return the resulting {@link ComplexNumber} after subtraction;
     *         the type depends on the input forms
     * @throws IllegalArgumentException if either {@code a} or {@code b} is {@code null}
     */
    public static ComplexNumber subtract(ComplexNumber a, ComplexNumber b) throws IllegalArgumentException {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input complex numbers must not be null.");

        if(a instanceof Polar && b instanceof Polar)
            return new Rectangular(a.real() - b.real(), a.imag() - b.imag()).toComplexPolar();
        
        return new Rectangular(a.real() - b.real(), a.imag() - b.imag());
    }

    /**
     * Subtracts a real number from a complex number and returns the result.
     * <p>
     * This method treats the real number {@code b} as a complex number with
     * magnitude {@code b} and phase {@code 0}, then calls
     * {@link #subtract(ComplexNumber, ComplexNumber)} to perform the subtraction.
     *
     * @param a the complex number to subtract from
     * @param b the real number to subtract
     * @return the resulting {@link ComplexNumber} after subtraction
     */
    public static ComplexNumber subtract(ComplexNumber a, double b) {
        return subtract(a, new Polar(b, 0));
    }

    /**
     * Subtracts a complex number from a real number and returns the result.
     * <p>
     * This method treats the real number {@code a} as a complex number with
     * magnitude {@code a} and phase {@code 0}, then calls
     * {@link #subtract(ComplexNumber, ComplexNumber)} to perform the subtraction.
     *
     * @param a the real number to subtract from
     * @param b the complex number to subtract
     * @return the resulting {@link ComplexNumber} after subtraction
     */
    public static ComplexNumber subtract(double a, ComplexNumber b) {
        return subtract(new Polar(a, 0), b);
    }

    //HELPER METHOD
    private static ComplexNumber multiplyH(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input complex numbers must not be null.");
        
        if(a instanceof Polar && b instanceof Polar)
            return new Polar(a.modulus()*b.modulus(), a.phase()+b.phase());

        return new Rectangular(a.real()*b.real() - a.imag()*b.imag(),
                                a.real()*b.imag() + a.imag()*b.real());
    }
    
    /**
     * Multiplies one or more complex numbers and/or real numbers together.
     * <p>
     * Each argument can be a {@link ComplexNumber}, {@code Double}, or {@code Integer}.
     * Real numbers are treated as complex numbers with zero imaginary part.
     * The multiplication is performed in sequence from left to right.
     * </p>
     *
     * @param args one or more {@link ComplexNumber}, {@code Double}, or {@code Integer} values to multiply
     * @return the product as a {@link ComplexNumber}
     * @throws IllegalArgumentException if {@code args} is {@code null}, empty, or contains an unsupported type
     */
    public static ComplexNumber multiply(Object... args) throws IllegalArgumentException {
        if(args == null)
            throw new IllegalArgumentException("The arguments must be either a complex number of a real number ");

        if(args.length == 0)
            throw new IllegalArgumentException("There has to be al least one argument.");
        
        ComplexNumber product = new Polar(1, 0);

        for(Object arg : args) {
            ComplexNumber z;

            if(arg instanceof ComplexNumber z1)
                z = z1;
            else if(arg instanceof Double d)
                z = new Polar(d, 0);
            else if(arg instanceof Integer i)
                z = new Polar(i, 0);
            else
                throw new IllegalArgumentException("Input arguments need to be either a complex number or a real number");

            product = multiplyH(z, product);
        }

        return product;
    }

    /**
     * Divides one complex number by another and returns the result.
     * <p>
     * This method computes {@code a / b} for two {@link ComplexNumber} objects.
     * The division is performed in polar form by dividing the magnitudes and
     * subtracting the phases:
     * <pre>
     *     r = a.modulus() / b.modulus()
     *     θ = a.phase() - b.phase()
     * </pre>
     * The result is represented as a {@link Polar} complex number if both inputs
     * are instances of {@link Polar}; otherwise, it is converted to a
     * {@link Rectangular} form.
     *
     * @param a the dividend (the complex number to be divided)
     * @param b the divisor (the complex number to divide by)
     * @return the resulting {@link ComplexNumber} after division,
     *         returned as {@link Polar} if both inputs are polar, otherwise as {@link Rectangular}
     * @throws IllegalArgumentException if either {@code a} or {@code b} is {@code null}
     */
    public static ComplexNumber divide(ComplexNumber a, ComplexNumber b) throws IllegalArgumentException {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input complex numbers must not be null.");

        Polar soln = new Polar(a.modulus() / b.modulus(), a.phase() - b.phase());

        if(a instanceof Polar && b instanceof Polar)
            return soln;

        return soln.toComplexRect();
    }

    /**
     * Divides a complex number by a real number and returns the result.
     * <p>
     * This method treats the real number {@code b} as a complex number with
     * magnitude {@code b} and phase {@code 0}, then calls
     * {@link #divide(ComplexNumber, ComplexNumber)} to perform the division.
     *
     * @param a the complex number to be divided
     * @param b the real number to divide by
     * @return the resulting {@link ComplexNumber} after division
     */
    public static ComplexNumber divide(ComplexNumber a, double b) {
        return divide(a, new Polar(b, 0));
    }

    
    /**
     * Divides a real number by a complex number and returns the result.
     * <p>
     * This method treats the real number {@code a} as a complex number with
     * magnitude {@code a} and phase {@code 0}, then calls
     * {@link #divide(ComplexNumber, ComplexNumber)} to perform the division.
     *
     * @param a the real number to be divided
     * @param b the complex number to divide by
     * @return the resulting {@link ComplexNumber} after division
     */
    public static ComplexNumber divide(double a, ComplexNumber b) {
        return divide(new Polar(a, 0), b);
    }
    
    
    /**
     * Raises one complex number to the power of another and returns the result.
     * <p>
     * This method computes {@code a^b} for two {@link ComplexNumber} objects using
     * the polar (exponential) form of complex exponentiation:
     * <pre>
     *     a^b = rₐ^{b.real()} * e^{-b.imag() * θₐ} ∠ (b.imag() * ln(rₐ) + b.real() * θₐ)
     * </pre>
     * where {@code rₐ} and {@code θₐ} are the modulus and phase of {@code a}, respectively.
     * <p>
     * The result is represented as a {@link Polar} complex number if both inputs are
     * instances of {@link Polar}; otherwise, it is converted to a {@link Rectangular} form.
     *
     * @param a the base complex number
     * @param b the exponent complex number
     * @return the resulting {@link ComplexNumber} after exponentiation,
     *         returned as {@link Polar} if both inputs are polar, otherwise as {@link Rectangular}
     * @throws IllegalArgumentException if either {@code a} or {@code b} is {@code null}
     */
    public static ComplexNumber power(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input complex numbers must not be null.");

        double n1 = Math.pow(a.modulus(), b.real()) * Math.pow(Math.E, -b.imag()*a.phase());
        double n2 = b.imag() * Math.log(a.modulus()) + b.real() * a.phase();
        Polar soln = new Polar(n1, n2);

        if(a instanceof Polar && b instanceof Polar)
            return soln;
        
        return soln.toComplexRect();
    }

    /**
     * Raises a complex number to a real power and returns the result.
     * <p>
     * This method treats the real number {@code b} as a complex number with
     * magnitude {@code b} and phase {@code 0}, then calls
     * {@link #power(ComplexNumber, ComplexNumber)} to perform the computation.
     *
     * @param a the base complex number
     * @param b the real-number exponent
     * @return the resulting {@link ComplexNumber} after exponentiation
     */
    public static ComplexNumber power(ComplexNumber a, double b) {
        return power(a, new Polar(b, 0));
    }
    
    /**
     * Raises a real number to a complex power and returns the result.
     * <p>
     * This method treats the real number {@code a} as a complex number with
     * magnitude {@code a} and phase {@code 0}, then calls
     * {@link #power(ComplexNumber, ComplexNumber)} to perform the computation.
     *
     * @param a the real-number base
     * @param b the complex-number exponent
     * @return the resulting {@link ComplexNumber} after exponentiation
    */
    public static ComplexNumber power(double a, ComplexNumber b) {
        return power(new Polar(a, 0), b);
    }

    /**
     * Computes the principal square root of a complex number.
     * <p>
     * This method returns the square root of the given complex number {@code z}
     * by raising it to the power of 0.5 using
     * {@link #power(ComplexNumber, double)}.
     *
     * @param z the complex number whose square root is to be computed
     * @return the principal square root of {@code z} as a {@link ComplexNumber}
     */
    public static ComplexNumber sqrt(ComplexNumber z) {
        return power(z, 0.5);
    }

    /**
     * Computes the sine of a complex number.
     * <p>
     * This method evaluates the sine of the given complex number {@code z} using
     * the complex exponential definition:
     * <pre>
     *     sin(z) = (e^(i*z) - e^(-i*z)) / (2i)
     * </pre>
     * where {@code i} is the imaginary unit.
     *
     * @param z the complex number whose sine is to be computed
     * @return the sine of {@code z} as a {@link ComplexNumber}
     */
    public static ComplexNumber sin(ComplexNumber z) {
        ComplexNumber z1 = power(Math.E, multiply(I, z));
        ComplexNumber z2 = power(Math.E, multiply(-1, I, z));

        return divide(subtract(z1, z2), multiply(2, I));
    }

    /**
     * Computes the cosine of a complex number.
     * <p>
     * This method evaluates the cosine of the given complex number {@code z} using
     * the complex exponential definition:
     * <pre>
     *     cos(z) = (e^(i*z) + e^(-i*z)) / (2)
     * </pre>
     * where {@code i} is the imaginary unit.
     *
     * @param z the complex number whose sine is to be computed
     * @return the cosine of {@code z} as a {@link ComplexNumber}
     */
    public static ComplexNumber cos(ComplexNumber z) {
        ComplexNumber z1 = power(Math.E, multiply(I, z));
        ComplexNumber z2 = power(Math.E, multiply(-1, I, z));

        return divide(add(z1, z2), 2);
    }

    /**
     * Computes the tangent of a complex number.
     * <p>
     * This method evaluates the tangent of the given complex number {@code z} as
     * the ratio of its sine and cosine:
     * <pre>
     *     tan(z) = sin(z) / cos(z)
     * </pre>
     *
     * @param z the complex number whose tangent is to be computed
     * @return the tangent of {@code z} as a {@link ComplexNumber}
     */
    public static ComplexNumber tan(ComplexNumber z) {
        return divide(sin(z), cos(z));
    }

    /**
     * Computes the natural logarithm of a complex number.
     * <p>
     * This method returns the principal value of the natural logarithm of the
     * complex number {@code z}, given by:
     * <pre>
     *     log(z) = ln(|z|) + i * phase(z)
     * </pre>
     * where {@code |z|} is the modulus and {@code phase(z)} is the argument (phase) of {@code z}.
     * <p>
     * If the input {@code z} is an instance of {@link Polar}, the result is returned
     * in polar form; otherwise, it is returned in rectangular form.
     *
     * @param z the complex number whose natural logarithm is to be computed
     * @return the natural logarithm of {@code z} as a {@link ComplexNumber}
     */
    public static ComplexNumber log(ComplexNumber z) {
        ComplexNumber soln = new Rectangular(Math.log(z.modulus()), z.phase());

        if(z instanceof Polar)
            return soln.toComplexPolar();

        return soln.toComplexRect();
    }

    /**
     * Computes the inverse sine (arcsine) of a complex number.
     * <p>
     * This method evaluates the arcsine of the given complex number {@code z} using
     * the standard complex formula:
     * <pre>
     *     asin(z) = -i * ln(i*z + √(1 - z²))
     * </pre>
     * where {@code i} is the imaginary unit.
     *
     * @param z the complex number whose arcsine is to be computed
     * @return the arcsine of {@code z} as a {@link ComplexNumber}
     */
    public static ComplexNumber asin(ComplexNumber z) {
        ComplexNumber z1 = sqrt(subtract(1, power(z, 2))); // √(1 - z²)

        return multiply(-1, I, log(add(multiply(I, z), z1))); // -i*ln[iz + √(1 - z²)]
    }

    /**
     * Computes the inverse cosine (arccosine) of a complex number.
     * <p>
     * This method evaluates the arccosine of the given complex number {@code z} using
     * the standard complex formula:
     * <pre>
     *     acos(z) = -i * ln(z + i * √(1 - z²))
     * </pre>
     * where {@code i} is the imaginary unit.
     *
     * @param z the complex number whose arccosine is to be computed
     * @return the arccosine of {@code z} as a {@link ComplexNumber}
     * @throws IllegalArgumentException if {@code z} is {@code null}
     */
    public static ComplexNumber acos(ComplexNumber z) {
        ComplexNumber z1 = sqrt(subtract(1, power(z, 2))); // √(1 - z²)

        return multiply(-1, I, log(add(z, multiply(I, z1)))); // -i∙ln[z + i√(1 - z²)]
    }

    /**
     * Computes the inverse tangent (arctangent) of a complex number.
     * <p>
     * This method evaluates the arctangent of the given complex number {@code z} using
     * the standard complex formula:
     * <pre>
     *     atan(z) = (1 / 2i) * ln((1 + i*z) / (1 - i*z))
     * </pre>
     * where {@code i} is the imaginary unit.
     *
     * @param z the complex number whose arctangent is to be computed
     * @return the arctangent of {@code z} as a {@link ComplexNumber}
     * @throws IllegalArgumentException if {@code z} is {@code null}
     */
    public static ComplexNumber atan(ComplexNumber z) {
        ComplexNumber z1 = add(1, multiply(I, z)); // 1 + iz
        ComplexNumber z2 = subtract(1, multiply(I, z)); // 1 - iz

        return divide(log(divide(z1, z2)), multiply(I, 2)); // ln[(1+iz)/(1-iz)]/2i
    }

    public static Rectangular[] nthRootsOfUnity(int n) {
        Rectangular[] roots = new Rectangular[n];
        
        for(int i = 0; i < n; i++) {
            roots[i] = new Polar(1, 2*Math.PI*i/n).toComplexRect();
        }
        return roots;
    }
}