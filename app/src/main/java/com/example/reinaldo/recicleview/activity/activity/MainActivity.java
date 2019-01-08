package com.example.reinaldo.recicleview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.reinaldo.recicleview.R;
import com.example.reinaldo.recicleview.activity.adapter.Adapter;
import com.example.reinaldo.recicleview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        //Listagem de filmes
        this.criarFilmes();

        //Configurar o adapter
        Adapter adapter = new Adapter();

        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //Pega o objeto recyclerview e seta o layoutManager e  dentro coloca a instancia layoutManager
        recyclerView.setLayoutManager(layoutManager);
        //seta o tamanho do meu recyclerView
        recyclerView.setHasFixedSize(true);
        //Pega o objeto recyvlerView e seta o adaptador
        recyclerView.setAdapter(adapter);
    }

    private void criarFilmes() {

        this.listaFilmes.add(new Filme("Homem Aranha - De volta ao lar","Comedia","1988"));
        this.listaFilmes.add(new Filme("Mulher Maravilha","Fantasia","2017"));
        this.listaFilmes.add(new Filme("Liga da Justiça","Ficção","2017"));
        this.listaFilmes.add(new Filme("Capitão América","Aventura","2018"));
        this.listaFilmes.add(new Filme("IT: A coisa","Drama/Terror","2018"));

    }

}
