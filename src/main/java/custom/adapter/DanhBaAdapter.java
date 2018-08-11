package custom.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.npc.luyentap_listview.R;

import java.util.List;

import model.DanhBa;

public class DanhBaAdapter extends ArrayAdapter<DanhBa>{

    Activity context;
    int resource;
    List<DanhBa> objects;

    public DanhBaAdapter(@NonNull Activity context, int resource, @NonNull List<DanhBa> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        DanhBa danhBa = this.objects.get(position);
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtSDT = row.findViewById(R.id.txtSDT);

        txtTen.setText(danhBa.getTen());
        txtSDT.setText(danhBa.getSdt());




        return row;
    }
}
