package br.org.catolicasc.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Button btnAdd = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO DAO = new DAO(NewBook.this);
                EditText etTitle = findViewById(R.id.etTitle);
                EditText etAuthor = findViewById(R.id.etAuthor);
                EditText etPublisher = findViewById(R.id.etPublisher);

                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String publisher = etPublisher.getText().toString();

                if (DAO.insert(title, author, publisher)) {
                    Toast.makeText(NewBook.this,
                            "Registro Inserido com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewBook.this,
                            "Erro ao inserir registro!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
