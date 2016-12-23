package pmd.di.ubi.pt.titcherspet;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EducadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.educadora_page);

    }

    public void onManage(View v){
        Intent intent = new Intent(this, ListaGestaoTurmaActivity.class);
        startActivity(intent);
    }

    public void onLogout(View v){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
