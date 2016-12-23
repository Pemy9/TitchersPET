package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class AdminActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);

    }

    public void onLogout(View v){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    public void onRegister(View v){
        Intent intent2 = new Intent(this, RegistoEducadoraActivity.class);
        startActivity(intent2);
    }

    public void onEdit(View v){
        Intent intent3 = new Intent(this, ListaEditaEducadorasActivity.class);
        startActivity(intent3);
    }

    public void onManage(View v){
        Intent intent4 = new Intent(this, ListaGestaoEducadorasActivity.class);
        startActivity(intent4);
    }

}
