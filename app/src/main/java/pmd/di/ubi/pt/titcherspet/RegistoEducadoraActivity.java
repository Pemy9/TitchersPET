package pmd.di.ubi.pt.titcherspet;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegistoEducadoraActivity extends AppCompatActivity{

    ImageButton saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo_educadoras);

        saveButton = (ImageButton) findViewById(R.id.register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSave(View v){
        Toast toast = Toast.makeText(this, "Educadora registada com sucesso!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
