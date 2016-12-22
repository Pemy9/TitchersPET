package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AlunoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluno_page);

        getSupportActionBar().setTitle("Aluno x"); //TODO colocar aqui depois o nome da educadora através da BD
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
