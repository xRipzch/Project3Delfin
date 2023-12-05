package delfinen.model;


import delfinen.controller.CashierController;

public class Cashier {

    private CashierController cashierController = new CashierController();



    public void displayFinance(){
        cashierController.displayFinances();
    }
    public void displayMembersInArrears(){
        cashierController.printMembersInArrears();
    }
    public void recievePayment(){
        cashierController.processPayment();
    }


}