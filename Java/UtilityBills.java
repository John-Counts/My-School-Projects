
public class UtilityBills  {
   private int[] bills;    //array of each month's bill totals
   
   //constructor takes an array which was formed by user inputs before calling
   public UtilityBills(int[] bills) {
      this.bills = bills;
   }
   
   //determines and displays total and average of bills for the period
   public void processBills() {
      //prints the bills array
      outputBills();
      
      //calls for average and total
      System.out.printf("%nAverage utility bill amount for specified period is:%n%5d%nTotal utility bill amount is:%n%5d%n",
         getAve(), getTot());
   }
   
   //return average
   public int getAve()  {
      int tot1 = 0;
      //sums the array
      for (int bill : bills)   {
         tot1 += bill;
      }
      return tot1 / bills.length;
   }
   
   //return total, same as above but without dividing by number of bills in array
   public int getTot()  {
      int tot = 0;
      //sums the array
      for (int bill : bills)   {
         tot += bill;
      }
      return tot;
   }
   
   //prints array values
   public void outputBills()  {
      System.out.printf("Utility bill amounts for the last %d months are as follows:%n", bills.length);
      
      for (int month = 0; month < bills.length; month++) {
         System.out.printf("month %d: %5d%n", month + 1, bills[month]);
      }
   }
}