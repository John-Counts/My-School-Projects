
//Scanner used to input bills
import java.util.Scanner;


public class UtilBillTest  {
   public static void main(String[] args) {
      System.out.println("Greetings, and welcome to the Utility Bill Mourning Initiator.");
      System.out.println("   For the utility and internet bills going back as far as you choose, this program will output the average and the total for the period.");
      System.out.println("Please enter the number of month's utilities you would like processed:");
      
      //initialize the scanner object and variables
      Scanner input = new Scanner(System.in);
      int months = input.nextInt();
      input.nextLine();
      int[] bills = new int[months];
      
      //data entry
      for (int m1 = 0; m1 < bills.length; m1++)  {
         System.out.printf("Enter month %d utility bill amount:%n", m1 + 1);
         bills[m1] = input.nextInt();
         input.nextLine();
      }
      for (int m = 0; m < bills.length; m++)  {
         System.out.printf("Enter month %d internet bill amount:%n", m + 1);
         bills[m] = input.nextInt();
         input.nextLine();
      }
      
      //call constructor
      UtilityBills utiBill = new UtilityBills(bills);
      
      //call proccessing
      utiBill.processBills();
      
      System.out.println("Thank you for using this utility");
      
   }
}