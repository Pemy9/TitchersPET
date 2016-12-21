package pmd.di.ubi.pt.titcherspet;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView oTView1;
    ImageButton oButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        oTView1 = (TextView)findViewById(R.id.app_name1);
        oButton1 = (ImageButton) findViewById(R.id.loginButton);

        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/BlackBoard.ttf");
        oTView1.setTypeface(face);
    }
}
