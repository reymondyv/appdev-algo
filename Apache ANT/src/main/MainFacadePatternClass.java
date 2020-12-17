/**
 * @author Luis Goyone, Homard Parnacio, Reymond Villanueva
 * @version 1.0 03/10/2020
 */

import java.util.Scanner;

public class MainFacadePatternClass {
    static Scanner sc = new Scanner(System.in);

    public MainFacadePatternClass(){

    }

    public void useGreaterThan(double x, double y){
        if(!RelOps.greaterThan(x,y)){
            System.out.println(x+" is not greater than "+y);
        } else {
            System.out.println(x+" is greater than "+y);
        }
    }

    public void useGreaterThanOrEqualTo(double x, double y){
        if(!RelOps.greaterThanOrEqualTo(x,y)) {
            System.out.println(x+" is not greater than or equal to "+y);
        } else {
            System.out.println(x+" is greater than or equal to "+y);
        }
    }

    public void useLesserThan(double x, double y){
        if(!RelOps.lesserThan(x,y)) {
            System.out.println(x+" is not lesser than "+y);
        } else {
            System.out.println(x+" is lesser than "+y);
        }
    }

    public void useLesserThanOrEqualTo(double x, double y){
        if(!RelOps.lesserThanOrEqualTo(x,y)) {
            System.out.println(x+" is not lesser than or equal to "+y);
        } else {
            System.out.println(x+" is lesser than or equal to "+y);
        }
    }

    public void useEqualTo(double x, double y){
        if(!RelOps.equalTo(x,y)) {
            System.out.println(x+" is not equal to "+y);
        } else {
            System.out.println(x+" is equal to "+y);
        }
    }

    public void useNotEqualTo(double x, double y){
        if(!RelOps.notEqualTo(x,y)) {
            System.out.println(x+" is equal to "+y);
        } else {
            System.out.println(x+" is not equal to "+y);
        }
    }

    public void useAnd(boolean relExpr1, boolean relExpr2){
        if(!RelOps.and(relExpr1,relExpr2)){
            System.out.println(relExpr1 + " && " + relExpr2 + " = FALSE");
        } else {
            System.out.println(relExpr1 + " && " + relExpr2 + " = TRUE");
        }
    }

    public void useOr(boolean relExpr1, boolean relExpr2){
        if(!RelOps.or(relExpr1,relExpr2)){
            System.out.println(relExpr1 + " || " + relExpr2 + " = FALSE");
        } else {
            System.out.println(relExpr1 + " || " + relExpr2 + " = TRUE");
        }
    }

    public void useNot(boolean relExpr1){
        if(RelOps.not(relExpr1)){
            System.out.println("!" + relExpr1 + " = TRUE");
        } else {
            System.out.println("!" + relExpr1 + " = FALSE");
        }
    }

    public void useAtLeast(double x, double y){
        if(!RelQuantifiers.atLeast(x,y)){
            System.out.println(x+" is not greater than or equal to "+y);
        } else {
            System.out.println(x+" is greater than or equal to "+y);
        }
    }

    public void useAtMost(double x, double y){
        if(!RelQuantifiers.atMost(x,y)){
            System.out.println(x+" is not lesser than or equal to "+y);
        } else {
            System.out.println(x+" is lesser than or equal to "+y);
        }
    }

    public void useNotLessThan(double x, double y){
        if(!RelQuantifiers.notLessThan(x,y)){
            System.out.println(x+" is lesser than "+y);
        } else {
            System.out.println(x+" is not lesser than "+y);
        }
    }

    public void useNotMoreThan(double x, double y){
        if(!RelQuantifiers.notMoreThan(x,y)){
            System.out.println(x+" is not more than "+y);
        } else {
            System.out.println(x+" is more than "+y);
        }
    }

    public void useWithinInclusive(double x, double min, double max){
        if(!RelQuantifiers.withinInclusive(x,min, max)){
            System.out.println(x+" is not lesser than or equal to "+ max + " and not more than or equal to " +min );
        } else {
            System.out.println(x+" is lesser than or equal to "+ max + " and more than or equal to " +min );
        }
    }

    public void useWithinExclusive(double x, double min, double max){
        if(!RelQuantifiers.withinExclusive(x,min, max)){
            System.out.println(x+" is not more than "+ max + " and not less than " +min );
        } else {
            System.out.println(x+" is lesser than "+ max + " and more than " +min );
        }
    }

    public void useOutOfRangeInclusive(double x, double min, double max){
        if(!RelQuantifiers.outOfRangeInclusive(x,min, max)){
            System.out.println(x+" is not greater than or equal to "+ max + " or not less than or equal" +min );
        } else {
            System.out.println(x+" is greater than or equal to "+ max + " or less than or equal to " +min );
        }
    }

    public void useOutOfRangeExclusive(double x, double min, double max){
        if(!RelQuantifiers.outOfRangeExclusive(x,min, max)){
            System.out.println(x+" is not greater than "+ max + " or not less than " +min );
        } else {
            System.out.println(x+" is greater than "+ max + " or less than " +min );
        }
    }

    public void useExclusiveOr(boolean relExpr1, boolean relExpr2){
        if(!RelQuantifiers.exclusiveOr(relExpr1,relExpr2)){
            System.out.println(relExpr1+" and "+relExpr2+ " are either both true or false statements");
        } else {
            System.out.println(relExpr1+" and "+relExpr2+" is either true or false");
        }
    }

    public int choice(int max) {
        int userInp = 0;

        //It will loop if the user inputs invalid answers
        do {
            //Try to perform the statement inside the try. If it will contain error it will be go to catch
            try {
                System.out.println("Enter your choice 1-" + max + ": ");
                userInp = Integer.parseInt(sc.nextLine());
                if (!(userInp >= 1 && userInp <= max)) {
                    System.out.println("Please enter a choice 1-" + max + " only");
                }
            } catch (Exception e) {
                System.out.println("Error! Please enter a valid number");
            }

        } while (!(userInp >= 1 && userInp <= max));

        return userInp;
    }
}
