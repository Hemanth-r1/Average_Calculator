package in.hr.averagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText currentHoldingShares, currentHoldingAverage, currentHoldingAmount,
            newShares, newAverage, newAmount;
    TextView totalSharesNow, totalAverageNow, totalAmountNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentHoldingShares = findViewById(R.id.holding_shares);
        currentHoldingAverage = findViewById(R.id.holding_shares_average);
        currentHoldingAmount = findViewById(R.id.holding_shares_average_price);

        newShares = findViewById(R.id.new_shares);
        newAverage = findViewById(R.id.new_shares_price);
        newAmount = findViewById(R.id.new_shares_amount);

        totalAmountNow = findViewById(R.id.total_amount);
        totalAverageNow = findViewById(R.id.total_average_price);
        totalSharesNow = findViewById(R.id.total_shares);


    }

    public void calculateTotal() {
        int totalSh, totalAv, totalAm;
        int oldHold, newHold, newAvg,  oldAvg,newTot, oldTot;

        String holding = currentHoldingShares.getText().toString();
        oldHold = Integer.parseInt(holding);

        String newShare = newShares.getText().toString();
        newHold = Integer.parseInt(newShare);

        String avg = currentHoldingAverage.getText().toString();
        oldAvg = Integer.parseInt(avg);

        String NewAverage = newAverage.getText().toString();
        newAvg = Integer.parseInt(NewAverage);

        oldTot = oldAvg* oldHold;
        newTot = newAvg * newHold;

        totalSh = newHold + oldHold;
        totalAv = newAvg + oldAvg;
        totalAm = oldTot + newTot;

        String totalShares = String.valueOf(totalSh);
        String totalAverage = String.valueOf(totalAv);
        String totalAmount = String.valueOf(totalAm);

        totalSharesNow.setText(totalShares);
        totalAmountNow.setText(totalAmount);
        totalAverageNow.setText(totalAverage);


/*
        String share = totalShares.getText().toString();
        totalSh = Integer.parseInt(share);

        String average = totalAverage.getText().toString();
        totalAv = Integer.parseInt(average);

 */

    }

    public int calculateNew(EditText newShares, EditText newAverage) {
        int newShare, marketPrice,  price;

        String share = newShares.getText().toString();
        // newShare = Integer.getInteger(share);
        newShare = Integer.parseInt(share);

        String average = newAverage.getText().toString();
        //marketPrice = Integer.getInteger(average);
        marketPrice = Integer.parseInt(average);

        price = newShare * marketPrice;

        String total = String.valueOf(price);
        newAmount.setText(total);

        return price;
    }

    public int calculateHolding(EditText currentHoldingShares, EditText currentHoldingAverage) {
        int holdingAverage, holdingShares, holdingAmount;

        String average = currentHoldingAverage.getText().toString();
        //holdingAverage = Integer.getInteger(average); this is not working showing null pointer

        holdingAverage = Integer.parseInt(average);
        String shares = currentHoldingShares.getText().toString();
        //holdingShares = Integer.getInteger(shares); same as above

        holdingShares = Integer.parseInt(shares);
        holdingAmount = holdingAverage * holdingShares;
        //Toast.makeText(this, "value" + holdingAmount, Toast.LENGTH_LONG).show();
        //currentHoldingAmount.setText(holdingAmount);

        String value = String.valueOf(holdingAmount);
        currentHoldingAmount.setText(value);

        return holdingAmount;
    }

    public void calculateHolding(View view) {
        calculateHolding(currentHoldingShares, currentHoldingAverage);
        calculateNew(newShares, newAverage);
        calculateTotal();

    }
}