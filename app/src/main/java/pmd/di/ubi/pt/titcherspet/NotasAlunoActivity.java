package pmd.di.ubi.pt.titcherspet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class NotasAlunoActivity extends AppCompatActivity{

    private CheckBox cb1y, cb1n, cb2y, cb2n, cb3y, cb3n, cb4y, cb4n, cb5y, cb5n, cb6y, cb6n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas_aluno);

        cb1y = (CheckBox)findViewById(R.id.yes1);
        cb1n = (CheckBox)findViewById(R.id.no1);
        cb2y = (CheckBox)findViewById(R.id.yes2);
        cb2n = (CheckBox)findViewById(R.id.no2);
        cb3y = (CheckBox)findViewById(R.id.yes3);
        cb3n = (CheckBox)findViewById(R.id.no3);
        cb4y = (CheckBox)findViewById(R.id.yes4);
        cb4n = (CheckBox)findViewById(R.id.no4);
        cb5y = (CheckBox)findViewById(R.id.yes5);
        cb5n = (CheckBox)findViewById(R.id.no5);
        cb6y = (CheckBox)findViewById(R.id.yes6);
        cb6n = (CheckBox)findViewById(R.id.no6);

        HashMap postData = new HashMap();
        postData.put("mobile", "android");

        if(!cb1y.isChecked() && !cb1n.isChecked()){
            Toast tosta = Toast.makeText(this, "Tem de inserir se fez xixi ou nao", Toast.LENGTH_LONG);
        }
        if(cb1y.isChecked()){
            postData.put("txtXixi","Sim");
        }else{
            postData.put("txtXixi","Nao");
        }
        if(!cb2y.isChecked() && !cb2n.isChecked()){
            Toast tosta = Toast.makeText(this, "Tem de inserir se fez coco ou nao", Toast.LENGTH_LONG);
        }
        if(cb2y.isChecked()){
            postData.put("txtCoco","Sim");
        }else{
            postData.put("txtCoco","Nao");
        }
        if(!cb3y.isChecked() && !cb3n.isChecked()){
            Toast tosta = Toast.makeText(this, "Tem de inserir se almoçou bem ou nao", Toast.LENGTH_LONG);
        }
        if(cb3y.isChecked()){
            postData.put("txtAlmoco","Sim");
        }else{
            postData.put("txtAlmoco","Nao");
        }
        if(!cb4y.isChecked() && !cb4n.isChecked()){
            Toast tosta = Toast.makeText(this, "Tem de inserir se dormiu ou nao", Toast.LENGTH_LONG);
        }
        if(cb4y.isChecked()){
            postData.put("txtDormiu","Sim");
        }else{
            postData.put("txtDormiu","Nao");
        }
        if(!cb5y.isChecked() && !cb5n.isChecked()){
            Toast tosta = Toast.makeText(this, "Tem de inserir se lanchou ou nao", Toast.LENGTH_LONG);
        }
        if(cb5y.isChecked()){
            postData.put("txtLanchou","Sim");
        }else{
            postData.put("txtLanchou","Nao");
        }
        if(!cb6y.isChecked() && !cb6n.isChecked()){
            Toast tosta = Toast.makeText(this, "Tem de inserir se chorou ou nao", Toast.LENGTH_LONG);
        }
        if(cb6y.isChecked()){
            postData.put("txtChorou","Sim");
        }else{
            postData.put("txtChorou","Nao");
        }
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {

            }
        });
        task.execute("http://192.168.207.235:81/adicionaedu.php");
    }

    public void onSave(View v){
        Toast toast = Toast.makeText(this, "Informações adicionadas com sucesso!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
