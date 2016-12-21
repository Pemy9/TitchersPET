package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginP extends AppCompatActivity {
    TextView oTView1;
    ImageButton oButton1;
    EditText usarname;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

        oTView1 = (TextView)findViewById(R.id.app_name1);
        oButton1 = (ImageButton) findViewById(R.id.loginButton);
        usarname = (EditText) findViewById(R.id.username) ;
        password = (EditText) findViewById(R.id.password);
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/BlackBoard.ttf");
        oTView1.setTypeface(face);
    }

    public void onLogin(View v){


        final String Email = usarname.getText().toString();
        final String Password = password.getText().toString();



        final Intent intent1 = new Intent(this, AdminActivity.class);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {

                        startActivity(intent1);
                    } else {
                        startActivity(intent1);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(Email, Password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoginP.this);
        queue.add(loginRequest);
    }
}
