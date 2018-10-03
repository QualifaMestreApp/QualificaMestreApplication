package com.example.grego.qualificamestre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchFragment extends Fragment implements View.OnClickListener{

    private FirebaseDatabase firebaseInstance;
    private DatabaseReference firebaseReference;
    private String MASTER_PATH = "Professores";
    private Button search;
    private RecyclerView mMasterSearchRecyclerView;
    private SearchAdapter mSearchAdapter;
    private RecyclerView.LayoutManager mMasterRvLayoutManager;
    private List<DataSnapshot> snapshotList;
    private List<Master> masterList;
    private EditText searchText;
    private OnFragmentCardClickListener fragmentCardClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        mMasterSearchRecyclerView = rootView.findViewById(R.id.search_recycler_view);
        mMasterSearchRecyclerView.setHasFixedSize(true);

        mMasterRvLayoutManager = new LinearLayoutManager(getActivity());
        mMasterSearchRecyclerView.setLayoutManager(mMasterRvLayoutManager);

        //TODO onclickListener para a MasterMainActivity
        //mRankingAdapter.setMasterRecyclerViewCardListener();

        search = rootView.findViewById(R.id.search_button);
        searchText = rootView.findViewById(R.id.search_frag_search_edit_text);

        search.setOnClickListener(this);




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

    @Override
    public void onClick(View v) {

        masterList = new ArrayList<>();

        String search = searchText.getText().toString();

        firebaseInstance = FirebaseDatabase.getInstance();
//        firebaseReference = firebaseInstance.getReference(MASTER_PATH);


        if (search != "") {

            Query searchQuery = FirebaseDatabase.getInstance()
                    .getReference("Professores")
                    .orderByChild("nome")
                    .equalTo(search);

            searchQuery.addListenerForSingleValueEvent(valueEventListener);


        }

        if (masterList != null){
        mSearchAdapter = new SearchAdapter(masterList, fragmentCardClickListener);
        mMasterSearchRecyclerView.setAdapter(mSearchAdapter);
        }
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot professores: dataSnapshot.getChildren()
                    ) {
                Master master = professores.getValue(Master.class);
                masterList.add(master);
            }
            mSearchAdapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };






}
