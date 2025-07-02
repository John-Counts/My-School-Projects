
/*
 *  Modify the payroll system of Figs. 10.4-10.9 to include an additional Employee subclass TemporaryPieceWorker 
 *  that represents an employee whose pay is based on the number of pieces of merchandise produced. Class TemporaryPieceWorker 
 *  should contain private instance variables wage (to store wages per piece) and pieces (to store number of pieces produced). Provide a 
 *  concrete implementation of method earnings in class TemporaryPieceWorker that calculates the employees earnings (wages * number of pieces). 
 *  Create an array of Employee variables to store references to objects of each concrete class in the new Employee hierarchy.
 *   Display each Employees details (String representations and earnings).
 */

public class TemporaryPieceWorker extends Employee {

	private double wage;	 // wage per piece
	private int piece;		 // pieces produced
	
	// constructor
	public TemporaryPieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int piece) {
		super(firstName, lastName, socialSecurityNumber);
		if (wage < 0.0) { // validate wage
	         throw new IllegalArgumentException("Wage per piece must be >= 0.0");
	    }
	
	    if ((piece < 0)) { // validate pieces produced
	         throw new IllegalArgumentException(
	            "Pieces produced must be >= 0");
	    }
	
	      this.wage = wage;
	      this.piece = piece;
	}
	
	
	
   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Wage per piece must be >= 0.0");
      }

      this.wage = wage;
   } 

   // return wage
   public double getWage() {return wage;}
   
   // set piece
   public void setPiece(int piece) {
      if (piece < 0) { // validate piece
         throw new IllegalArgumentException("Pieces produced must be >= 0");
      }

      this.piece = piece;
   } 
   
   // return piece
   public int getPiece() {return piece;}

   
   
   // to string info
	@Override
	public String toString() {                                  
	      return String.format("Temp piece worker: %s%n%s: $%,.2f; %s: %d",
	         super.toString(), "per widget wage", getWage(), "number of widgets produced", getPiece());
	   } 
	
	// calculate overall earnings, (per widget wage) * (number of widgets)
	@Override
	public double earnings() {
		return getWage() * getPiece();
	}

}
