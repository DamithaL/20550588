package ezbus.mit20550588.conductor.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ezbus.mit20550588.conductor.R;
import ezbus.mit20550588.conductor.ui.ForgotPassword.PasswordChanged;

public class AccountCreated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_created);

        // EZBus.conductor.app main text

        TextView textView0 = findViewById(R.id.main_app_name);
        String html = "<font color=#025a66>EZBus</font> <font color=#0A969F.conductor./font>";
        textView0.setText(Html.fromHtml(html));



        // How to use button
        Button HowtoUseButton = (Button) this.findViewById(R.id.howToUseButton);
        HowtoUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PasswordChanged.class);
                startActivity(intent);
            }
        });



        // Add Payment button
        Button AddPaymentButton = (Button) this.findViewById(R.id.addPaymentButton);
        AddPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        AddPayment.class);
                startActivity(intent);
            }
        });
    }
}