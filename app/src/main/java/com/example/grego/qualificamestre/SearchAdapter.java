package com.example.grego.qualificamestre;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private MasterRecyclerViewCardListener mMasterRecyclerViewCardListener;
    private List<Master> masterList;


    private int SEARCH_CARD = 1;
    private int EMPTY_CARD = 2;

    public SearchAdapter(List<Master> masterList) {
        this.masterList = masterList;

    }

    @Override
    public int getItemViewType(int position){
        if(masterList.size() == 0){
            return EMPTY_CARD;
        }
        return SEARCH_CARD;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == SEARCH_CARD) {
            View masterCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card_mastercard,parent,false);
            return new SearchViewHolder(masterCard);
        }
        else {
            View emptyCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_layout,parent,false);
            return new SearchViewHolder(emptyCard);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        int viewType = holder.getItemViewType();
        if(viewType == SEARCH_CARD){

            Master master = masterList.get(position);



            SearchViewHolder mvh = holder;

            mvh.searchName.setText(master.getNome());
            mvh.searchInstitution.setText(master.getInstitution());
            mvh.searchGrade.setText(master.getGrade().toString());
        }
    }

    @Override
    public int getItemCount() {
        if(masterList.size() == 0){
            return 1;
        }
        return masterList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView searchName, searchInstitution, searchGrade;


        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            searchName = itemView.findViewById(R.id.search_master_card_name_field_text_view);
            searchInstitution = itemView.findViewById(R.id.search_master_card_institution_field_text_view);
            searchGrade = itemView.findViewById(R.id.search_master_card_grade_field_text_view);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

        }
    }

    public void setMasterRecyclerViewCardListener(MasterRecyclerViewCardListener m){
        mMasterRecyclerViewCardListener = m;
    }




}





