package sg.edu.rp.c346.id18016094.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView tvamt;
    TextView tvpax;
    TextView tvdisc;
    TextView tvTotalBill;
    TextView tvSplitBill;
    TextView tvtotal;
    TextView tvpay;

    EditText etamt;
    EditText etpax;
    EditText etdisc;
    ToggleButton tgsvs;
    ToggleButton tggst;
    Button btnsplit;
    Button btnreset;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvamt = findViewById(R.id.textViewAmount);
        tvpax = findViewById(R.id.textViewPax);
        tvdisc = findViewById(R.id.textViewDiscount);
        tvTotalBill = findViewById(R.id.textViewTotalBill);
        tvSplitBill = findViewById(R.id.textViewSplitBill);
        tvtotal = findViewById(R.id.total);
        tvpay = findViewById(R.id.pay);
        etamt = findViewById(R.id.editTextAmount);
        etpax = findViewById(R.id.editTextPax);
        etdisc = findViewById(R.id.editTextDiscount);
        tgsvs = findViewById(R.id.toggleButtonSVS);
        tggst = findViewById(R.id.toggleButtonGST);
        btnsplit = findViewById(R.id.buttonSplit);
        btnreset = findViewById(R.id.buttonReset);
        btncalculate = findViewById(R.id.buttonCalculate);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            //	String val = String.format("%.2f", (1.0/3.0));
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etamt.getText().toString());
                int b = Integer.parseInt(etpax.getText().toString());
                if (tgsvs.isChecked() && tggst.isChecked()) {
                    a = (a * 1.10) * 1.07;
                    String tot = String.format("%.2f", a);
                    tvtotal.setText(tot);
                } else if (tggst.isChecked()) {
                    a = a * 1.07;
                    String tot = String.format("%.2f", a);
                    tvtotal.setText(tot);
                } else if (tgsvs.isChecked()) {
                    a = a * 1.10;
                    String tot = String.format("%.2f", a);
                    tvtotal.setText(tot);
                } else {
                    String tot = String.format("%.2f", a);
                    tvtotal.setText(tot);
                }
            }
        });

        btnsplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etamt.getText().toString());
                int b = Integer.parseInt(etpax.getText().toString());
                if (tgsvs.isChecked() && tggst.isChecked()) {
                    a = (a * 1.10) * 1.07;
                    String val = String.format("%.2f", a / b);
                    tvpay.setText(val);
                }else if (tggst.isChecked()) {
                    a = a * 1.07;
                    String val = String.format("%.2f", a / b);
                    tvpay.setText(val);
                }else if (tgsvs.isChecked()) {
                    a = a * 1.10;
                    String val = String.format("%.2f", a / b);
                    tvpay.setText(val);
                } else {
                    String val = String.format("%.2f", a / b);
                    tvpay.setText(val);
                }
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvtotal.setText("");
                tvpay.setText("");
                tggst.setChecked(false);
                tgsvs.setChecked(false);
                etamt.setText("");
                etpax.setText("");

            }
        });
    }
}
