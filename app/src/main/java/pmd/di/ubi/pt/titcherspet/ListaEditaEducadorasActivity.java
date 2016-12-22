package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListaEditaEducadorasActivity extends AppCompatActivity{
    ListView lview;
    Button bTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_educadoras);

        lview = (ListView) findViewById(R.id.lvItems);
        bTest = (Button) findViewById(R.id.teste);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onTest(View v){
        Intent intent1 = new Intent(this, EditaEducadorasActivity.class);
        startActivity(intent1);
    }
}
