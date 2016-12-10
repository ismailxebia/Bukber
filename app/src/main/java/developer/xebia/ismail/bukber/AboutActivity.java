package developer.xebia.ismail.bukber;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Admin on 6/4/2016.
 */
public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.kosong);
        ab.setDisplayHomeAsUpEnabled(true);

        CardView web = (CardView)findViewById(R.id.cardabout);
        web.setOnClickListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardabout:
                Intent browser1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://odt.web.id/"));
                startActivity(browser1);
                break;
        }
    }
}
