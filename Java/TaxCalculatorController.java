package taxFx;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TaxCalculatorController { 
   // formatters for currency and percentages
   private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();
   
   private BigDecimal taxPercentage = new BigDecimal(0.06); // 6% default
   private BigDecimal discountPercentage = new BigDecimal(0.18); // 18% default
   
   // GUI controls defined in FXML and used by the controller's code
   @FXML 
   private TextField amountTextField; 
   @FXML
   private Label taxPercentageLabel; 
   @FXML
   private Label discountPercentageLabel; 
   @FXML
   private Slider taxSlider;
   @FXML
   private Slider discountSlider;
   @FXML
   private TextField taxTextField;
   @FXML
   private TextField discountTextField;
   @FXML
   private TextField totalTextField;

   // calculates and displays the tip and total amounts
   @FXML
   private void calculateButtonPressed(ActionEvent event) {
      try {
         BigDecimal amount = new BigDecimal(amountTextField.getText());
         BigDecimal tax = amount.multiply(taxPercentage);
         BigDecimal discount = amount.multiply(discountPercentage);
       //total the tax, amount, and subtract discount (tax is calculated before discount because lawyers)
         BigDecimal total = tax.add(amount.subtract(discount));

         discountTextField.setText(currency.format(discount));
         taxTextField.setText(currency.format(tax));
         totalTextField.setText(currency.format(total));
      }
      catch (NumberFormatException ex) {
         amountTextField.setText("Enter amount");
         amountTextField.selectAll();
         amountTextField.requestFocus();
      }
   }
   // called by FXMLLoader to initialize the controller
   public void initialize() {
      // 0-4 rounds down, 5-9 rounds up 
      currency.setRoundingMode(RoundingMode.HALF_UP);
      
      // listeners for changes to Slider values
      taxSlider.valueProperty().addListener(
         new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
               Number oldValue, Number newValue) {
               taxPercentage = 
                  BigDecimal.valueOf(newValue.intValue() / 100.0);
               taxPercentageLabel.setText(percent.format(taxPercentage));
            }
         }
         
      );
      discountSlider.valueProperty().addListener(
    	         new ChangeListener<Number>() {
    	            @Override
    	            public void changed(ObservableValue<? extends Number> ov, 
    	               Number oldValue, Number newValue) {
    	               discountPercentage = 
    	                  BigDecimal.valueOf(newValue.intValue() / 100.0);
    	               discountPercentageLabel.setText(percent.format(discountPercentage));
    	            }
    	         }
    	         
    	      );
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
