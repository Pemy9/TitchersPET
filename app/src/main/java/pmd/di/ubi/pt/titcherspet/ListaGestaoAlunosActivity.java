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
import java.util.HashMap;

public class ListaGestaoAlunosActivity extends AppCompatActivity{

    ListView lvAlunos;
    ArrayList<Alunos> listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunos);

        String turma = getIntent().getStringExtra("turma");

        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtNturma", turma);

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(ListaGestaoAlunosActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                listaAlunos = new JsonConverter<Alunos>().toArrayList(s, Alunos.class);
                BindDictionary<Alunos> dict = new BindDictionary<Alunos>();
                dict.addStringField(R.id.tvName, new StringExtractor<Alunos>() {
                            @Override
                            public String getStringValue(Alunos item, int position) {
                                return item.Nome;
                            }
                        });

                FunDapter <Alunos> adapter = new FunDapter<>(ListaGestaoAlunosActivity.this, listaAlunos, R.layout.layout_list, dict);
                lvAlunos = (ListView)findViewById(R.id.lvAlunos);
                lvAlunos.setAdapter(adapter);
                lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Alunos selectAlunos = listaAlunos.get(position);
                        String nome = selectAlunos.Nome;
                        String sexo = selectAlunos.Sexo;
                        String data = selectAlunos.Data_Nascimento;
                        Intent intent = new Intent(ListaGestaoAlunosActivity.this, EditaAlunoActivity.class);
                        intent.putExtra("nome", nome);
                        intent.putExtra("sexo", sexo);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    }
                });
            }
        });
        task1.execute("http://192.168.207.235:81/alunos.php");
    }

    public void onAddAluno(View v){
        Intent intent2 = new Intent(this, RegistoAlunoActivity.class);
        startActivity(intent2);
    }

    public void onTest(View v){
        Intent intent1 = new Intent(this, AlunoActivity.class);
        startActivity(intent1);
    }
}
