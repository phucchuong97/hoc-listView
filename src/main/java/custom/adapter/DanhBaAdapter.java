package custom.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.danhba_layout,null);

            viewHolder = new ViewHolder();
            viewHolder.txtTen = convertView.findViewById(R.id.txtTen);
            viewHolder.txtSDT = convertView.findViewById(R.id.txtSDT);
            convertView.setTag(viewHolder);
            Log.d("Position ","position "+(position+1));
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        DanhBa danhBa = objects.get(position);
        viewHolder.txtTen.setText(danhBa.getTen());
        viewHolder.txtSDT.setText(danhBa.getSdt());

        return convertView;

    }

    public class ViewHolder{
        TextView txtTen;
        TextView txtSDT;
    }
}
