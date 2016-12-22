package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.scalified.fab.ActionButton;

public class ListaGestaoTurmaActivity extends AppCompatActivity{
    ListView lview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_turma);

        lview = (ListView) findViewById(R.id.lvItems3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionButton actionButton = (ActionButton) findViewById(R.id.action_button);

        actionButton.show();
        actionButton.setButtonColor(ContextCompat.getColor(this, R.color.colorPrimary));
        actionButton.setButtonColorPressed(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        actionButton.setImageResource(R.drawable.fab_plus_icon);
        actionButton.setShadowResponsiveEffectEnabled(true);
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
