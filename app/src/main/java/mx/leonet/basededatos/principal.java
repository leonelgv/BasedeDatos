package mx.leonet.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class principal extends ActionBarActivity {

    EditText et_idusuario, et_user, et_password, et_nombre, et_apellidop, et_apellidom, et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        et_idusuario = (EditText) findViewById(R.id.et_idusuario);
        et_user = (EditText) findViewById(R.id.et_user);
        et_password = (EditText) findViewById(R.id.et_password);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_apellidop = (EditText) findViewById(R.id.et_apellidop);
        et_apellidom = (EditText) findViewById(R.id.et_apellidom);
        et_email = (EditText) findViewById(R.id.et_email);

    }

    public void alta (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String idusuario = et_idusuario.getText().toString();
        String user = et_user.getText().toString();
        String password = et_password.getText().toString();
        String nombre = et_nombre.getText().toString();
        String apellidop = et_apellidop.getText().toString();
        String apellidom = et_apellidom.getText().toString();
        String email = et_email.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("id_usuario", idusuario);
        registro.put("user", user);
        registro.put("password", password);
        registro.put("nombre", nombre);
        registro.put("apellido_p", apellidop);
        registro.put("apellido_m", apellidom);
        registro.put("email", email);

        bd.insert("usuarios", null, registro);
        bd.close();

        et_idusuario.setText("");
        et_user.setText("");
        et_password.setText("");
        et_nombre.setText("");
        et_apellidop.setText("");
        et_apellidom.setText("");
        et_email.setText("");

        Toast.makeText(this,"Se agrego un nuevo usuario",Toast.LENGTH_SHORT).show();

    }

    public void consulta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String idusuario = et_idusuario.getText().toString();
        Cursor fila = bd.rawQuery("select user, password, nombre, apellido_p, apellido_m, email from usuarios where id_usuario=" + idusuario, null);
        if (fila.moveToFirst()) {
            et_user.setText(fila.getString(0));
            et_password.setText(fila.getString(1));
            et_nombre.setText(fila.getString(2));
            et_apellidop.setText(fila.getString(3));
            et_apellidom.setText(fila.getString(4));
            et_email.setText(fila.getString(5));
        } else {
            Toast.makeText(this,"No existe el usuario",Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void baja(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String idusuario = et_idusuario.getText().toString();
        int cant = bd.delete("usuarios","id_usuario=" + idusuario, null);
        bd.close();

        et_idusuario.setText("");
        et_user.setText("");
        et_password.setText("");
        et_nombre.setText("");
        et_apellidop.setText("");
        et_apellidom.setText("");
        et_email.setText("");

        if (cant == 1) {
            Toast.makeText(this, "Se borró el usuario",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe el usuario",Toast.LENGTH_SHORT).show();
        }
    }

    public void modificacion (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String idusuario = et_idusuario.getText().toString();
        String user = et_user.getText().toString();
        String password = et_password.getText().toString();
        String nombre = et_nombre.getText().toString();
        String apellidop = et_apellidop.getText().toString();
        String apellidom = et_apellidom.getText().toString();
        String email = et_email.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("id_usuario", idusuario);
        registro.put("user", user);
        registro.put("password", password);
        registro.put("nombre", nombre);
        registro.put("apellido_p", apellidop);
        registro.put("apellido_m", apellidom);
        registro.put("email", email);

        int cant = bd.update("usuarios", registro, "id_usuario=" + idusuario, null);
        bd.close();

        if (cant == 1) {
            Toast.makeText(this, "Se modificaron los datos del usuario",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe el usuario",Toast.LENGTH_SHORT).show();
        }

    }

    public void limpia (View v){
        et_idusuario.setText("");
        et_user.setText("");
        et_password.setText("");
        et_nombre.setText("");
        et_apellidop.setText("");
        et_apellidom.setText("");
        et_email.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
