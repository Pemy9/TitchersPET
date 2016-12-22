package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class EditaEducadorasActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_educadora);

        getSupportActionBar().setTitle("Educadora x"); //TODO colocar aqui depois o nome da educadora através da BD
    }

    public void onSaveEdit(View v){
            Toast toast = Toast.makeText(this, "Educadora editada com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
    }
}
