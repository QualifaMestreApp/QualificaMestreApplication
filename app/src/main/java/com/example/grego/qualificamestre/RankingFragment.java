package com.example.grego.qualificamestre;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class RankingFragment extends Fragment{

    private RecyclerView mMasterRecyclerView;
    private RankingAdapter mRankingAdapter;
    private RecyclerView.LayoutManager mMasterRvLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ranking, container, false);


        mMasterRecyclerView = rootView.findViewById(R.id.ranking_recycler_view);
        mMasterRecyclerView.setHasFixedSize(true);

        mMasterRvLayoutManager = new LinearLayoutManager(container.getContext());
        mMasterRecyclerView.setLayoutManager(mMasterRvLayoutManager);

        mRankingAdapter = new RankingAdapter();

        //TODO onclickListener para a MasterMainActivity
        //mRankingAdapter.setMasterRecyclerViewCardListener();

        mMasterRecyclerView.setAdapter(mRankingAdapter);

        return rootView;
    }


}
