package manjubs.com.sample.preferencesexercise;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText et_passowrdinput;
    Button bt_saveinfo;
    Button bt_displayinfo;
    TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et_passowrdinput = (EditText) findViewById(R.id.et_passwordinput);
        tv_info = (TextView) findViewById(R.id.tv_info);
        bt_displayinfo = (Button) findViewById(R.id.button_display);
        bt_saveinfo = (Button) findViewById(R.id.button_save);
        bt_saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata();
            }
        });
        bt_displayinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaydata();
            }
        });
    }

    //function to display saved data
    private void displaydata() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String password = preferences.getString("password","");
        tv_info.setText(password);
        tv_info.setVisibility(View.VISIBLE);
    }

    //funtion to save the data
    private void savedata() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("password",et_passowrdinput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }
}