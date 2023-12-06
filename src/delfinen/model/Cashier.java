package delfinen.model;


import delfinen.manager.CashierManager;

public class Cashier {

    private CashierManager cashierManager = new CashierManager();



    public void displayFinance(){
        cashierManager.displayFinances();
    }
    public void displayMembersInArrears(){
        cashierManager.printMembersInArrears();
    }
    public void recievePayment(){
        cashierManager.processPayment();
    }


}