/**
 * @author Luis Goyone, Homard Parnacio, Reymond Villanueva
 * @version 1.0 03/10/2020
 */

import java.util.Scanner;

public class Main {

    static MainFacadePatternClass facade = new MainFacadePatternClass();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        index();
    }

    public static void index(){
        int choice;
        do {
            System.out.println("What do you want to do?\n" +
                    "1. RELATIONAL OPERATIONS\n" +
                    "2. RELATIONAL QUANTIFIERS\n" +
                    "3. EXIT");
            System.out.println("Enter your choice: ");
            choice = facade.choice(5);
            switch (choice) {
                case 1:
                    subMenuRelOps();
                    break;
                case 2:
                    subMenuRelQuantifier();
                    break;
                case 3:
                    System.exit(0);
                default:
            }

        } while (choice != 3) ;
    }

    public static void subMenuRelOps(){
        double value1,value2;
        boolean booleanValue1,booleanValue2;
        int choice;
        System.out.println("RELATIONAL OPERATIONS\n"+
                "1. Greater Than\n"+
                "2. Greater Than or Equal to\n"+
                "3. Lesser Than\n"+
                "4. Lesser Than or Equal to\n" +
                "5. Equal to\n" +
                "6. Not Equal to\n" +
                "7. And\n" +
                "8. Or\n" +
                "9. Not\n" +
                "10. Exit");
        choice = facade.choice(10);
        switch (choice){
            case 1:
                System.out.println("Enter first value: ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value: ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useGreaterThan(value1,value2);
                break;
            case 2:
                System.out.println("Enter first value: ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value: ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useGreaterThanOrEqualTo(value1,value2);
                break;
            case 3:
                System.out.println("Enter first value: ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value: ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useLesserThan(value1,value2);
                break;
            case 4:
                System.out.println("Enter first value: ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value: ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useLesserThanOrEqualTo(value1,value2);
                break;
            case 5:
                System.out.println("Enter first value: ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value: ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useEqualTo(value1,value2);
                break;
            case 6:
                System.out.println("Enter first value: ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value: ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useNotEqualTo(value1,value2);
                break;
            case 7:
                System.out.println("Enter first boolean value: ");
                booleanValue1 = Boolean.parseBoolean(input.nextLine());
                System.out.println("Enter second boolean value: ");
                booleanValue2 = Boolean.parseBoolean(input.nextLine());
                facade.useAnd(booleanValue1,booleanValue2);
                break;
            case 8:
                System.out.println("Enter first boolean value: ");
                booleanValue1 = Boolean.parseBoolean(input.nextLine());
                System.out.println("Enter second boolean value: ");
                booleanValue2 = Boolean.parseBoolean(input.nextLine());
                facade.useOr(booleanValue1,booleanValue2);
                break;
            case 9:
                System.out.println("Enter boolean value to negate: ");
                booleanValue1 = Boolean.parseBoolean(input.nextLine());
                facade.useNot(booleanValue1);
                break;
            case 10:
                index();
            default:
                System.out.println("Choice is not in the menu.");
        }
        enter_prompt();
    }

    public static void subMenuRelQuantifier(){
        double value1,value2, value3;
        boolean booleanValue1,booleanValue2;
        int choice;
        System.out.println("RELATIONAL QUANTIFIERS\n"+
                "1. At Least\n"+
                "2. At Most\n"+
                "3. Note());
                facade.useNotMoreThan(value1,value2);
                break;
            case 5:
   
            case 7:
                System.out.println("Enter value(Out of   value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter Less Than\n"+
                "4. Not More Than\n" +
                "5. Within Inclusive\n" +
                "6. Within Exclusive\n" +
                "7. Out of Range Inclusive\n" +
                "8. Out of Range Exclusive\n" +
                "9. Exclusive Or\n" +
                "10. Exit");
        choice = facade.choice(10);
        switch (choice){
            case 1:
                System.out.println("Enter first value(At least): ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value(At least): ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useAtLeast(value1,value2);
                break;
            case 2:
                System.out.println("Enter first value(At most): ");
             ());
                System.out.println("Enter second value(Not More Than): ");
                value2 = Double.parseDouble(input.nextLin second value(At most): ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useAtMost(value1,value2);
                break;
            case 3:
                System.out.println("Enter first value(Not Less Than): ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter second value(Not Less Than): ");
                value2 = Double.parseDouble(input.nextLine());
                facade.useNotLessThan(value1,value2);
                break;
            case 4:
                System.out.println("Enter first value(Not More Than): ");
                value1 = Double.parseDouble(input.nextLine Range Inclusive): ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter max valu             System.out.println("Enter value(Within Inclusive): ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter max value(Within Inclusive): ");
                value2 = Double.parseDouble(input.nextLine());
                System.out.println("Enter min value(Within Inclusive): ");
                value3 = Double.parseDouble(input.nextLine());
                facade.useWithinInclusive(value1,value2,value3);
                break;
            case 6:
                System.out.println("Enter value(Within Exclusive): ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter max value(Within Exclusive): ");
                value2 = Double.parseDouble(input.nextLine());
                System.out.println("Enter min value(Within Exclusive): ");
                value3 = Double.parseDouble(input.nextLine());
                facade.useWithinExclusive(value1,value2,value3);
                break;e(Out of Range Inclusive): ");
                value2 = Double.parseDouble(input.nextLine());
                System.out.println("Enter min value(Out of Range Inclusive): ");
                value3 = Double.parseDouble(input.nextLine());
       xclusive Or): ");
                booleanValue1 = Boolean.parseBoolean(input.nextLine());
                System.out.println("Enter second boolean value(Exclusive Or): ");
                booleanValue2 = Boolean.parseBoolean(input.nextLine());
                facade.useExclusiveOr(booleanValue1,booleanValue2);
                break;
            case 10:
                index();
            default:
                System.out.println("Choice is not in the menu.");
        }
        enter_prompt();
    }

    public static void enter_prompt() {
        System.out.print("Press ENTER to continue");
        try {         facade.useOutOfRangeInclusive(value1,value2,value3);
                break;
            case 8:
                System.out.println("Enter value(Out of Range Exclusive): ");
                value1 = Double.parseDouble(input.nextLine());
                System.out.println("Enter max value(Out of Range Exclusive): ");
                value2 = Double.parseDouble(input.nextLine());
                System.out.println("Enter min value(Out of Range Exclusive): ");
                value3 = Double.parseDouble(input.nextLine());
                facade.useOutOfRangeExclusive(value1,value2,value3);
                break;
            case 9:
                System.out.println("Enter first boolean value(E
            System.in.read(new byte[2]);    //Try to do the process
        } catch (Exception e) {
            e.printStackTrace();        //Catch the process if it fails or contains error
        }
        for (int loop = 0; loop < 5; loop++) System.out.println();
    }
}
