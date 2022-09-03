package changetest;

public class Change {
    private static final int MINIMUM_COIN_VALUE = 5;
    private String personName;
    private int changeAmount;
    private int coinHundred;
    private int coinFifty;
    private int coinTwentyFive;
    private int coinTen;
    private int coinFive;

    public Change() //default constructor. Used to initalize the variables in the Change Class, which 'Babyb is now also an object with instance variables. 
    {
        this.personName = "Jd"; //lecturer said to add something 
        this.changeAmount = 0;
        this.coinHundred = 0;
        this.coinFifty = 0;
        this.coinTwentyFive = 0;
        this.coinTen = 0;
    }

    public Change(String personName, int changeAmount) //second constructor takes in 2 argumaents which are the instance variables 
    {
        /*'this.personName' is calling the instance variable from the class(Object: Change)
        and initializing it to variable babyName
        The same is done for babyAge*/
        this.personName = personName;
        this.changeAmount = changeAmount;
        this.coinFifty = 0;
        this.coinHundred = 0;
        this.coinTwentyFive = 0;
        this.coinTen = 0;

        /*setName(babyname) -----> sir said do this in 2nd constructor*/
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        //we used a not(!) because there is no isBlank() method,
        //so we used an isEmpty(). If we used an isBlank() method,
        //they would be no need for the not (!). 
        if (!personName.isEmpty()) {
            this.personName = personName; //if the person name is not empty, leave it as that name
        } else {
            this.personName = ""; //else is the person name is empty, empty string is entered 
        }
    }

    public int getChangeAmount() {
        //estting the changeAmount. So adjustments will be made
        //depending on what the user inputs as the person's change 
        return this.changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
       this.changeAmount = getRoundCoinValue(changeAmount);
    }

    public int getCoinHundred() {
        return this.coinHundred;
    }

    public void setCoinHundred(int coinHundred) {

        this.coinHundred = coinHundred;

    }

    public int getCoinFifty() {
        return this.coinFifty;
    }

    public void setCoinFifty(int coinFifty) {
        this.coinFifty = coinFifty;
    }

    public int getCoinTwentyFive() {
        return this.coinTwentyFive;
    }

    public void setCoinTwentyFive(int coinTwentyFive) {
        this.coinTwentyFive = coinTwentyFive;
    }

    public int getCoinTen() {
        return this.coinTen;
    }

    public void setCoinTen(int coinTen) {
        this.coinTen = coinTen;
    }

    public int getCoinFive() {
        return this.coinFive;
    }

    public void setCoinFive(int coinFive) {
        this.coinFive = coinFive;
    }
 public static int getRoundCoinValue(int coin) {
        
        if (coin % MINIMUM_COIN_VALUE < 2.5) {
            coin = coin - coin % MINIMUM_COIN_VALUE;
        } else {
            coin = coin + (MINIMUM_COIN_VALUE - coin % MINIMUM_COIN_VALUE);
        }
        return coin;
    }
    

}
