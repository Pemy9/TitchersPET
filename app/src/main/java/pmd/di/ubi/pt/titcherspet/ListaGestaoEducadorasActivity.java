package pmd.di.ubi.pt.titcherspet;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class ListaGestaoEducadorasActivity extends AppCompatActivity{
    ListView lview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_educadoras);

        lview = (ListView) findViewById(R.id.lvItems2);

        getSupportActionBar().setTitle("Educadoras");
    }

    public void onTest(View v){
        Intent intent1 = new Intent(this, ListaGestaoTurmaActivity.class);
        startActivity(intent1);
    }
}
