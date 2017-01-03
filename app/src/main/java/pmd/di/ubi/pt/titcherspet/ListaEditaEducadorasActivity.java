package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;

public class ListaEditaEducadorasActivity extends AppCompatActivity implements AsyncResponse{
    private ListView lvTurmas;
    private ArrayList<Turmas> listaTurmas;
    private ImageButton onRegisterTurmas;

    final String LOG = "ListaEditaEducadorasActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_turma);

        onRegisterTurmas = (ImageButton)findViewById(R.id.registerTurma);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String email = getIntent().getStringExtra("email");

        PostResponseAsyncTask novaTask = new PostResponseAsyncTask(ListaEditaEducadorasActivity.this, this);
        novaTask.execute("http://192.168.1.67:81/turmas.php");
    }


    @Override
    public void processFinish(String s) {
        listaTurmas = new JsonConverter<Turmas>().toArrayList(s, Turmas.class);
        BindDictionary<Turmas> bindDictionary = new BindDictionary<Turmas>();
        bindDictionary.addStringField(R.id.tvName, new StringExtractor<Turmas>() {
            @Override
            public String getStringValue(Turmas item, int position) {
                return item.N_Turma;
            }
        });
        FunDapter<Turmas> dapter = new FunDapter<>(ListaEditaEducadorasActivity.this, listaTurmas, R.layout.layout_list, bindDictionary);
        lvTurmas = (ListView)findViewById(R.id.lvTurmas);
        lvTurmas.setAdapter(dapter);
        lvTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Turmas selectTurma = listaTurmas.get(position);
                //String email = selectTurma.Email;
                Intent intent = new Intent(ListaEditaEducadorasActivity.this, EditaEducadorasActivity.class);
                startActivity(intent);
            }
        });
    }
}


//HashMap postData = new HashMap();
//postData.put("mobile", "android");
//postData.put("txtEmail", email);
//PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
//task.execute("http://192.168.1.67:81/turmas.php");