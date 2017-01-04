package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AlunoActivity extends AppCompatActivity{

    private TextView set_sexo, set_date, set_email, set_number, set_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluno_page);

        String nome = getIntent().getStringExtra("nome");
        String sexo = getIntent().getStringExtra("sexo");
        String data = getIntent().getStringExtra("data");
        String email = getIntent().getStringExtra("email");
        int numero = getIntent().getIntExtra("numero",0);
        String number = String.valueOf(numero);


        set_sexo = (TextView)findViewById(R.id.a_sex1);
        set_date = (TextView)findViewById(R.id.a_date1);
        set_name = (TextView)findViewById(R.id.a_name1);
        set_email = (TextView)findViewById(R.id.a_email1);
        set_number = (TextView)findViewById(R.id.a_number1);

        set_name.setText(nome);
        set_sexo.setText(sexo);
        set_date.setText(data);
        set_email.setText(email);
        set_number.setText(number);

        getSupportActionBar().setTitle(nome); //TODO colocar aqui depois o nome do aluno através da BD
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onAddNotes(View v){
        Intent intent1 = new Intent(this, NotasAlunoActivity.class);
        startActivity(intent1);
    }

    public void onEdit(View v){
        String nome = getIntent().getStringExtra("nome");
        String sexo = getIntent().getStringExtra("sexo");
        String data = getIntent().getStringExtra("data");
        String email = getIntent().getStringExtra("email");
        int numero = getIntent().getIntExtra("numero",0);
        Intent intent2 = new Intent(this, EditaAlunoActivity.class);

        intent2.putExtra("nome", nome);
        intent2.putExtra("sexo", sexo);
        intent2.putExtra("data", data);
        intent2.putExtra("email", email);
        intent2.putExtra("numero", numero);
        startActivity(intent2);
    }
}
