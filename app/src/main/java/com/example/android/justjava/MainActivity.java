

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

import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    //int price = 0;

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

    public int calculatePrice() {
        return quantity * 5;
    }


    /**
     * Shows a summary of the order
     */

    private String createOrderSummary(int price) {
        String name = "Tometka Thurman";
        String priceMessage = "Name: " + name + " \n"
                + "Quantity: " + quantity + "\n"
                + "Total: $" + calculatePrice();
        priceMessage += " \nThank you!";
        return priceMessage;
    }


    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));

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
     * This method displays the given price on the screen.
     */

    private void displayPrice(int number) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }


    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

        priceTextView.setText(message);

    }


}