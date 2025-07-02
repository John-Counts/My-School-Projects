
public class UtilityBills2  {
   private double[][] bills;    //array of each month's bill totals
   
   //constructor takes an array which was formed by user inputs before calling
   public UtilityBills2(double[][] bills) {
      this.bills = bills;
   }
   
   //determines and displays total and average of bills for the period
   public void processBills() {
      //prints the bills array
      outputBills();
      
      //calls for average and total
      System.out.printf("%nAverage utility bill amount for specified period is:%n%5.2f%nTotal utility bill amount is:%n%5.2f%n",
         getAve(0), getTot(0));
      System.out.printf("%nAverage internet bill amount for specified period is:%n%5.2f%nTotal internet bill amount is:%n%5.2f%n",
         getAve(1), getTot(1));
   }
   
   //return average
   public double getAve(int ind)  {
      double tot = 0.0;
      for (int ut1 = 0; ut1 < bills.length; ut1++)   {
         tot += bills[ut1][ind];
      }
      return tot / bills.length;
   }
   
   //return total, same as above but without dividing by number of bills in array
   public double getTot(int ind)  {
      double tot1 = 0.0;
      //sums the array
      for (int ut1 = 0; ut1 < bills.length; ut1++)   {
         tot1 += bills[ut1][ind];
      }
      return tot1;
   }
   
   //prints array values
   public void outputBills()  {
      System.out.printf("Utility bill amounts for the last %d months are as follows:%nmonth     utility     internet%n", bills.length);
      
      for (int month = 0; month < bills.length; month++) {
         System.out.printf("month %d:%10.2f%10.2f%n", month + 1, bills[month][0],bills[month][1]);
      }
   }
}