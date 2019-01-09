package com.example.reinaldo.recicleview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.reinaldo.recicleview.R;
import com.example.reinaldo.recicleview.activity.RecyclerItemClickListener;
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
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //Pega o objeto recyclerview e seta o layoutManager e  dentro coloca a instancia layoutManager
        recyclerView.setLayoutManager(layoutManager);
        //seta o tamanho do meu recyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //Pega o objeto recyvlerView e seta o adaptador
        recyclerView.setAdapter(adapter);

        //EVENTO DE CLICK
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(getApplicationContext(), "Filme: "+filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(getApplicationContext(), "Filme: "+filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    private void criarFilmes() {

        this.listaFilmes.add(new Filme("Homem Aranha - De volta ao lar","Comedia","2018"));
        this.listaFilmes.add(new Filme("Mulher Maravilha","Fantasia","2017"));
        this.listaFilmes.add(new Filme("Liga da Justiça","Ficção","2017"));
        this.listaFilmes.add(new Filme("Capitão América","Aventura","2018"));
        this.listaFilmes.add(new Filme("IT: A coisa","Drama/Terror","2018"));

    }

}
