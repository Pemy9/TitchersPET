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

import static pmd.di.ubi.pt.titcherspet.R.id.set_sexo;

public class RegistoAlunoActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener{


    private ImageButton save;
    private EditText setNumber, setNome, setEmail_e, setData_Nascimento, setSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo_aluno);

        setNumber = (EditText) findViewById(R.id.set_number);
        setEmail_e = (EditText) findViewById(R.id.set_email_ed);
        setNome = (EditText) findViewById(R.id.set_name);
        setData_Nascimento = (EditText) findViewById(R.id.set_date);
        setSexo = (EditText) findViewById(set_sexo);

        save = (ImageButton) findViewById(R.id.save);

        save.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("sucess")) {
            Toast toast = Toast.makeText(this, "Aluno registado com sucesso!", Toast.LENGTH_LONG);
            toast.show();
            Intent novo = new Intent(RegistoAlunoActivity.this, AlunoActivity.class);
            startActivity(novo);
        } else if (result.equals("failed")) {
            Toast toast = Toast.makeText(this, "Aluno nao foi registado!", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtNome", setNome.getText().toString());
        postData.put("txtNumber", setNumber.getText().toString());
        postData.put("txtSexo", setSexo.getText().toString());
        postData.put("txtEmail_e", setEmail_e.getText().toString());
        postData.put("txtEmail_e", setEmail_e.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.207.235:81/adicionaaluno.php");
    }
}
