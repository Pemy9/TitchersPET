package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    TextView tv1;
    ImageButton oButton1;
    EditText UsernameEt, PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

            tv1 = (TextView) findViewById(R.id.app_name1);
            oButton1 = (ImageButton) findViewById(R.id.loginButton);
            UsernameEt = (EditText) findViewById(R.id.username) ;
            PasswordEt = (EditText) findViewById(R.id.password);

            oButton1.setOnClickListener(this);

        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/BlackBoard.ttf");
        tv1.setTypeface(face);

    }

    @Override
    public void processFinish(String result) {
        //if(result.equals("sucess Admin")){
            Intent admin = new Intent(this, AdminActivity.class);
            startActivity(admin);
        //}
        //else if(result.equals("sucess Educadora")){
        //    Intent educadora = new Intent(this, EducadoraActivity.class);
        //    startActivity(educadora);
        //}
        //else{
        //    Toast.makeText(this, "Mail ou Password incorrectos!", Toast.LENGTH_LONG).show();
        //}
    }


    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtUsername", UsernameEt.getText().toString());
        postData.put("txtPassword", PasswordEt.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.207.235:81/loggin.php");
    }
}

