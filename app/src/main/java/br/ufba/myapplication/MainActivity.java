package br.ufba.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private EditText txtTelefone;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "meuapp")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
    }

    public void inserir(View v) {
        Contato contato = new Contato();
        contato.nome = txtNome.getText().toString();
        contato.telefone = txtTelefone.getText().toString();
        db.contatoDao().insert(contato);
        Toast.makeText(this, "Contato criado", Toast.LENGTH_SHORT).show();
    }
    public void listar(View v) {
        List<Contato> contatos = db.contatoDao().getAll();
        for (Contato contato : contatos) {
            Log.d("meuapp", "" + contato.uid + ": " + contato.nome + " - " + contato.telefone);
        }
    }
}