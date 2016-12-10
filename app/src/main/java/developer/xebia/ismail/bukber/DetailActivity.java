package developer.xebia.ismail.bukber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

/**
 * Created by Admin on 5/28/2016.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "title_name";

    private KenBurnsView mImg;


    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView nama = (TextView) findViewById(R.id.nama);
        mImg = (KenBurnsView) findViewById(R.id.backdrop);
    }

    @Override
    protected void onPause() {
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        super.onPause();
    }
}
