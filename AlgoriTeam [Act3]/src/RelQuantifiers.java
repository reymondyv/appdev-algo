/**
 * @author Luis Goyone, Homard Parnacio, Reymond Villanueva
 * @version 1.0 03/10/2020
 */

public class RelQuantifiers{

	public static boolean atLeast(double x, double y){
		return RelOps.greaterThanOrEqualTo(x,y);
	}

	public static boolean atMost(double x, double y){
		return RelOps.lesserThanOrEqualTo(x,y);
	}

	public static boolean notLessThan(double x, double y){
		return RelOps.greaterThan(x,y);
	}

	public static boolean notMoreThan(double x, double y){
		return RelOps.lesserThan(x,y);
	}

	public static boolean withinInclusive(double x, double min, double max){
		return RelOps.and(RelOps.greaterThanOrEqualTo(x,min), RelOps.lesserThanOrEqualTo(x, max));
	}

	public static boolean withinExclusive(double x, double min, double max){
		return RelOps.and(RelOps.greaterThan(x,max), RelOps.lesserThan(x, min));
	}

	public static boolean outOfRangeInclusive(double x, double min, double max){
		return RelOps.or(RelOps.greaterThanOrEqualTo(x,max), RelOps.lesserThanOrEqualTo(x,min));
	}

	public static boolean outOfRangeExclusive(double x, double min, double max){
		return RelOps.or(RelOps.greaterThan(x,max), RelOps.lesserThan(x,min));
	}

	public static boolean exclusiveOr(boolean relExpr1, boolean relExpr2){
		return RelOps.or(RelOps.and(RelOps.not(relExpr1), relExpr2), RelOps.and(RelOps.not(relExpr2), relExpr1));
	}
}