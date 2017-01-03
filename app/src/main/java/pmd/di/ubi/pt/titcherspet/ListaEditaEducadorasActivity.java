package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaEditaEducadorasActivity extends AppCompatActivity{
    private ListView lvTurmas;
    private ArrayList<Turmas> listaTurmas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_turma);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String email = getIntent().getStringExtra("email");

        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtEmail", email);

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(ListaEditaEducadorasActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                listaTurmas = new JsonConverter<Turmas>().toArrayList(s, Turmas.class);
                BindDictionary<Turmas> dict = new BindDictionary<Turmas>();
                dict.addStringField(R.id.tvName, new StringExtractor<Turmas>() {
                    @Override
                    public String getStringValue(Turmas item, int position) {
                        return item.N_Turma;
                    }
                });

                FunDapter<Turmas> adapter = new FunDapter<>(ListaEditaEducadorasActivity.this, listaTurmas, R.layout.layout_list, dict);
                lvTurmas = (ListView)findViewById(R.id.lvTurmas);
                lvTurmas.setAdapter(adapter);
            }
        });
        task1.execute("http://192.168.207.235:81/turmas.php");


    }



}

