/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchasechangemaker;

/**
 * @author Blas Barrero
 *
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * A class to represent a purchase - number of items, description, and price per
 * item
 */
class Purchase {

    // instance vars
    private int quantity;	// number of each item purchased
    private String item;	// description of the item
    private double unitPrice;   // price per item
    private double cost;	// total cost:  quantity * unitPrice
    private static final double TAX_RATE = 0.065;	// 6.5% (a constant)

    /**
     * Creates a purchase object
     *
     * @param quantity number of items bought
     * @param item one-word description of item
     * @param unitPrice price per item
     */
    public Purchase(int quantity, String item, double unitPrice)
      {
        this.quantity = quantity;
        this.item = item;
        this.unitPrice = unitPrice;
        // compute cost of purchase
        cost = quantity * unitPrice;
      }

    /**
     * Return the cost of a purchase.
     *
     * @return the cost of a purchase
     */
    public double getCost()
      {
        return cost;
      }

    /**
     * Returns a String containing the input data for a purchase
     *
     * @return the quantity, description, and price per item as a String
     * Example:	"5 widgets
     * @ $1.23
     */
    public String getData()
      {
        return quantity + " " + item + " @ $" + unitPrice;
        // example:	"5 widgets @ $1.23
      }

    /**
     * Compute and return the tax on a purchase.
     *
     * @return the tax on a purchase
     */
    public double getTax()
      {
        double tax = cost * TAX_RATE;		// tax on purchase
        return tax;
      }

    /**
     * Compute and return total cost of a purchase, including tax
     *
     * @return the total cost of a purchase, tax included
     */
    public double getTotal()
      {
        // call getTax() to compute the tax, and add to cost
        return getTax() + cost;
      }
} // end of Purchase class definition ========================================

/**
 * Test class for Purchase class
 */
public class PurchaseChangeMaker {

    public static void main(String[] args)
      {
        String input = JOptionPane.showInputDialog("Enter number of items "
                + "purchased, a one-word description, and unit price "
                + "\n(Separated by spaces)");

        // create Scanner object associated with the string read
        Scanner in = new Scanner(input);

        // extract the 3 tokens
        int quantity = in.nextInt();
        String item = in.next();
        double price = in.nextDouble();

        // create a Purchase object, using input data
        Purchase current = new Purchase(quantity, item, price);

        // print purchase, tax, and total cost
        System.out.println("\nYour purchase:\n");
        System.out.println(current.getData() + " = $" + current.getCost()+ "\n");
        System.out.printf("Tax   = $%6.2f%n", current.getTax());
        System.out.printf("Total = $%6.2f%n", current.getTotal());
        
        String Amountinput = JOptionPane.showInputDialog("Please enter the Amount Recieved (Amount given by customer)");

        // create Scanner object associated with the string read
        Scanner Ainput = new Scanner(Amountinput);
        double Amount = Ainput.nextDouble();
        changeMaker ChangeMaker = new changeMaker(current.getTotal(),Amount);

        System.exit(0);
      }
}

/*  sample output:

 
Your purchase:

8 pucks @ $4.37 = $34.96

Tax   = $  2.27
Total = $ 37.23

Amount Due:      $  37.23
Amount Recieved: $  40.00
Your change:     $   2.77

	2 Dollars
	3 Quarters
	2 pennies

Thanks and have a nice day!

 */
