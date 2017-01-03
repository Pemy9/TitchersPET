package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class EditaEducadorasActivity extends AppCompatActivity implements View.OnClickListener, AsyncResponse{

    EditText setName, setEmail, setPassword;
    ImageButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_educadora);

        setName = (EditText)findViewById(R.id.set_name);
        setEmail = (EditText)findViewById(R.id.set_email);
        setPassword = (EditText)findViewById(R.id.set_password);
        register = (ImageButton)findViewById(R.id.saveRegister);

        register.setOnClickListener(this);
    }



    @Override
    public void processFinish(String result) {
        if(result.equals("sucess")){
            Toast toast = Toast.makeText(this, "Educadora editada com sucesso!", Toast.LENGTH_LONG);
            toast.show();
            Intent novo = new Intent(EditaEducadorasActivity.this, ListaEditaEducadorasActivity.class);
            startActivity(novo);
        }
        else if(result.equals("failed")){
            Toast toast = Toast.makeText(this, "Educadora nao foi editada!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public void onClick(View v) {
        String email = getIntent().getStringExtra("email");

        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtEmail", email);
        postData.put("txtEmaill", setEmail.getText().toString());
        postData.put("txtNome", setName.getText().toString());
        postData.put("txtPassword", setPassword.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.207.235:81/editaeducadora.php");
    }
}
