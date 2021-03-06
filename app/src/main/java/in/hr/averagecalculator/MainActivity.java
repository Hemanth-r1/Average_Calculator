package in.hr.averagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText currentHoldingShares, currentHoldingAverage, currentHoldingAmount,
            newHoldingShares, newHoldingAverage, newHoldingAmount;
    TextView totalSharesNow, totalAverageNow, totalAmountNow;
    double holdingAverage, holdingShares, holdingAmount;
    double newSh;
    double marketPrice;
    double totalSh, totalAv, totalAm;
    double newAvg, newTot;

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

    public void clearAll(View view) {
        totalSharesNow.setText("");
        totalAverageNow.setText("");
        totalAmountNow.setText("");
        newHoldingAmount.setText("");
        newHoldingShares.setText("");
        newHoldingAverage.setText("");
        currentHoldingAverage.setText("");
        currentHoldingShares.setText("");
        currentHoldingAmount.setText("");
        holdingAverage =0 ;
        holdingShares =0;
        holdingAmount = 0;newSh = 0;
        marketPrice = 0;
        totalSh = 0;
        totalAv = 0;
        totalAm = 0;
        newAvg = 0;
        newTot =0;
    }

    public void MemoryAdd(View view) {
       // variables used holdingAverage, holdingAmount, holdingShares, newSh, newAvg, newTot

        currentHoldingShares.setText(String.valueOf(totalSh));
        currentHoldingAmount.setText(String.valueOf(totalAm));
        currentHoldingAverage.setText(String.valueOf(totalAv));
        totalSharesNow.setText("");
        totalAverageNow.setText("");
        totalAmountNow.setText("");
        newHoldingAmount.setText("");
        newHoldingShares.setText("");
        newHoldingAverage.setText("");
        holdingAverage =0 ;
        holdingShares =0;
        holdingAmount = 0;newSh = 0;
        marketPrice = 0;
        totalSh = 0;
        totalAv = 0;
        totalAm = 0;
        newAvg = 0;
        newTot =0;
    }

    public void calculate(View view) {

        String currentHoldSh, currentHoldAvg, currentHoldAmt, newHoldSh, newHoldAvg, newHoldAmt;

        currentHoldAvg = currentHoldingAverage.getText().toString();
        currentHoldSh = currentHoldingShares.getText().toString();
        currentHoldAmt = currentHoldingAmount.getText().toString();
        newHoldSh = newHoldingShares.getText().toString();
        newHoldAvg = newHoldingAverage.getText().toString();
        newHoldAmt = newHoldingAmount.getText().toString();

        // to calculate average if  shares and amount are given
        if (!currentHoldSh.equals("") && currentHoldAvg.equals("") && !currentHoldAmt.equals("")) {
            currentHoldAvg = currentHoldingAverage.getText().toString();
            currentHoldSh = currentHoldingShares.getText().toString();
            currentHoldAmt = currentHoldingAmount.getText().toString();
            holdingShares = Double.parseDouble(currentHoldSh);
            holdingAmount = Double.parseDouble(currentHoldAmt);
            holdingAverage = holdingAmount / holdingShares;
            String holdingAmountText = String.valueOf(holdingAverage);
            currentHoldingAverage.setText(holdingAmountText);
        }
        // calculate shares if average and amount are given
        if (currentHoldSh.equals("") && !currentHoldAvg.equals("") && !currentHoldAmt.equals("")) {
            currentHoldAvg = currentHoldingAverage.getText().toString();
            currentHoldSh = currentHoldingShares.getText().toString();
            currentHoldAmt = currentHoldingAmount.getText().toString();
            holdingAverage = Double.parseDouble(currentHoldAvg);
            holdingAmount = Double.parseDouble(currentHoldAmt);
            holdingShares = holdingAmount / holdingAverage;
            String holdingSharesText = String.valueOf(holdingShares);
            currentHoldingShares.setText(holdingSharesText);
        }
        // calculate amount if shares and average are given
        if (!currentHoldSh.equals("") && !currentHoldAvg.equals("") && currentHoldAmt.equals("")) {
            currentHoldAvg = currentHoldingAverage.getText().toString();
            currentHoldSh = currentHoldingShares.getText().toString();
            currentHoldAmt = currentHoldingAmount.getText().toString();
            holdingShares = Double.parseDouble(currentHoldSh);
            holdingAverage = Double.parseDouble(currentHoldAvg);
            holdingAmount = holdingAverage * holdingShares;
            String holdingValueText = String.valueOf(holdingAmount);
            currentHoldingAmount.setText(holdingValueText);
        }
        // if everything is prefilled
        if (!currentHoldSh.equals("") && !currentHoldAvg.equals("") && !currentHoldAmt.equals("")) {
            currentHoldAvg = currentHoldingAverage.getText().toString();
            currentHoldSh = currentHoldingShares.getText().toString();
            currentHoldAmt = currentHoldingAmount.getText().toString();
            holdingShares = Double.parseDouble(currentHoldSh);
            holdingAverage = Double.parseDouble(currentHoldAvg);
            holdingAmount = Double.parseDouble(currentHoldAmt);
        }
        // if nothing is entered show a toast msg
        if (currentHoldSh.equals("") && currentHoldAvg.equals("") && currentHoldAmt.equals("")) {
            Toast.makeText(this, "Enter something", Toast.LENGTH_SHORT).show();
        }

        // calculate new shares if average and amount are given
        if (newHoldSh.equals("") && !newHoldAvg.equals("") && !newHoldAmt.equals("")) {
            newHoldSh = newHoldingShares.getText().toString();
            newHoldAvg = newHoldingAverage.getText().toString();
            newHoldAmt = newHoldingAmount.getText().toString();

            newAvg = Double.parseDouble(newHoldAvg);
            newTot = Double.parseDouble(newHoldAmt);
            newSh = newTot / newAvg;
            String share = String.valueOf(newSh);
            newHoldingShares.setText(share);
        }
        // calculate amount if average and shares are given
        if (!newHoldSh.equals("") && !newHoldAvg.equals("") && newHoldAmt.equals("")) {
            newHoldSh = newHoldingShares.getText().toString();
            newHoldAvg = newHoldingAverage.getText().toString();
            newHoldAmt = newHoldingAmount.getText().toString();

            newSh = Double.parseDouble(newHoldSh);
            marketPrice = Double.parseDouble(newHoldAvg);
            newTot = marketPrice * newSh;
            String newValue = String.valueOf(newTot);
            newHoldingAmount.setText(newValue);
        }
        // calculate avg if share and amount are given
        if (!newHoldSh.equals("") && newHoldAvg.equals("") && !newHoldAmt.equals("")) {
            newHoldSh = newHoldingShares.getText().toString();
            newHoldAvg = newHoldingAverage.getText().toString();
            newHoldAmt = newHoldingAmount.getText().toString();

            newSh = Double.parseDouble(newHoldSh);
            Double value = Double.parseDouble(newHoldAmt);
            marketPrice = value / newSh;
            String price = String.valueOf(marketPrice);
            newHoldingAverage.setText(price);
        }
        // if nothing is given
        if (newHoldSh.equals("") && newHoldAvg.equals("") && newHoldAmt.equals("")) {
            Snackbar.make(view, "NING OND 20 KODTHINI", Snackbar.LENGTH_LONG).show();
        }
        // calculate avg if share and amount are given
        if (!newHoldSh.equals("") && !newHoldAvg.equals("") && !newHoldAmt.equals("")) {

            newSh = Double.parseDouble(newHoldSh);
            marketPrice = Double.parseDouble(newHoldAvg);
            newTot = Double.parseDouble(newHoldAmt);
        }

        totalSh = holdingShares + newSh;
        totalAm = holdingAmount + newTot;
        if (holdingAverage != 0 && marketPrice != 0) {
            totalAv = (totalAm) / totalSh;
        } else if (holdingAverage != 0) {
            totalAv = holdingAverage;
        } else if (marketPrice != 0) {
            totalAv = marketPrice;
        } else totalAv = 0;

        String totalShares = String.valueOf(totalSh);
        String totalAvg = String.valueOf(totalAv);
        String totalAmount = String.valueOf(totalAm);
        totalSharesNow.setText(totalShares);
        totalAverageNow.setText(totalAvg);
        totalAmountNow.setText(totalAmount);
    }
}
/*
    public void calculateHolding(View view) {
        /*
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

        Snackbar.make(view, "NING OND 20 KODTHINI", Snackbar.LENGTH_LONG).show();

        // to calculate average if  shares and amount are given
        if (currentHoldingAverage.getText().toString().equals("") && !currentHoldingShares.getText().toString().equals("") && !currentHoldingAmount.getText().toString().equals("")) {

            //holdingShares = Integer.parseInt(currentHoldingShares.getText().toString());
            //works only for int variables i need it to work for floating variable
            //holdingAmount = Integer.parseInt(currentHoldingAmount.getText().toString());
            holdingShares = Double.parseDouble(currentHoldingShares.getText().toString());
            holdingAmount = Double.parseDouble(currentHoldingAmount.getText().toString());
            holdingAverage = holdingAmount / holdingShares;
            String holdingAmountText = String.valueOf(holdingAverage);
            currentHoldingAverage.setText(holdingAmountText);
        }

        // calculate shares if average and amount are given
        if (!currentHoldingAverage.getText().toString().equals("") && currentHoldingShares.getText().toString().equals("") && !currentHoldingAmount.getText().toString().equals("")) {
            //holdingAverage = Integer.parseInt(currentHoldingAverage.getText().toString());
            //holdingAmount = Integer.parseInt(currentHoldingAmount.getText().toString());
            holdingAverage = Double.parseDouble(currentHoldingAverage.getText().toString());
            holdingAmount = Double.parseDouble(currentHoldingAmount.getText().toString());
            holdingShares = holdingAmount / holdingAverage;
            String holdingSharesText = String.valueOf(holdingShares);
            currentHoldingAverage.setText(holdingSharesText);
        }

        // calculate amount if shares and average are given
        if (!currentHoldingAverage.getText().toString().equals("") && !currentHoldingShares.getText().toString().equals("") && currentHoldingAmount.getText().toString().equals("")) {
            //holdingAverage = Integer.parseInt(currentHoldingAverage.getText().toString());
            //holdingShares = Integer.parseInt(currentHoldingShares.getText().toString());
            holdingShares = Double.parseDouble(currentHoldingShares.getText().toString());
            holdingAverage = Double.parseDouble(currentHoldingAverage.getText().toString());
            holdingAmount = holdingAverage * holdingShares;
            String holdingValue = String.valueOf(holdingAmount);
            currentHoldingAmount.setText(holdingValue);
        }

        // calculate average if new shares and amount are given
        if (newHoldingAverage.getText().toString().equals("") && !newHoldingShares.getText().toString().equals("") && !newHoldingAmount.getText().toString().equals("")) {
            //newSh = Integer.parseInt(newHoldingShares.getText().toString());
            //newTot = Integer.parseInt(newHoldingAmount.getText().toString());
            newSh = Double.parseDouble(newHoldingShares.getText().toString());
            newTot = Double.parseDouble(newHoldingAmount.getText().toString());
            marketPrice = newTot / newSh;
            String price = String.valueOf(marketPrice);
            newHoldingAverage.setText(price);
        }

        // calculate new shares if average and amount are given
        if (!newHoldingAverage.getText().toString().equals("") && newHoldingShares.getText().toString().equals("") && !newHoldingAmount.getText().toString().equals("")) {
            //newAvg = Integer.parseInt(newHoldingAverage.getText().toString());
            //newTot = Integer.parseInt(newHoldingAmount.getText().toString());
            newAvg = Double.parseDouble(newHoldingAverage.getText().toString());
            newTot = Double.parseDouble(newHoldingAmount.getText().toString());
            newSh = newTot / newAvg;
            String share = String.valueOf(marketPrice);
            newHoldingAverage.setText(share);
        }

        // calculate amount if average and shares are given
        if (!newHoldingAverage.getText().toString().equals("") && !newHoldingShares.getText().toString().equals("") && newHoldingAmount.getText().toString().equals("")) {
            //newSh = Integer.parseInt(newHoldingShares.getText().toString());
            //marketPrice = Integer.parseInt(newHoldingAverage.getText().toString());
            newSh = Double.parseDouble(newHoldingShares.getText().toString());
            marketPrice = Double.parseDouble(newHoldingAverage.getText().toString());
            newTot = marketPrice * newSh;
            String newValue = String.valueOf(newTot);
            newHoldingAmount.setText(newValue);
        }
        /*
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
        if (holdingAverage != 0 && marketPrice != 0) {
            totalAv = (holdingAverage + marketPrice) / 2;
        } else if (holdingAverage != 0) {
            totalAv = holdingAverage;
        } else {
            totalAv = marketPrice;
        }
        totalAm = holdingAmount + newTot;
/*
            totalSh = oldHold + newHold;
            totalAv = oldAvg + newAvg;
            totalAm = holdingAmount + newTot;

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

 */
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