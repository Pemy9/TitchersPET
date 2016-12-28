package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView oTView1;
    ImageButton oButton1;
    EditText UsernameEt, PasswordEt;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

        oTView1 = (TextView)findViewById(R.id.app_name1);
        oButton1 = (ImageButton) findViewById(R.id.loginButton);
        UsernameEt = (EditText) findViewById(R.id.username) ;
        PasswordEt = (EditText) findViewById(R.id.password);

        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/BlackBoard.ttf");
        oTView1.setTypeface(face);
    }

    public void onLogin(View v){

        if(TextUtils.isEmpty(UsernameEt.getText().toString())){
            UsernameEt.setError("Não inseriu o username!");
            return;
        }
        String username = UsernameEt.getText().toString();

        if(TextUtils.isEmpty(PasswordEt.getText().toString())){
            PasswordEt.setError("Não inseriu a password!");
            return;
        }
        String password = PasswordEt.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this, res);
        backgroundWorker.execute(type, username, password);
    }

}
