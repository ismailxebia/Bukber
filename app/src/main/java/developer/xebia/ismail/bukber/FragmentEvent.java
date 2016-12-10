package developer.xebia.ismail.bukber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uk.co.imallan.jellyrefresh.JellyRefreshLayout;

/**
 * Created by Admin on 5/24/2016.
 */
public class FragmentEvent extends Fragment {

    RecyclerView recyclerView;
    private Recycler_ViewAdapter adapter;
    public static SwipeRefreshLayout swipeRefreshLayout;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event, container, false);

        final List<Data> data = fill_with_data();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.event);
        recyclerView.setHasFixedSize(true);
        adapter = new Recycler_ViewAdapter(data, getActivity());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final JellyRefreshLayout jellyLayout = (JellyRefreshLayout) rootView.findViewById(R.id.jelly_refresh);
        jellyLayout.setRefreshListener(new JellyRefreshLayout.JellyRefreshListener() {
            @Override
            public void onRefresh(final JellyRefreshLayout jellyRefreshLayout) {
                jellyRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        jellyRefreshLayout.finishRefreshing();
                    }
                }, 2000);
            }
        });

        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //Create a list of Data objects
    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Batman vs Superman","HELMI ISMAIL",R.drawable.usera, R.drawable.google));
        data.add(new Data("X-Men: Apocalypse","ARRIVAL DWI SENTOSA",R.drawable.userb, R.drawable.rest));
        data.add(new Data("Captain America: Civil War","ALI CORNAN",R.drawable.usera, R.drawable.google));
        data.add(new Data("Zootopia","RIZKY HUSNI ABDILLAH",R.drawable.userb, R.drawable.rest));
        data.add(new Data("Bukber Multimedia","IBNU SINA",R.drawable.usera, R.drawable.google));
        data.add(new Data("Captain America: Civil War","ALI CORNAN",R.drawable.usera, R.drawable.google));
        data.add(new Data("Zootopia","RIZKY HUSNI ABDILLAH",R.drawable.userb, R.drawable.rest));
        data.add(new Data("Bukber Multimedia","IBNU SINA",R.drawable.usera, R.drawable.google));
        data.add(new Data("Captain America: Civil War","ALI CORNAN",R.drawable.usera, R.drawable.google));
        data.add(new Data("Zootopia","RIZKY HUSNI ABDILLAH",R.drawable.userb, R.drawable.rest));
        data.add(new Data("Bukber Multimedia","IBNU SINA",R.drawable.usera, R.drawable.google));
        return data;
    }


}
