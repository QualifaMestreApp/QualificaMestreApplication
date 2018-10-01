package com.example.grego.qualificamestre;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.MasterViewHolder>{

    private MasterRecyclerViewCardListener mMasterRecyclerViewCardListener;
    private List<DataSnapshot> snapshotList;
    private FirebaseDatabase firebaseInstance;
    private DatabaseReference firebaseReference;
    private String MASTER_PATH = "Professores";
    private int NORMAL_CARD = 1;
    private int EMPTY_CARD = 2;

    public RankingAdapter() {
        this.snapshotList = new ArrayList<>();

        firebaseInstance = FirebaseDatabase.getInstance();
        firebaseReference = firebaseInstance.getReference(MASTER_PATH);

        firebaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                addUser(dataSnapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public int getItemViewType(int position){
        if(snapshotList.size() == 0){
            return EMPTY_CARD;
        }
        return NORMAL_CARD;
    }

    @NonNull
    @Override
    public MasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == NORMAL_CARD) {
            View masterCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mastercard,parent,false);
            return new MasterViewHolder(masterCard);
        }
        else {
            View emptyCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_layout,parent,false);
            return new MasterViewHolder(emptyCard);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MasterViewHolder holder, int position) {

        int viewType = holder.getItemViewType();
        if(viewType == NORMAL_CARD){

            DataSnapshot masterSnapshot = snapshotList.get(position);

            Master master = masterSnapshot.getValue(Master.class);


            MasterViewHolder mvh = holder;

            mvh.name.setText(master.name);
            mvh.institution.setText(master.institution);
            mvh.voters.setText(master.grade.toString());
        }
    }

    @Override
    public int getItemCount() {
        if(snapshotList.size() == 0){
            return 1;
        }
        return snapshotList.size();
    }

    public class MasterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView name, institution, voters;


        public MasterViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.master_card_name_field_text_view);
            institution = itemView.findViewById(R.id.master_card_institution_field_text_view);
            voters = itemView.findViewById(R.id.master_card_voters_field_text_view);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

        }
    }

    public void setMasterRecyclerViewCardListener(MasterRecyclerViewCardListener m){
        mMasterRecyclerViewCardListener = m;
    }

    public void addUser(DataSnapshot dataSnapshot){
        snapshotList.add(0,dataSnapshot);
        notifyDataSetChanged();
    }


}





