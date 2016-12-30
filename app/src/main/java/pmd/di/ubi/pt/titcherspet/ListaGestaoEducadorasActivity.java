package pmd.di.ubi.pt.titcherspet;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pmd.di.ubi.pt.titcherspet.model.EducadoraNome;

public class ListaGestaoEducadorasActivity extends AppCompatActivity implements LoadJSONTask.Listener, AdapterView.OnItemClickListener{

    private String URL = "http://192.168.137.1:81/educadoras1.php";
    private ListView listView;

    private List<HashMap<String, String>> mMapList = new ArrayList<>();
    private static final String KEY_NAME = "Nome";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_educadoras_manage);
        listView = (ListView) findViewById(R.id.lv);
        listView.setOnItemClickListener(this);
        new LoadJSONTask(this).execute(URL);
    }

    @Override
    public void onLoaded(List<EducadoraNome> edList) {

        for (EducadoraNome ed : edList) {

            HashMap<String, String> map = new HashMap<>();

            map.put(KEY_NAME, ed.getNome());

            mMapList.add(map);
        }

        loadListView();
    }

    @Override
    public void onError() {

        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, mMapList.get(i).get(KEY_NAME),Toast.LENGTH_LONG).show();
    }

    private void loadListView() {

        ListAdapter adapter = new SimpleAdapter(ListaGestaoEducadorasActivity.this, mMapList, R.layout.list_db,
                new String[] { KEY_NAME },
                new int[] { R.id.ed_name });

        listView.setAdapter(adapter);

    }
}