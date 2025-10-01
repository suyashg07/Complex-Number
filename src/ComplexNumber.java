/**
 * @author Suyash Gupta
 */

public abstract class ComplexNumber {

    public abstract double real();
    public abstract double imag();
    public abstract double modulus();
    public abstract double phase();
    public abstract ComplexNumber conjugate();
    public abstract ComplexNumber inverse();
    public abstract Rectangular toComplexRect();
    public abstract Polar toComplexPolar();

    /**
     * Returns the sum of two complex numbers, both in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a + b</i> as a complex number in rectangular form.
     */
    public static Rectangular PlusC(Rectangular a, Rectangular b) {
        return new Rectangular(a.real() + b.real(), a.imag() + b.imag());
    }

    /**
     * Returns the sum of two complex numbers, the first in rectangular
     * and the other in polar form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a + b</i> as a complex number in rectangular form.
     */
    public static Rectangular PlusC(Rectangular a, Polar b) {
        return PlusC(a, b.toComplexRect());
    }

    /**
     * Returns the sum of two complex numbers, the first in polar
     * and the other in rectangular form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a + b</i> as a complex number in rectangular form.
     */
    public static Rectangular PlusC(Polar a, Rectangular b) {
        return PlusC(b, a);
    }

    /**
     * Returns the sum of two complex numbers, both in polar form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a + b</i> as a complex number in polar form.
     */
    public static Polar PlusC(Polar a, Polar b) {
        return PlusC(a.toComplexRect(), b.toComplexRect()).toComplexPolar();
    }

    /**
     * Returns the sum of a complex number in rectangular form and a real number,
     * in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a + b</i> as a complex number in rectangular form
     */
    public static Rectangular PlusC(Rectangular a, double b) {
        return PlusC(a, new Rectangular(b, 0));
    }

    /**
     * Returns the sum of a real number and a complex number of rectangular form.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a + b</i> as a complex number in rectangular form.
     */
    public static Rectangular PlusC(double a, Rectangular b) {
        return PlusC(b, a);
    }

    /**
     * Returns the sum of a complex number of polar form and a real number.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a + b</i> as a complex number in polar form.
     */
    public static Polar PlusC(Polar a, double b) {
        return PlusC(a.toComplexRect(), new Rectangular(b,0)).toComplexPolar();
    }

    /**
     * Returns the sum of a real number and a complex number of polar form.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a + b</i> as a complex number in polar form. 
     */
    public static Polar PlusC(double a, Polar b) {
        return PlusC(b, a);
    }

    /**
     * Returns the subtraction of two complex numbers in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a - b</i> as a complex number in rectangular form.
     */
    public static Rectangular MinusC(Rectangular a, Rectangular b) {
        return new Rectangular(a.real() - b.real(), a.imag() - b.imag());
    }

    /**
     * Returns the subtraction of a complex number in polar form from
     * a complex number in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a - b</i> as a complex number in rectangular form.
     */
    public static Rectangular MinusC(Rectangular a, Polar b) {
        return MinusC(a, b.toComplexRect());
    }

    /**
     * Returns the subtraction of a complex number in rectangular form
     * from a complex number in polar form.
     * 
     * @param   a   a complex number in poar form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a - b</i> as a complex number in rectangular form.
     */
    public static Rectangular MinusC(Polar a, Rectangular b) {
        return MinusC(a.toComplexRect(), b);
    }

    /**
     * Returns the subtraction of two complex numbers in polar form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a - b</i> as a complex number in polar form.
     */
    public static Polar MinusC(Polar a, Polar b) {
        return MinusC(a.toComplexRect(), b.toComplexRect()).toComplexPolar();
    }

    /**
     * Return the subtraction of a real number from a complex number 
     * in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a - b</i> as a complex number in rectangular form.
     */
    public static Rectangular MinusC(Rectangular a, double b) {
        return new Rectangular(a.real() - b, a.imag());
    }

    /**
     * Returns the subtraction of a complex number in rectangular form from a 
     * real number.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a - b</i> as a complex number in rectangular form.
     */
    public static Rectangular MinusC(double a, Rectangular b) {
        return new Rectangular(a - b.real(), -b.imag());
    }

    /**
     * Returns the subtraction of a real number from a complex number
     *  in polar form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a - b</i> as a complex number in polar form.
     */
    public static Polar MinusC(Polar a, double b) {
        return MinusC(a.toComplexRect(), b).toComplexPolar();
    }

    /**
     * Returns the subtraction of a complex number in polar form 
     * from a real number.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a - b</i> as a complex number in polar form.
     */
    public static Polar MinusC(double a, Polar b) {
        return MinusC(a, b.toComplexRect()).toComplexPolar();
    }

    /**
     * Returns the product of two complex numbers in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a × b</i> as a complex number in rectangular form.
     */
    public static Rectangular TimesC(Rectangular a, Rectangular b) {
        return new Rectangular(a.real()*b.real() - a.imag()*b.imag(), a.real()*b.imag() + a.imag()*b.real());
    }

    /**
     * Returns the product of a complex number in rectangular form
     * and a complex number in polar form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a × b</i> as a complex number in rectangular form.
     */
    public static Rectangular TimesC(Rectangular a, Polar b) {
        return TimesC(a, b.toComplexRect());
    }

    /**
     * Returns the product of a complex number in polar form and
     * a complex number in rectangular form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a × b</i> as a complex number in polar form.
     */
    public static Rectangular TimesC(Polar a, Rectangular b) {
        return TimesC(b, a);
    }

    /**
     * Returns the product of two complex numbers in polar form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a × b</i> as a complex number in polar form.
     */
    public static Polar TimesC(Polar a, Polar b) {
        return new Polar(a.modulus() * b.modulus(), a.phase() + b.phase());
    }

    /**
     * Returns the product of a complex number in rectangular form
     * and a real number.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a × b</i> as a complex number in rectangular form.
     */
    public static Rectangular TimesC(Rectangular a, double b) {
        return new Rectangular(a.real() * b, a.imag() * b);
    }

    /**
     * Returns the product of a real number and a complex number in
     * rectangular form.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a × b</i> as a complex number in rectangular form.
     */
    public static Rectangular TimesC(double a, Rectangular b) {
        return TimesC(b, a);
    }

    /**
     * Returns the product of a complex number in polar form and a real number.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a × b</i> as a complex number in polar form.
     */
    public static Polar TimesC(Polar a, double b) {
        return new Polar(a.modulus() * b, a.phase());
    }

    /**
     * Returns the product of a real number and a complex number in polar form.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a × b</i> as a complex number in polar form.
     */
    public static Polar TimesC(double a, Polar b) {
        return TimesC(b, a);
    }

    /**
     * Returns the quotient of two complex numbers in rectangular form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of <i>a / b</i> as a complex number in rectangular form.
     */
    public static Rectangular DivideC(Rectangular a, Rectangular b) {
        return new Polar(a.modulus() / b.modulus(), a.phase() - b.phase()).toComplexRect();
    }

    /**
     * Returns the quotient of a complex number in rectangular form
     * and a complex number in polar form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a / b</i> as a complex number in rectangular form.
     */
    public static Rectangular DivideC(Rectangular a, Polar b) {
        return DivideC(a, b.toComplexRect());
    }

    /**
     * Returns the quotient of a cmplex number in polar form and a
     * complex number in rectangular form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex numer in rectangular form.
     * 
     * @return  the value of <i>a / b</i> as a complex number in recangular form.
     */
    public static Rectangular DivideC(Polar a, Rectangular b) {
        return DivideC(a.toComplexRect(), b);
    }

    /**
     * Returns the quotient of two complex numbers in polar form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a / b</i> as a complex number in polar form.
     */
    public static Polar DivideC(Polar a, Polar b) {
        return new Polar(a.modulus() / b.modulus(), a.phase() - b.phase());
    }

    /**
     * Returns the quotient of a complex number in rectangular form
     * and a real number.
     * 
     * @param   a   a complex number in recatngular form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a / b</i> as a complex number in rectangular form.
     */
    public static Rectangular DivideC(Rectangular a, double b) {
        return DivideC(a, new Rectangular(b, 0));
    }

    /**
     * Returns the quotient of a real number and a complex number in 
     * rectangular form.
     * 
     * @param   a   a real number
     * @param   b   a complex number in rectagular form.
     * 
     * @return  the value of <i>a / b</i> as a complex number in rectangular form.
     */
    public static Rectangular DivideC(double a, Rectangular b) {
        return DivideC(new Rectangular(a, 0), b);
    }

    /**
     * Returns the quotient of a complex number in polar form and a real number.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a real number.
     * 
     * @return  the value of <i>a / b</i> as a complex number in polar form.
     */
    public static Polar DivideC(Polar a, double b) {
        return new Polar(a.modulus() / b, a.phase());
    }

    /**
     * Returns the quotient of a real number and a complex number in polar form.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of <i>a / b</i> as a complex number in polar form.
     */
    public static Polar DivideC(double a, Polar b) {
        return new Polar(a / b.modulus(), -b.phase());
    }
    
    /**
     * Raises the power of a complex number in rectangular form to another
     * complex number in rectangular form. Special case:
     * <ul>><li>if the base is 0, the result will be NaN + NaNi.</li></ul>
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of a ^ b as a complex number in rectangular form.
     */
    public static Rectangular power(Rectangular a, Rectangular b) {
        return new Polar(Math.pow(Math.E, b.real() * Math.log(a.modulus()) - b.imag() * a.phase()), b.real() * a.phase() + b.imag() * Math.log(a.modulus())).toComplexRect();
        // Rectangular z = TimesC(new Rectangular(Math.log(a.mag()), a.phase()), b);
        // return new Polar(Math.pow(Math.E, z.real()), z.imag()).toComplexRect();
    }

    /**
     * Raises the power of a complex number in rectangular form to a 
     * complex number in polar form.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of a ^ b as a complex number in rectangular form.
     */
    public static Rectangular power(Rectangular a, Polar b) {
        return power(a, b.toComplexRect());
    }

    /**
     * Raises the power of a complex number in polar form to a 
     * complex number in rectangular form.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of a ^ b as a complex number in rectangular form.
     */
    public static Rectangular power(Polar a, Rectangular b) {
        return power(a.toComplexRect(), b);
    }

    /**
     * Raises the power of a complex number in polar form to another
     * complex number in polar form.
     * 
     * @param   a   a complex number in polar form.   
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of a ^ b as a complex number in polar form.
     */
    public static Polar power(Polar a, Polar b) {
        return power(a.toComplexRect(), b.toComplexRect()).toComplexPolar();
    }

    /**
     * Raises the power of a complex number in rectangular form to a 
     * real number.
     * 
     * @param   a   a complex number in rectangular form.
     * @param   b   a real number.
     * 
     * @return  the value of a ^ b as a complex number in rectangular form.
     */
    public static Rectangular power(Rectangular a, double b) {
        return new Polar(Math.pow(a.modulus(), b), a.phase() * b).toComplexRect();
    }

    /**
     * Raises the power of a real number to a complex number in 
     * rectangular form.
     * 
     * @param   a   a real number.
     * @param   b   a complex number in rectangular form.
     * 
     * @return  the value of a ^ b as a complex number in rectangular form.
     */
    public static Rectangular power(double a, Rectangular b) {
        return new Polar(Math.pow(a, b.real()), b.imag() * Math.log(a)).toComplexRect();
    }

    /**
     * Raises the power of a complex number in polar form
     * to a real number.
     * 
     * @param   a   a complex number in polar form.
     * @param   b   a real number.
     * 
     * @return  the value of a ^ b as a complex number in polar form.
     */
    public static Polar power(Polar a, double b) {
        return new Polar(Math.pow(a.modulus(), b), a.phase() * b);
    }
    
    /**
     * Raises a real number to the power of a complex number in 
     * polar form.
     * 
     * @param   a   a real number
     * @param   b   a complex number in polar form.
     * 
     * @return  the value of a ^ b as a complex number in polar form.
     */
    public static Polar power(double a, Polar b) {
        return power(a, b.toComplexRect()).toComplexPolar();
    }

    public static Rectangular sin(ComplexNumber z) {
        //return DivideC(MinusC(power(Math.E, TimesC(new Rectangular(0, 1), z.toComplexRect())), power(Math.E, TimesC(new Rectangular(0, -1), z.toComplexRect()))), new Rectangular(0, 2));
        return DivideC(MinusC(new Polar(Math.pow(Math.E, -z.imag()), z.real()), new Polar(Math.pow(Math.E, z.imag()), -z.real())), new Rectangular(0, 2));
    }

    public static Rectangular cos(ComplexNumber z) {
        //return DivideC(PlusC(power(Math.E, TimesC(new Rectangular(0, 1), z.toComplexRect())), power(Math.E, TimesC(new Rectangular(0, -1), z.toComplexRect()))), 2);
        return PlusC(new Polar(Math.pow(Math.E, -z.imag())/2, z.real()), new Polar(Math.pow(Math.E, z.imag())/2, -z.real())).toComplexRect();
    }

    public static Rectangular tan(ComplexNumber z) {
        return DivideC(sin(z), cos(z));
    }

    public static Rectangular log(ComplexNumber z) {
        return new Rectangular(Math.log(z.modulus()), z.phase());
    }

    public static Rectangular asin(ComplexNumber z) {
        return DivideC(log(PlusC(TimesC(z.toComplexRect(), new Rectangular(0,1)), power(MinusC(1, power(z.toComplexRect(), 2)), 0.5))), new Rectangular(0,1));
    }

    public static Rectangular acos(ComplexNumber z) {
        return DivideC(log(PlusC(z.toComplexRect(), power(MinusC(power(z.toComplexRect(), 2), 1), 0.5))), new Rectangular(0, 1));
    }

    public static Rectangular atan(ComplexNumber z) {
        return DivideC(log(DivideC(PlusC(1, TimesC(new Rectangular(0, 1), z.toComplexRect())), MinusC(1, TimesC(new Rectangular(0,1), z.toComplexRect())))), new Rectangular(0, 2));
    }
}
