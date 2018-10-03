package com.example.grego.qualificamestre;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class RankingFragment extends Fragment{

    private RecyclerView mMasterRecyclerView;
    private RankingAdapter mRankingAdapter;
    private RecyclerView.LayoutManager mMasterRvLayoutManager;
    private List<DataSnapshot> snapshotList;
    private OnFragmentCardClickListener fragmentCardClickListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ranking, container, false);


        mMasterRecyclerView = rootView.findViewById(R.id.ranking_recycler_view);
        mMasterRecyclerView.setHasFixedSize(true);

        mMasterRvLayoutManager = new LinearLayoutManager(getActivity());
        mMasterRecyclerView.setLayoutManager(mMasterRvLayoutManager);

        snapshotList = new ArrayList<>();
        mRankingAdapter = new RankingAdapter(snapshotList, fragmentCardClickListener);

        mMasterRecyclerView.setAdapter(mRankingAdapter);



        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentCardClickListener){
            fragmentCardClickListener = (OnFragmentCardClickListener) context;
        }
        else {
            Toast.makeText(context, "Deu Ruim", Toast.LENGTH_SHORT).show();
            throw new ClassCastException();
        }
    }


}
