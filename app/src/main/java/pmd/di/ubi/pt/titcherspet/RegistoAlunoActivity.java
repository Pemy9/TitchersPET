package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class RegistoAlunoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo_aluno);

    }

    public void onSave(View v){
        Toast toast = Toast.makeText(this, "Aluno registado com sucesso!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
