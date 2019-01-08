package com.example.reinaldo.recicleview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reinaldo.recicleview.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {



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

        holder.genero.setText("Comédia");
        holder.ano.setText("2018");
        holder.titulo.setText("Titulo de Teste");
    }

    //Ele me da quantos views será visualizado
    @Override
    public int getItemCount() {
        return 5;
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
