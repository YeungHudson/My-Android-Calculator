package comyeunghudson.httpsgithub.myandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //initializing variables
    TextView Result;
    Button Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9, Add, Subtract, Multiply, Divide, Equals;
    Button clearEntry;
    //Button Clear, Backspace;

    /*do we even need this method?
    public void init(){//init means that the jApplet starts here and is only used for jApplets

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num0 = (Button)findViewById(R.id.Num0);//Defining variables
        Num1 = (Button)findViewById(R.id.Num1);
        Num2 = (Button)findViewById(R.id.Num2);
        Num3 = (Button)findViewById(R.id.Num3);
        Num4 = (Button)findViewById(R.id.Num4);
        Num5 = (Button)findViewById(R.id.Num5);
        Num6 = (Button)findViewById(R.id.Num6);
        Num7 = (Button)findViewById(R.id.Num7);
        Num8 = (Button)findViewById(R.id.Num8);
        Num9 = (Button)findViewById(R.id.Num9);
        Add = (Button)findViewById(R.id.Add);
        Subtract = (Button)findViewById(R.id.Subtract);
        Multiply = (Button)findViewById(R.id.Multiply);
        Divide = (Button)findViewById(R.id.Divide);
        Equals = (Button)findViewById(R.id.Equals);
        clearEntry = (Button)findViewById(R.id.clearEntry);
        //Clear = (Button)findViewById(R.id.Clear);
        //Backspace = (Button)findViewById(R.id.Backspace);

        Result = (TextView)findViewById(R.id.Result);

        //makes the buttons clickable
        Num0.setOnClickListener(this);
        Num1.setOnClickListener(this);
        Num2.setOnClickListener(this);
        Num3.setOnClickListener(this);
        Num4.setOnClickListener(this);
        Num5.setOnClickListener(this);
        Num6.setOnClickListener(this);
        Num7.setOnClickListener(this);
        Num8.setOnClickListener(this);
        Num9.setOnClickListener(this);
        Add.setOnClickListener(this);
        Subtract.setOnClickListener(this);
        Multiply.setOnClickListener(this);
        Divide.setOnClickListener(this);
        Equals.setOnClickListener(this);
        clearEntry.setOnClickListener(this);
        //Clear.setOnClickListener(this);
        //Backspace.setOnClickListener(this);
    }

    @Override
    //when buttons are clicked, this happens:
    public void onClick(View v)
    {
        //this command makes a message appear on the screen when a button is clicked:
        //Toast.makeText(getApplicationContext() , "button clicked" + ((Button)v).getText(), Toast.LENGTH_SHORT).show();
        if(v.getId() == R.id.clearEntry){
            Result.setText("0");
        }
        else if(v.getId() == R.id.Equals){
            double calcResult = Calculations.evaluate(Result.getText().toString());
            Result.setText(Double.toString(calcResult));
        }
        else if(v instanceof Button){//if a button is pressed, it will input text onto Result(textVIew)
            Button buttonClicked = (Button)v;

            if(Result.getText().equals("0") && !Calculations.Operator(buttonClicked.getText().charAt(0))){//if result is 0 or is not an operator, result will output a blank line
                Result.setText("");
            }

            Result.setText(Result.getText().toString() + buttonClicked.getText());
        }
    }
}
