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

public class EditaAlunoActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener{

    private ImageButton save;
    private EditText set_sexo, set_date, set_email_ed, set_number, set_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_aluno);

        String email = getIntent().getStringExtra("email");
        String nome = getIntent().getStringExtra("nome");
        String data = getIntent().getStringExtra("data");
        String sexo = getIntent().getStringExtra("sexo");
        String numero = getIntent().getStringExtra("numero");

        save = (ImageButton)findViewById(R.id.save);
        set_sexo = (EditText)findViewById(R.id.set_sexo);
        set_date = (EditText)findViewById(R.id.set_date);
        set_name = (EditText)findViewById(R.id.set_name);

        set_sexo.setText(sexo);
        set_name.setText(nome);
        set_date.setText(data);

        save.setOnClickListener(this);

    }


    @Override
    public void processFinish(String result) {
        if(result.equals("sucess")){
            Toast toast = Toast.makeText(this, "Aluno editado com sucesso!", Toast.LENGTH_LONG);
            toast.show();
            Intent novo = new Intent(EditaAlunoActivity.this, ListaGestaoAlunosActivity.class);
            startActivity(novo);
        }
        else if(result.equals("failed")){
            Toast toast = Toast.makeText(this, "Aluno nao foi editado!", Toast.LENGTH_LONG);
            toast.show();
            Intent novo = new Intent(EditaAlunoActivity.this, ListaGestaoAlunosActivity.class);
            startActivity(novo);
        }
    }

    @Override
    public void onClick(View v) {
        String nome = getIntent().getStringExtra("nome");

        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtName", nome);
        postData.put("txtNome", set_name.getText().toString());
        postData.put("txtSexo", set_sexo.getText().toString());
        postData.put("txtData", set_date.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.207.235:81/editaaluno.php");
    }
}
