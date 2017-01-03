package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;

public class ListaGestaoTurmaActivity extends AppCompatActivity{

    private ListView lvTurmas;
    private ArrayList<Turmas> listaTurmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_turma);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PostResponseAsyncTask taskReadTurma = new PostResponseAsyncTask(ListaGestaoTurmaActivity.this, new AsyncResponse() {
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


                FunDapter<Turmas> adapter = new FunDapter<>(
                        ListaGestaoTurmaActivity.this, listaTurmas, R.layout.layout_list, dict);

                lvTurmas = (ListView)findViewById(R.id.lvTurmas);
                lvTurmas.setAdapter(adapter);
                lvTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Turmas selectTurma = listaTurmas.get(position);
                        Intent intent = new Intent(ListaGestaoTurmaActivity.this, EditaEducadorasActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        taskReadTurma.execute("http://192.168.1.67:81/turmas.php");

    }


    public void onAddClass(View v){
        Intent intent2 = new Intent(this, RegistoTurmaActivity.class);
        startActivity(intent2);
    }

    public void onTest(View v){
        Intent intent1 = new Intent(this, ListaGestaoAlunosActivity.class);
        startActivity(intent1);
    }
}
