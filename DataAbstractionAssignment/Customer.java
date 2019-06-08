import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.deposits = new ArrayList<Deposit>();
        this.withdraws = new ArrayList<Withdraw>();
        this.name = name;
        this.accountNumber = accountNumber;
        this.deposit(checkDeposit, new Date(), CHECKING );
        this.deposit(savingDeposit, new Date(), SAVING);

    }

    //Requires: amt > 0
    //Modifies: deposits ArrayList
    //Effects: adds a new string to deposits ArrayList with amount, date, and account, returns amt of deposit
    public double deposit(double amt, Date date, String account){
        //your code here
        if (amt > 0) {
            Deposit money = new Deposit(amt, date, account);
            deposits.add(money);
            if (account.equals(CHECKING)) {
                checkBalance += amt;
            } else if (account.equals(SAVING)) {
                savingBalance += amt;
            }
        }
        if (account.equals(CHECKING)) {
            return checkBalance;
        } else if (account.equals(SAVING)) {
            return savingBalance;
        }
        return amt;
    }

    //Requires: amt > 0
    //Modifies: withdraws ArrayList
    //Effects: adds a new string to withdraws ArrayList with amount, date, and account, returns amt of withdraw
    public double withdraw(double amt, Date date, String account){
        //your code here
        if (amt > 0) {

            if (checkOverdraft(amt, account)) {


                if (account.equals(CHECKING)) {
                    {
                        Withdraw money = new Withdraw(amt, date, account);
                        checkBalance -= amt;
                        withdraws.add(money);
                    }
                } else if (account.equals(SAVING)) {

                    Withdraw money = new Withdraw(amt, date, account);
                    savingBalance -= amt;
                    withdraws.add(money);

                }
            }
        }
        if (account.equals(CHECKING)) {
            return checkBalance;
        } else if (account.equals(SAVING)) {
            return savingBalance;
        }


        return amt;
    }
    //Requires: amount, account
    //Modifies: nothing
    //Effects: returns whether or not the account has been overdrafted
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if (account.equals(CHECKING)){
            if (amt > checkBalance - OVERDRAFT){
                return false;
            }
            else{
                return true;
            }
        }
        else if (account.equals(SAVING)){
            if (amt > savingBalance - OVERDRAFT){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
