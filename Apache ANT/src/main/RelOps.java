/**
 * @author Luis Goyone, Homard Parnacio, Reymond Villanueva
 * @version 1.0 03/10/2020
 */
public class RelOps {
	
	public static boolean greaterThan(double x, double y){
		if (x > y){
			return true;
		} else {
			return false;
		}
	}

	public static boolean greaterThanOrEqualTo(double x, double y){
		if (x >= y){
			return true;
		} else {
			return false;
		}
	}

	public static boolean lesserThan(double x, double y){
		if (x < y){
			return true;
		} else {
			return false;
		}
	}

	public static boolean lesserThanOrEqualTo(double x, double y){
		if (x <= y){
			return true;
		} else {
			return false;
		}
	}

	public static boolean equalTo(double x, double y){
		if (x == y){
			return true;
		} else {
			return false;
		}
	}

	public static boolean notEqualTo(double x, double y){
		if (x != y){
			return true;
		} else {
			return false;
		}
	}

	public static boolean and(boolean relExpr1, boolean relExpr2){
		if (relExpr1 && relExpr2){
			return true;
		} else {
			return false;
		}
	}

	public static boolean or(boolean relExpr1, boolean relExpr2){
		if (relExpr1 || relExpr2){
			return true;
		} else {
			return false;
		}
	}

	public static boolean not(boolean relExpr1){
		return !relExpr1;
	}

}