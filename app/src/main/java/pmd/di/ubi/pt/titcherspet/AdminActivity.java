package pmd.di.ubi.pt.titcherspet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class AdminActivity extends AppCompatActivity{
    ImageButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);


        logout = (ImageButton) findViewById(R.id.logout);
    }

    public void onLogout(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onRegister(View v){
        Intent intent = new Intent(this, RegistoEducadoraActivity.class);
        startActivity(intent);
    }
}
