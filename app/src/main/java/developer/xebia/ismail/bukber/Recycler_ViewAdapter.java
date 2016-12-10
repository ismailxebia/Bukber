package developer.xebia.ismail.bukber;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Helmi on 5/27/2016.
 */
public class Recycler_ViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Data> list = Collections.emptyList();
    Context context;

    public Recycler_ViewAdapter(List<Data> list,Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_event, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder,int position) {
        holder.title.setText(list.get(position).title);
        holder.nama.setText(list.get(position).nama);
        holder.user.setImageResource(list.get(position).userId);
        holder.image.setImageResource(list.get(position).imageId);

        animate(holder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Insert a new item to the RecyclerView
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public  void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAlpha = AnimationUtils.loadAnimation(context, R.anim.activity_open_translate_from_bottom);
        viewHolder.itemView.setAnimation(animAlpha);
    }
}
