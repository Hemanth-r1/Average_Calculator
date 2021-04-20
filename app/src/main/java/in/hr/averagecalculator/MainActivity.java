package in.hr.averagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText currentHoldingShares, currentHoldingAverage, currentHoldingAmount,
            newHoldingShares, newHoldingAverage, newHoldingAmount;
    TextView totalSharesNow, totalAverageNow, totalAmountNow;

    int holdingAverage, holdingShares, holdingAmount;
    int newSh, marketPrice, price;
    int totalSh, totalAv, totalAm;
    int oldHold, newHold, newAvg, oldAvg, newTot, oldTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentHoldingShares = findViewById(R.id.holding_shares);
        currentHoldingAverage = findViewById(R.id.holding_shares_average);
        currentHoldingAmount = findViewById(R.id.holding_shares_average_price);

        newHoldingShares = findViewById(R.id.new_shares);
        newHoldingAverage = findViewById(R.id.new_shares_price);
        newHoldingAmount = findViewById(R.id.new_shares_amount);

        totalAmountNow = findViewById(R.id.total_amount);
        totalAverageNow = findViewById(R.id.total_average_price);
        totalSharesNow = findViewById(R.id.total_shares);

    }

    public void calculateHolding(View view) {

        if (currentHoldingShares.getText().toString().equals("")){
            Snackbar.make(view, "Enter Some Value in the boxes", Snackbar.LENGTH_LONG).show();
            currentHoldingShares.setText("0");
        }
        if (newHoldingAverage.getText().toString().equals("")){
            Snackbar.make(view, "Enter new no of shares and avg", Snackbar.LENGTH_LONG).show();
            newHoldingAverage.setText("0");
        }
        if (currentHoldingAverage.getText().toString().equals("")){
            Snackbar.make(view, "Enter Some Value in the boxes", Snackbar.LENGTH_LONG).show();
            currentHoldingAverage.setText("0");
        }
        if ( newHoldingShares.getText().toString().equals("")){
            Snackbar.make(view, "Enter new no of shares and avg", Snackbar.LENGTH_LONG).show();
            newHoldingShares.setText("0");
        }

            holdingAverage = Integer.parseInt(currentHoldingAverage.getText().toString());
            holdingShares = Integer.parseInt(currentHoldingShares.getText().toString());
            holdingAmount = holdingAverage * holdingShares;
            String holdingValue = String.valueOf(holdingAmount);
            currentHoldingAmount.setText(holdingValue);

            newSh = Integer.parseInt(newHoldingShares.getText().toString());
            marketPrice = Integer.parseInt(newHoldingAverage.getText().toString());
            newTot = marketPrice * newSh;
            String newValue = String.valueOf(newTot);
            newHoldingAmount.setText(newValue);

            oldHold = holdingShares;
            newHold = newSh;
            oldAvg = holdingAverage;
            newAvg = marketPrice;

        totalSh = holdingShares + newSh;
        totalAv = (holdingAverage + marketPrice)/2;
        totalAm = holdingAmount + newTot;
/*
            totalSh = oldHold + newHold;
            totalAv = oldAvg + newAvg;
            totalAm = holdingAmount + newTot;
 */
            String totalShares = String.valueOf(totalSh);
            String totalAvg = String.valueOf(totalAv);
            String totalAmount = String.valueOf(totalAm);

            totalSharesNow.setText(totalShares);
            totalAverageNow.setText(totalAvg);
            totalAmountNow.setText(totalAmount);
        //calculateTotal();
        // calculateHolding(currentHoldingShares, currentHoldingAverage);
        // calculateNew(newShares, newAverage);
    }
}
/*
    public void calculateTotal() {

        //calculate holding

        String holdAvg = currentHoldingAverage.getText().toString();
        //holdingAverage = Integer.getInteger(average); this is not working showing null pointer excp
        holdingAverage = Integer.parseInt(holdAvg);

        String shares = currentHoldingShares.getText().toString();
        //holdingShares = Integer.getInteger(shares); same as above

        holdingShares = Integer.parseInt(shares);
        holdingAmount = holdingAverage * holdingShares;
        //Toast.makeText(this, "value" + holdingAmount, Toast.LENGTH_LONG).show();
        //currentHoldingAmount.setText(holdingAmount);

        String value = String.valueOf(holdingAmount); // convert int to string to assign it to edit text
        currentHoldingAmount.setText(value);

        // calculate new
        String share = newHoldingShares.getText().toString();
        // newShare = Integer.getInteger(share);
        newSh = Integer.parseInt(share);
        String marketAverage = newHoldingAverage.getText().toString();
        //marketPrice = Integer.getInteger(average);
        marketPrice = Integer.parseInt(marketAverage);
        price = newSh * marketPrice;
        String total = String.valueOf(price);
        newHoldingAmount.setText(total);

        // calculate total
        String holding = currentHoldingShares.getText().toString();
        oldHold = Integer.parseInt(holding);
        String newShare = newHoldingShares.getText().toString();
        newHold = Integer.parseInt(newShare);
        String avg = currentHoldingAverage.getText().toString();
        oldAvg = Integer.parseInt(avg);
        String NewAverage = newHoldingAverage.getText().toString();
        newAvg = Integer.parseInt(NewAverage);

        oldTot = oldAvg * oldHold;
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
    }
}

 */
/*
        String share = totalShares.getText().toString();
        totalSh = Integer.parseInt(share);
        String average = totalAverage.getText().toString();
        totalAv = Integer.parseInt(average);

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
*/