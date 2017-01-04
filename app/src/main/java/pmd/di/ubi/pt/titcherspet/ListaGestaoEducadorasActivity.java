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

public class ListaGestaoEducadorasActivity extends AppCompatActivity{

        private ListView lvEducadoras;
        private ArrayList<Educadoras> listaEducadoras;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lista_educadoras_manage);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            PostResponseAsyncTask taskRead = new PostResponseAsyncTask(ListaGestaoEducadorasActivity.this, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    listaEducadoras = new JsonConverter<Educadoras>().toArrayList(s, Educadoras.class);
                    BindDictionary<Educadoras> dict = new BindDictionary<Educadoras>();
                    dict.addStringField(R.id.tvName, new StringExtractor<Educadoras>() {
                        @Override
                        public String getStringValue(Educadoras educadora, int position) {
                            return educadora.Nome;
                        }
                    });


                    FunDapter<Educadoras> adapter = new FunDapter<>(
                            ListaGestaoEducadorasActivity.this, listaEducadoras, R.layout.layout_list, dict);

                    lvEducadoras = (ListView)findViewById(R.id.lvEducadoras);
                    lvEducadoras.setAdapter(adapter);
                    lvEducadoras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Educadoras selectEducadora = listaEducadoras.get(position);
                            String email = selectEducadora.Email;
                            Intent intent = new Intent(ListaGestaoEducadorasActivity.this, ListaGestaoTurmaActivity.class);
                            intent.putExtra("email", email);
                            startActivity(intent);
                        }
                    });
                }
            });

            taskRead.execute("http://192.168.207.235:81/educadoras.php");

        }
}