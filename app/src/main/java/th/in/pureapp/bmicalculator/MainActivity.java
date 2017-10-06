package th.in.pureapp.bmicalculator;
/**
 * Note:
 * bmi < 18.5 น้อยกว่าปกติ
 * 18.5 < bmi < 25 ปกติ
 * 25 < ท้วม < 30
 * > 30 อ้วน
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mHeightEditText,mWeightEditText;
    private Button mCalculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeightEditText = (EditText) this.findViewById(R.id.height_edittext);
        mWeightEditText = (EditText) this.findViewById(R.id.weight_edittext);
        mCalculateButton = (Button) this.findViewById(R.id.calculate_button);
        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double height = Double.valueOf(mHeightEditText.getText().toString());
                Double weight = Double.valueOf(mWeightEditText.getText().toString());
                Double bmi = weight/ Math.pow(height/100.0,2);
                String bmiText = getBmiText(bmi);
                String result = String.format(MainActivity.this.getString(R.string.weightformat_label),bmi,bmiText);
                Intent intent = new Intent(MainActivity.this, BmiResultActivity.class);
                intent.putExtra("bmi_text",result);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    private String getBmiText(Double bmi) {
        String bmiText = "";
        if(bmi < 18.5){
            bmiText = this.getString(R.string.underweight_label);
        }else if(bmi < 25){
            bmiText = this.getString(R.string.normalweight_label);
        }else if(bmi < 30){
            bmiText = this.getString(R.string.overweight_label);
        }else{
            bmiText = this.getString(R.string.obese_label);
        }
        return bmiText;
    }

}
