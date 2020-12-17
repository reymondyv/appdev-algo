
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {

    private char variable;
    private List<Term> terms;

    private ArrayList<Integer> anotherCoefficient = new ArrayList<>();
    private ArrayList<Integer> anotherExponent = new ArrayList<>();

    private List<Term> anotherTerm = new LinkedList<>();

    /**
     * This method is used to initialized the fields of the class
     * @param variable This is the first parameter to Polynomial method
     * @param terms This is the second parameter to Polynomial method
     */
    public Polynomial(char variable, List<Term> terms) {
        this.variable = variable;
        this.terms = terms;
    }

    /**
     * This method is to add polynomials.
     * @param other is sa polynomial to be added to this polynomial
     * @return Polynomial + other Polynomial
     */
    public Polynomial add(Polynomial other) {

        this.sortByExponent();
        if (variable == other.variable) {
            int x=0,y=0;
            while (x < terms.size() && y < other.terms.size()) {
                if (terms.get(x).getExponent() == other.terms.get(y).getExponent()) {
                    anotherTerm.add(new Term(terms.get(x).getCoefficient() + other.terms.get(y).getCoefficient(), terms.get(x).getExponent()));
                    x++;
                    y++;
                } else if (terms.get(x).getExponent() < other.terms.get(y).getExponent()) {
                    anotherTerm.add(new Term(terms.get(x).getCoefficient(), terms.get(x).getExponent()));
                   x++;
                } else {
                    anotherTerm.add(new Term(other.terms.get(y).getCoefficient(), other.terms.get(y).getExponent()));
                    y++;
                }
                while (x < terms.size()){
                    anotherTerm.add(new Term(terms.get(x).getCoefficient(),terms.get(x).getExponent()));
                    x++;
                }

                while (y < other.terms.size()){
                    anotherTerm.add(new Term(other.terms.get(y).getCoefficient(),other.terms.get(y).getExponent()));
                    y++;
                }
            }
            return new Polynomial(variable, anotherTerm).addLikeTerms();
        }
        throw new IllegalArgumentException("Error");
    }


    /**
     * This method is to subtract polynomials.
     * @param other is a polynomial to be subtracted to this polynomial
     * @return Polynomial - other Polynomial
     */
    public Polynomial subtract(Polynomial other) {

        this.sortByExponent();
        if (variable == other.variable) {
            int x=0,y=0;
            while (x < terms.size() && y < other.terms.size()) {
                if (terms.get(x).getExponent() == other.terms.get(y).getExponent()) {
                    anotherTerm.add(new Term(terms.get(x).getCoefficient() - other.terms.get(y).getCoefficient(), terms.get(x).getExponent()));
                    x++;
                    y++;
                } else if (terms.get(x).getExponent() < other.terms.get(y).getExponent()) {
                    anotherTerm.add(new Term(terms.get(x).getCoefficient(), terms.get(x).getExponent()));
                    x++;
                } else {
                    anotherTerm.add(new Term(other.terms.get(y).getCoefficient(), other.terms.get(y).getExponent()));
                    y++;
                }
                while (x < terms.size()){
                    anotherTerm.add(new Term(terms.get(x).getCoefficient(),terms.get(x).getExponent()));
                    x++;
                }

                while (y < other.terms.size()){
                    anotherTerm.add(new Term(other.terms.get(y).getCoefficient(),other.terms.get(y).getExponent()));
                    y++;
                }
            }
            return new Polynomial(variable, anotherTerm).subtractLikeTerms();
        }
        throw new IllegalArgumentException("Error");
    }

    /**
     * This method multiplies polynomials and returns this polynomial * other polynomial
     * @param other is a polynomial to be multiplied to another polynomial
     * @return Polynomial * Polynomial other
     */
    public Polynomial multiply(Polynomial other) {
        if (variable == other.variable) {
            for (int i =0; i < terms. size(); i++) {
                for (int j = 0; j < other.terms.size(); j++) {
                    anotherCoefficient.add(terms.get(i).getCoefficient() * other.terms.get(j).getCoefficient());
                    anotherExponent.add(terms.get(i).getExponent() + other.terms.get(j).getExponent());
                }
            } for (int k = 0; k < anotherCoefficient.size(); k++) {
                anotherTerm.add(new Term(anotherCoefficient.get(k), anotherExponent.get(k)));
            }
            return new Polynomial(variable, anotherTerm).addLikeTerms();
        }

        throw new IllegalArgumentException("Error");
    }

    /**
     * This method divides polynomials and returns this polynomial / other polynomial
     * @param other is a polynomial to be divided to a polynomial
     * @return Polynomial / Polynomial other
     */
    public Polynomial divide(Polynomial other) {
        if (variable == other.variable) {
            for (int i = 0; i < terms.size(); i++) {
                for (int j = 0; j < other.terms.size(); j++) {
                    if ((terms.get(i).getCoefficient() == 0) && (other.terms.get(j).getExponent() == 0))
                        throw new RuntimeException("Divide by zero Polynomial");

                    anotherCoefficient.add(terms.get(i).getCoefficient() / other.terms.get(j).getCoefficient());
                    anotherExponent.add(terms.get(i).getExponent() - other.terms.get(j).getExponent());
                }
            }
        }
        for (int k = 0; k < anotherCoefficient.size(); k++) {
            anotherTerm.add(new Term(anotherCoefficient.get(k), anotherExponent.get(k)));
        }
        return new Polynomial('x', anotherTerm);
    }

    /**
     * This method will evaluate the value of polynomial to the substituted value of x.
     * @param x the value of the function x to be substituted
     * @return a double–type value which is the multiplied value of x that is substituted in the
     * polynomial
     */
    public double evaluate(double x ){
        double function = 0;
        for(int i = 0; i < terms.size(); i++) {
            if (terms.get(i).getExponent() != 0) {
                function += Math.pow((terms.get(i).getCoefficient() * x), terms.get(i).getExponent());
            }
            else {
                function += terms.get(i).getCoefficient();
            }
        }
        return function;
    }

    /**
     * Returns a string representation of this polynomial
     * @return a string representation of this polynomial with the format (14x^3 + 5x^2 + 5x + 20)
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < terms.size(); i++) {
            if (terms.get(i).getExponent() == 0) {
                if (terms.get(i).getCoefficient() < 0) {
                    s += " - " + Math.abs(terms.get(i).getCoefficient());
                } else if (terms.get(i).getCoefficient() > 0) {
                    s += " + " + terms.get(i).getCoefficient();
                } else if (terms.get(i).getCoefficient() == 0){
                    s += "";
                }
            } else if (terms.get(i).getExponent() > 0) {
                if (s.equals("")) {
                    if ((terms.get(i).getCoefficient() == 1 || terms.get(i).getCoefficient() == -1 || terms.get(i).getCoefficient() == 0) && (terms.get(i).getExponent() == 1)) {
                        s += "" + variable;
                    } else if (terms.get(i).getCoefficient() == 1 || terms.get(i).getCoefficient() == -1) {
                        s += "" + variable + "^" + (terms.get(i).getExponent());
                    } else if (terms.get(i).getCoefficient() == 0){
                        s += "" ;
                    } else if (terms.get(i).getExponent() == 1){
                        s += "" + terms.get(i).getCoefficient() + variable;
                    } else {
                        s += "" + terms.get(i).getCoefficient() + variable + "^" + (terms.get(i).getExponent());
                    }
                } else if (!(s.equals("")) && (terms.get(i).getCoefficient() < 0)) {
                    if ((terms.get(i).getCoefficient() == -1) && (terms.get(i).getExponent() == 1)) {
                        s += " - " + variable;
                    } else if (terms.get(i).getExponent() == 1) {
                        s += " - " + Math.abs(terms.get(i).getCoefficient()) + variable;
                    } else if (terms.get(i).getCoefficient() == -1) {
                        s += " - " + variable + "^" + (terms.get(i).getExponent());
                    } else {
                        s += " - " + Math.abs(terms.get(i).getCoefficient()) + variable + "^" + (terms.get(i).getExponent());
                    }
                } else if (!(s.equals("")) && (terms.get(i).getCoefficient() >= 0)) {
                    if ((terms.get(i).getCoefficient() <= 1) && (terms.get(i).getExponent() == 1)) {
                        s += " + " + variable;
                    } else if (terms.get(i).getExponent() == 1) {
                        s += " + " + (terms.get(i).getCoefficient()) + variable;
                    } else if (terms.get(i).getCoefficient() == 1) {
                        s += " + " + variable + "^" + (terms.get(i).getExponent());
                    } else if (terms.get(i).getCoefficient() == 0){
                        s += " + " + variable + "^" + (terms.get(i).getExponent());
                    } else {
                        s += " + " + (terms.get(i).getCoefficient()) + variable + "^" + (terms.get(i).getExponent());
                    }
                }
            }
        }
        return s;
    }

    /**
     * This method is to add the terms with the same exponents in an array of Term.
     * @return the final added like term of Polynomial
     */
    private Polynomial addLikeTerms () {

        this.sortByExponent();
        for (int i = 0; i < terms.size(); i++) {
            int coefficient = terms.get(i).getCoefficient();

            for (int j = i + 1; j < terms.size(); j++) {
                if (terms.get(i).getExponent() == terms.get(j).getExponent())
                    coefficient += terms.get(j).getCoefficient();

            } if (i != 0) {
                if (terms.get (i-1).getExponent() != terms.get(i).getExponent())
                    anotherTerm.add(new Term (coefficient, terms.get(i).getExponent()));

            } else if (i == terms.size() -1) {
                anotherTerm.add(new Term (coefficient, terms.get(i).getExponent()));

            } else {
                anotherTerm.add(new Term (coefficient, terms.get(i).getExponent()));
            }
        }
        return new Polynomial (variable, anotherTerm);
    }

    /**
     * This method is to minu the terms with the same exponents in an array of Term.
     * @return the final subtracted like term of Polynomial
     */
    private Polynomial subtractLikeTerms () {

        this.sortByExponent();
        for (int i = 0; i < terms.size(); i++) {
            int coefficient = terms.get(i).getCoefficient();

            for (int j = i + 1; j < terms.size(); j++) {
                if (terms.get(i).getExponent() == terms.get(j).getExponent())
                    coefficient -= terms.get(j).getCoefficient();

            } if (i != 0) {
                if (terms.get(i-1).getExponent() != terms.get(i).getExponent())
                    anotherTerm.add(new Term (coefficient, terms.get(i).getExponent()));

            } else if (i == terms.size() -1) {
                anotherTerm.add(new Term (coefficient, terms.get(i).getExponent()));

            } else {
                anotherTerm.add(new Term (coefficient, terms.get(i).getExponent()));
            }
        }
        return new Polynomial (variable, anotherTerm);
    }

    /**
     * This method sorts the polynomials according to its exponent from ascending to descending order
     */
    public void sortByExponent() {
        int minIndex;
        for (int i = 0; i < terms.size() - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < terms.size(); j++) {
                if (terms.get(minIndex).getExponent() < terms.get(j).getExponent()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Term temp = terms.get(minIndex);
                terms.set(minIndex, terms.get(i));
                terms.set(i, temp);
            }
        }
    }
} //end of Polynomial class