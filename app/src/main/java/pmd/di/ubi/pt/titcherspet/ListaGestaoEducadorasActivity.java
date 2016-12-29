package pmd.di.ubi.pt.titcherspet;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListaGestaoEducadorasActivity extends AppCompatActivity {


        private String jsonResult;
        private String url = "http://192.168.137.1/app/educadoras1.php";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_educadoras_manage);
        listView = (ListView) findViewById(R.id.lv);
    }


}