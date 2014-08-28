package purchasechangemaker;

/**
 * @author Blas Barrero
 */

public class changeMaker
{
    //instance var's
    private double amountDue;// total cost of purchase
    private double amountTendered;// amount paid
    private int dollarsDue; 
    private int quartersDue;
    private int dimesDue;
    private int nickelsDue;
    private int penniesDue;
    
    /**
     * Constructs a ChangeMaker object
     * @param totalDue the amount of the purchase
     * @param amountRecieved the amount tendered (paid)
     */
    
    public changeMaker (double totalDue, double amountRecieved)
    {
        //initialise instance var's
        amountDue = totalDue;
        amountTendered = amountRecieved;
        // other instance var's automatically initialized to 0
        System.out.printf("%nAmount Due:      $%7.2f", amountDue);
        System.out.printf("%nAmount Recieved: $%7.2f", amountTendered);
        computeChange();
    }
    
    /**
     * Computes the number of coins of each denomination to be given as change
     */
    public void computeChange()
    {
        int changeDue;  // total change due, in cents
        
        if (amountDue == amountTendered)
        {
            System.out.println("\nExact change! Thanks and have a nice day!");
        }
        else if (amountDue > amountTendered) //owes more money!
        {
            System.out.printf("\nLo siento, you still owe me another %.2f%n", amountDue - amountTendered);
        }
        else //change is due
        {
            //compute change due, in cents for easier calculations
            changeDue = (int) Math.round((amountTendered - amountDue) * 100);
            String stringchangeoutput = (changeDue/ 100)+ "." + (changeDue%100);
            double changeoutput = Double.parseDouble(stringchangeoutput);
            System.out.printf("%nYour change:     $%7.2f", changeoutput);
            System.out.println();
            System.out.println();
            
            
            dollarsDue = changeDue / 100;
            changeDue = changeDue %100;
            
            quartersDue = changeDue / 25;
            changeDue = changeDue % 25;
            
            dimesDue = changeDue / 10;
            changeDue = changeDue % 10;
            
            nickelsDue = changeDue / 5;
            changeDue = changeDue % 5;
            
            penniesDue = changeDue;
            
            this.giveChange();
                        
        }
    }// End of changeMaker Class Definition ===================================
    
    private void giveChange()
    {
        //System.out.println("\nYour change:");
        if (dollarsDue != 0)
        {
            System.out.print("\t" + dollarsDue);
            if (dollarsDue == 1)
              {
                System.out.println(" Dollar");
              }
            else
              {
                System.out.println(" Dollars");
              }
        }
        if (quartersDue != 0)
        {
            System.out.print("\t" + quartersDue);
            if(quartersDue == 1)
              {
                System.out.println(" Quarter");
              }
            else
              {
                System.out.println(" Quarters");
              }
        }
        if (dimesDue != 0)
        {
            System.out.print("\t" + dimesDue);           
            if (dimesDue == 1)
              {
                System.out.println(" Dime");
              }
            else
              {
                System.out.println(" Dimes");
              }
        }
        
        if (nickelsDue != 0)
          {
            System.out.print("\t" + nickelsDue);
             if (nickelsDue == 1)
               {
                 System.out.println(" nickel");
               }
             else
               {
                 System.out.println(" nickels");
               }
        }
        if (penniesDue != 0)
        {
            System.out.print("\t" + penniesDue);
            if (penniesDue == 1)
            {
                System.out.println(" penny");            
            }
            else
            {
                System.out.println(" pennies");                
            }
        }
        System.out.println("\nThanks and have a nice day!");
    }    
}