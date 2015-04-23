package mx.leonet.basededatos;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by L3oNeT on 23/04/15.
 */
public class usuariosAdaptador extends RecyclerView.Adapter<usuariosAdaptador.usuariosViewHolder> {

    private List<usuarios> items;

    public static class usuariosViewHolder extends RecyclerView.ViewHolder {

        public TextView idusuario;
        public TextView usuario;
        public TextView password;
        public TextView nombre;
        public TextView apellidop;
        public TextView apellidom;
        public TextView email;


        public usuariosViewHolder(View v) {
            super(v);
            //idusuario = (TextView) v.findViewById(R.id.id_usuario);
        }
    }

    @Override
    public usuariosAdaptador.usuariosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(usuariosAdaptador.usuariosViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
