package com.pakistan.adilfarooq.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pakistan.adilfarooq.Adapter.NewsAdapter;
import com.pakistan.adilfarooq.Adapter.ServiceAdapter;
import com.pakistan.adilfarooq.Model.News;
import com.pakistan.adilfarooq.Model.Service;
import com.pakistan.adilfarooq.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {
    private RecyclerView mNewsRecyclerView;
    private ServiceAdapter mServiceAdapter;
    private List<Service> mServicelist;

    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
       /* Locale locale = new Locale("ar-rSA");
        Configuration config = getActivity().getResources().getConfiguration();
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config,getActivity().getResources().getDisplayMetrics());*/

        initView(view);
        initRef();
        populateList();
    }

    private void setUpRecyclerView() {

        if (mServiceAdapter == null)
            mServiceAdapter = new ServiceAdapter(getContext(), mServicelist);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mNewsRecyclerView.setLayoutManager(llm);
        mNewsRecyclerView.setHasFixedSize(true);
        mNewsRecyclerView.setAdapter(mServiceAdapter);
    }

    private void initRef() {
        mServicelist = new ArrayList<>();
    }

    private void populateList() {

        if (mServicelist.size() > 0)
            mServicelist.clear();

        // Adding Dummy Data
        for (int i = 0; i < 20; i++) {
          int image = Integer.parseInt(null);
          int text = Integer.parseInt(Objects.requireNonNull(getContext()).getResources().getString(R.string.lorem));

            Service obj = new Service(image, text);
            mServicelist.add(obj);
        }

        setUpRecyclerView();
    }


    private void initView(View view) {
        mNewsRecyclerView = view.findViewById(R.id.news_recyclerview);


    }
}
