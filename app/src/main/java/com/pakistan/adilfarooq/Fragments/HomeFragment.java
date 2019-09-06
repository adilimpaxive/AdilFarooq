package com.pakistan.adilfarooq.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pakistan.adilfarooq.Adapter.NewsAdapter;
import com.pakistan.adilfarooq.Model.News;
import com.pakistan.adilfarooq.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private BottomNavigationView mBottomNavigationView;
    private RecyclerView mNewsRecyclerView;
    private NewsAdapter mNewsAdapter;
    private List<News> mNewsList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initRef();
        clickOnView();
        populateList();
    }

    private void clickOnView() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean flag = false;

                switch(item.getItemId()){
                    case R.id.action_home:{
                        flag = true;
                        Toast.makeText(getContext(), "Home", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.action_history:{
                        flag = true;
                        Toast.makeText(getContext(), "History", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.action_profile:{
                        flag = true;
                        Toast.makeText(getContext(), "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.action_settings:{
                        flag = true;
                        Toast.makeText(getContext(), "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:
                        break;
                }

                return flag;
            }
        });
    }

    private void setUpRecyclerView() {

        if(mNewsAdapter == null)
            mNewsAdapter = new NewsAdapter(getContext(), mNewsList);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mNewsRecyclerView.setLayoutManager(llm);
        mNewsRecyclerView.setHasFixedSize(true);
        mNewsRecyclerView.setAdapter(mNewsAdapter);
    }

    private void initRef() {
        mNewsList = new ArrayList<>();
    }

    private void populateList() {

        if(mNewsList.size() > 0)
            mNewsList.clear();

        // Adding Dummy Data
        for(int i = 0; i < 20; i++){
            String image = null;
            String text = Objects.requireNonNull(getContext()).getResources().getString(R.string.lorem);

            News obj = new News(image, text);
            mNewsList.add(obj);
        }

        setUpRecyclerView();
    }

    private void initView(View view) {
        mNewsRecyclerView = view.findViewById(R.id.news_recyclerview);
        mBottomNavigationView = view.findViewById(R.id.main_bottom_nav_view);
    }

}
