package th.in.pureapp.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        Intent intent = getIntent();
        String bmiText = intent.getStringExtra("bmi_text");
        TextView textView = (TextView) this.findViewById(R.id.bmi_result_textview);
        textView.setText(bmiText);
    }
}
