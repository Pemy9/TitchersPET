package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AlunoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluno_page);

        getSupportActionBar().setTitle("Aluno x"); //TODO colocar aqui depois o nome do aluno através da BD
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onAddNotes(View v){
        Intent intent1 = new Intent(this, NotasAlunoActivity.class);
        startActivity(intent1);
    }

    public void onEdit(View v){
        Intent intent2 = new Intent(this, EditaAlunoActivity.class);
        startActivity(intent2);
    }
}
