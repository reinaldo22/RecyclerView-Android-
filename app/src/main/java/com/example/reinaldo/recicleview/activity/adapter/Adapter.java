package com.example.reinaldo.recicleview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reinaldo.recicleview.R;
import com.example.reinaldo.recicleview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilme;

    //Enviado para o mainActivity
    public Adapter(List<Filme> lista) {

        this.listaFilme = lista;
    }

    @Override //cria a tela ou seja ele infla o meu xml
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //cria uma variavel do tipo view e infla meu adapter_lista.xml e retorna a instancia
        //do meu objeto da classe MyViewHolder passando a variavel que precisa ser do tipo view
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista, viewGroup, false);


        return new MyViewHolder(itemLista);
    }

    //Ele mostra o que vai ser visualizado
    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {

        Filme filme = listaFilme.get(i);

        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
        holder.titulo.setText(filme.getTituloFilme());
    }

    //Ele me da quantos views será visualizado
    @Override
    public int getItemCount() {
        return listaFilme.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo, ano, genero;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
