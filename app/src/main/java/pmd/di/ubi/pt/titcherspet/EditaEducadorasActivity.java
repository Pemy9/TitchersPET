package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class EditaEducadorasActivity extends AppCompatActivity{

    EditText setName, setEmail, setPassword;
    ImageButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edita_educadora);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    public void onSaveEdit(View v){
            Toast toast = Toast.makeText(this, "Educadora editada com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
    }
}
