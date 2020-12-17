
public class Term {

    private int coefficient;
    private int exponent;

    /**
     * This method is used to initialized the fields of the class
     * @param coefficient int type for setting coefficient
     * @param exponent int type for setting exponent
     */
    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /**
     * Returns the coefficient
     * @return coefficient value
     */
    public int getCoefficient () {
        return coefficient;
    }

    /**
     * Returns the exponent
     * @return exponent value
     */
    public int getExponent () {
        return exponent;
    }

}