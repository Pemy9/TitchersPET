package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistoTurmaActivity extends AppCompatActivity{

    private EditText nomeTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo_turma);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onSave(View v){
        Toast toast = Toast.makeText(this, "Turma adicionada com sucesso!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
