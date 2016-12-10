package developer.xebia.ismail.bukber;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import it.dex.movingimageviewlib.DexMovingImageView;

/**
 * Created by Helmi on 5/27/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public String mBoundString;

    CardView cv;
    TextView title, nama;
    ImageView user;
    DexMovingImageView image;

    public Data data;

    ViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardview);
        title = (TextView) itemView.findViewById(R.id.title);
        nama = (TextView) itemView.findViewById(R.id.nama);
        user = (ImageView) itemView.findViewById(R.id.user);
        image = (DexMovingImageView) itemView.findViewById(R.id.image);

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                v.getContext().startActivity(intent);
                //Bundle extras = new Bundle();
                //extras.putInt("position",getAdapterPosition());
                //intent.putExtras(extras);
                //Toast.makeText(v.getContext(), "Kamu Click " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(v.getContext(), "Kamu Long Click " + getPosition(), Toast.LENGTH_SHORT).show();

                return true;

            }
        });
    }
}
