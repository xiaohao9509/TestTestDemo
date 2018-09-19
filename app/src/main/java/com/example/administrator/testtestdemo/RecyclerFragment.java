package com.example.administrator.testtestdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends BaseFragment {


    private String title = "RecyclerFragment";

    private RecyclerView recycler;
    private DemoAdapter adapter;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private RecyclerView.OnScrollListener mOnScrollListener;

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        mOnScrollListener = onScrollListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler = (RecyclerView) view.findViewById(R.id.myRecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DemoAdapter(30);
        recycler.setAdapter(adapter);
        if (mOnScrollListener != null) {
            recycler.addOnScrollListener(mOnScrollListener);
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
