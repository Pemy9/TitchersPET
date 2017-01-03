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

public class RegistoEducadoraActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener{

    private ImageButton saveRegister;
    private EditText setNome, setEmail, setPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo_educadoras);

        setEmail = (EditText)findViewById(R.id.set_email);
        setNome = (EditText)findViewById(R.id.set_name);
        setPassword = (EditText)findViewById(R.id.set_password);
        saveRegister = (ImageButton)findViewById(R.id.saveRegister);

        saveRegister.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if(result.equals("sucess")){
            Toast toast = Toast.makeText(this, "Educadora registada com sucesso!", Toast.LENGTH_LONG);
            toast.show();
            Intent novo = new Intent(RegistoEducadoraActivity.this, ListaGestaoEducadorasActivity.class);
            startActivity(novo);
        }
        else if(result.equals("failed")){
            Toast toast = Toast.makeText(this, "Educadora nao foi registada!", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtNome", setNome.getText().toString());
        postData.put("txtEmail", setEmail.getText().toString());
        postData.put("txtPassword", setPassword.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.207.235:81/adicionaedu.php");
    }


}
