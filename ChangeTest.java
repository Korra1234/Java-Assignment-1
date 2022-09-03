/Author: Siyeshen Milen Govender
Purpose:User enter person name and change(how many times they want to), a Menu is displayed and they select an option for their desired calculation
 
Assumptions: The user understands English
             No spaces included when entering names 
Conditions on the form of Input: multiples of  will be recorded into the methods because of the setter. 
Conditions on the form of Output: values will only be in multiples of 5. 
 */
package changetest;

import java.util.Scanner;

public class ChangeTest {
    
    private static int noOfPersonEntered = 0; //allows to keep track of the number of users entered throughout all the methods if needed

    private static final Scanner kb = new Scanner(System.in);//allows this scanner object to be available for all methods
    private static final int DOLLAR_VALUE = 100;
    private static final int FIFTY_CENTS_VALUE = 50;
    private static final int TWENTY_FIVE_CENTS_VALUE = 25;
    private static final int TEN_CENTS_VALUE = 10;
    private static final int FIVE_CENTS_VALUE = 5;

    public static void main(String[] args) {

        char number = 0;
        boolean new_person;

        //Creating array of objects. 
        //First we declare the object array 'Change[]' and give it a name 'changeArray'
        //then we initialize '=' and type keyword 'new' and then 'Baby' with how many objects in the square brackets[]. 
        Change[] changeArray = new Change[100];
        StudentInfo();
        readInput(changeArray);
        //hardCoding(changeArray); 
        processChange(changeArray);

        while (number != '6') //while the user doesnt enter '6', it will keep looping
        {
            menuDisplay();
            switchCase(changeArray);
        }

    }

    public static void readInput(Change[] changeArray) {

        Scanner kbName = new Scanner(System.in);
        
        System.out.println("It is recommended to enter at least 10 records");

        int coin;
        String name;
        int i = 0;

        while (true) {
            changeArray[i] = new Change();
            System.out.println("enter person's name: ");
            
            name = kbName.nextLine();
            System.out.println("enter person's change amount: ");
            coin = kb.nextInt();
            while (!validateCoinValue(coin)) {
                System.out.println("invalid coin value: try again");
                System.out.println("enter person's change amount: ");
                coin = kb.nextInt();
            }
            addCustomer(changeArray, name, coin);
            
            i++;
            System.out.println("do you have more person to enter? Y/N");
            if (!kb.next().equalsIgnoreCase("Y")) {
                name = kb.nextLine();
                break;
            }
        }

    }

    public static void processChange(Change[] changeArray) {

        int rem;
        for (int i = 0; i < noOfPersonEntered; i++) {
            rem = changeArray[i].getChangeAmount();
            changeArray[i].setCoinHundred(rem / 100);
            rem %= 100;
            changeArray[i].setCoinFifty(rem / 50);
            rem %= 50;
            changeArray[i].setCoinTwentyFive(rem / 25);
            rem %= 25;
            changeArray[i].setCoinTen(rem / 10);
            rem %= 10;
            changeArray[i].setCoinFive(rem / 5);

        }
    }

    public static boolean validateCoinValue(int coin) {
        return (coin >= 0);
    }

    public static void menuDisplay() //Displays the menu options 
    {
        System.out.println("\n---- MAIN MENU ----");
        System.out.println("1. Enter a name and display change to be given for each denomination");
        System.out.println("2. Find the name with the largest amount and display change to be given for each denomination");
        System.out.println("3. Find the name with the smallest amount and display change to be given for each denomination");
        System.out.println("4. Calculate and display the total number of coins for each denomination");
        System.out.println("5. Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }

    public static void switchCase(Change[] changeArray) {

        int userChoice = kb.nextInt();

        //this calls other methods for the menu driven program's options
        switch (userChoice) {
            case 1:
                System.out.println("Please enter person name: ");
                displayChangeByName(kb.next(), changeArray);
                break;
            case 2:
                displayLargestChange(changeArray);
                break;
            case 3:
                displaySmallestChange(changeArray);
                break;
            case 4:
                displayTotalCoins(changeArray);
                break;
            case 5:
                displayTotalAmount(changeArray);
                break;
            case 6:
                System.out.println("You Quit the Program, Farewell");
                System.exit(0);

            default:
                System.err.println("error: you didn't select a valid number, try again");
        }

    }

    public static void displayChangeByName(String name, Change[] changeArray) { //calculate change to be given for each denomination 

        //int denom[] = new int[4]; //array to store denominations
        // boolean notFound = true;
        int index = findName(changeArray, name);
        if (index >= 0) {
            System.out.println("cutomer: ");
            System.out.println(name + " " + changeArray[index].getChangeAmount() + " cents");
            System.out.println("change:");
            if (changeArray[index].getCoinHundred() > 0) {
                System.out.println("1 dollar: " + changeArray[index].getCoinHundred());
            }

            if (changeArray[index].getCoinFifty() > 0) {
                System.out.println("50 cents: " + changeArray[index].getCoinFifty());
            }

            if (changeArray[index].getCoinTwentyFive() > 0) {
                System.out.println("25 cents: " + changeArray[index].getCoinTwentyFive());
            }

            if (changeArray[index].getCoinTen() > 0) {
                System.out.println("10 cents: " + changeArray[index].getCoinTen());
            }

            if (changeArray[index].getCoinFive() > 0) {
                System.out.println("5 cents: " + changeArray[index].getCoinFive());
            }
        } else {
            System.out.println("name: " + name);
            System.out.println("not found");
        }

    }

    public static void displayLargestChange(Change[] changeArray) {
//Variable to store array of denominations

        int i;
        int max = changeArray[0].getChangeAmount(); //Variable for finding minimum value amount
        int index = 0; //Variable for the index of record

        for (i = 1; i < noOfPersonEntered; i++) {
            if (changeArray[i].getChangeAmount() > max) {
                max = changeArray[i].getChangeAmount();
                index = i;
            }

        }
        System.out.println("Customer with the largest Change: ");
        displayChangeByName(changeArray[index].getPersonName(), changeArray);
    }

    public static void displaySmallestChange(Change[] changeArray) {
     

        int i;
        int min = changeArray[0].getChangeAmount(); //Variable for finding minimum value amount
        int index = 0; //Variable for the index of record

        for (i = 1; i < noOfPersonEntered; i++) {
            if (changeArray[i].getChangeAmount() < min) {
                min = changeArray[i].getChangeAmount();
                index = i;
            }

        }
        System.out.println("Customer with the smallest Change: ");
        displayChangeByName(changeArray[index].getPersonName(), changeArray);
    }

    public static void displayTotalCoins(Change[] changeArray) {
       
        int totalCoinHundred = 0;
        int totalCoinFifty = 0;
        int totalCoinTwentyFive = 0;
        int totalCoinTen = 0;
        int totalCoinFive = 0;

        for (int i = 0; i < noOfPersonEntered; i++) {
            
            totalCoinHundred = totalCoinHundred + changeArray[i].getCoinHundred();
            totalCoinFifty = totalCoinFifty + changeArray[i].getCoinFifty();
            totalCoinTwentyFive = totalCoinTwentyFive + changeArray[i].getCoinTwentyFive();
            totalCoinTen = totalCoinTen + changeArray[i].getCoinTen();
            totalCoinFive = totalCoinFive + changeArray[i].getCoinFive();
        }

        System.out.println("\nTotal Denomination Coins:");
        System.out.println("1 dollar: " + totalCoinHundred);
        System.out.println("50 cents: " + totalCoinFifty);
        System.out.println("25 cents: " + totalCoinTwentyFive); 
        System.out.println("10 cents: " + totalCoinTen);
        System.out.println("5 cents: " + totalCoinFive);
    }

    public static void displayTotalAmount(Change[] changeArray) {
        int totalAmount = 0;
        for (int i = 0; i < noOfPersonEntered; i++) {
            totalAmount = totalAmount + changeArray[i].getCoinHundred() * DOLLAR_VALUE
                    + changeArray[i].getCoinFifty() * FIFTY_CENTS_VALUE
                    + changeArray[i].getCoinTwentyFive() * TWENTY_FIVE_CENTS_VALUE
                    + changeArray[i].getCoinTen() * TEN_CENTS_VALUE
                    + changeArray[i].getCoinFive() * FIVE_CENTS_VALUE;

        }
        System.out.println("sum of amouunts of all demoniations: " + totalAmount);
    }

    public static void hardCoding(Change[] changeArray) {
        addCustomer(changeArray, "Siyeshen", 30);
        addCustomer(changeArray, "Jaron", 50);
        addCustomer(changeArray, "faiz", 10);
        addCustomer(changeArray, "noor", 15);
        addCustomer(changeArray, "shrek", 1);
        addCustomer(changeArray, "goku", 58);
        addCustomer(changeArray, "Siyeshen", 94);
        addCustomer(changeArray, "naruto", 92);
        addCustomer(changeArray, "ronaldo", 65);
        addCustomer(changeArray, "prenita", 215);

    }

    public static void addCustomer(Change[] changeArray, String name, int coin) {
        int index = findName(changeArray, name);
        if (index == -1) {
            changeArray[noOfPersonEntered] = new Change();//instantation, creating object of the class. So if person does not exist we need to store the person
            changeArray[noOfPersonEntered].setPersonName(name);
            if (coin % 5 == 0) {
                changeArray[noOfPersonEntered].setChangeAmount(coin);
            } else {
                changeArray[noOfPersonEntered].setChangeAmount(Change.getRoundCoinValue(coin));
            }
            noOfPersonEntered++;
        } else {
            System.out.println("the customer name already exists");

            
                changeArray[index].setChangeAmount(changeArray[index].getChangeAmount() + Change.getRoundCoinValue(coin));
            }
        }

    

    public static int findName(Change[] changeArray, String name) {
        int index = -1;
        for (int i = 0; i < noOfPersonEntered; i++) {
            if (changeArray[i].getPersonName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void StudentInfo() {
        System.out.println("student name: Siyeshen Milen Govender"); 
        System.out.println("student ID: 34443324");
        System.out.println("mode of enrollment: full time");
        System.out.println("lecturer name: Wayne Muller");
        System.out.println("tutorial attendance day and time: Monday 9:00 till 13:30\n\n");
    }
}
