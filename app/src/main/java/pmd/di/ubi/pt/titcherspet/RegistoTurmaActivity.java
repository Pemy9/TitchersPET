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

public class RegistoTurmaActivity extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    private ImageButton register;
    private EditText set_N_Turma, set_Email, set_N_Aluno, set_Sala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo_aluno);

        set_N_Turma = (EditText) findViewById(R.id.set_number);
        set_Email = (EditText) findViewById(R.id.set_name);
        set_N_Aluno = (EditText) findViewById(R.id.set_name);
        set_Sala = (EditText) findViewById(R.id.set_sala);


        register = (ImageButton) findViewById(R.id.register);

        register.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("sucess")) {
            Toast toast = Toast.makeText(this, "Aluno registado com sucesso!", Toast.LENGTH_LONG);
            toast.show();
            Intent novo = new Intent(RegistoTurmaActivity.this, ListaGestaoTurmaActivity.class);
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
        postData.put("txtEmail", set_Email.getText().toString());
        postData.put("txtTurma", set_N_Turma.getText().toString());
        postData.put("txtNaluno", set_N_Aluno.getText().toString());
        postData.put("txtSala", set_Sala.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.207.235:81/adicionaturma.php");
    }
}
