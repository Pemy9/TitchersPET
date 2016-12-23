package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class NotasAlunoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas_aluno);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        //ratingBar.getRating();
    }

    public void onSave(View v){
        Toast toast = Toast.makeText(this, "Informações adicionadas com sucesso!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
