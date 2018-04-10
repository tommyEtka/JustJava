

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * <p>
 * This example uses the package name:
 * <p>
 * package com.example.android.justjava
 * <p>
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * <p>
 * in the project's AndroidManifest.xml file.
 **/


package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    // int price = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Calculates the price of the order
     *
     * @return total price
     */

    public int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }


    /**
     * Shows a summary of the order
     */

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name + " \n";
        priceMessage += "Add whipped cream?: " + addWhippedCream + "\n";
        priceMessage += "Add chocolate?: " + addChocolate + "\n";
        priceMessage += "Quantity: " + quantity + "\n";
        priceMessage += "Total: $" + calculatePrice(addWhippedCream,addChocolate);
        priceMessage += " \nThank you!";
        return priceMessage;
    }


    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();


        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();


        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();


        // Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);


        // Display the order summary on the screen
        String message = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(message);

    }


    /**
     * This method is called when the increment button is clicked.
     */

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    /**
     * This method is called when the decrement button is clicked.
     */

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    /**
     * This method displays the given quantity value on the screen.
     */

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }


    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }


}