package cl.ubiobio.laboratorio4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout luser;
    private TextInputLayout lpass;
    private EditText user;
    private EditText pass;

    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private LoginActivity _this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences(getString(R.string.sp_id), MODE_PRIVATE);
        edit = sp.edit();

        _this = this;

        luser = findViewById(R.id.l_user);
        lpass = findViewById(R.id.l_pass);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private void verificar(){
        boolean state = true;

        luser.setError(null);
        lpass.setError(null);

        final String user_str = user.getText().toString();
        final String pass_str = pass.getText().toString();

        if(true){//restriccion user
            state = false;
            luser.setError("Falta o no cumple con algo");
        }

        if(true){//restriccion pass
            state = false;
            lpass.setError("Falta o no cumple con algo");
        }

        if(true/*state*/){
            login(user_str, pass_str);
        }
    }

    private void login(final String user, final String pass){
        //codigo de servicio web
        // si es exitoso guardar el las preferencias de usuario los datos, si no enviar un mensaje con Toast o
        /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
        startActivity(new Intent(_this, MainActivity.class));
        _this.finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                verificar();
                break;
        }
    }
}
