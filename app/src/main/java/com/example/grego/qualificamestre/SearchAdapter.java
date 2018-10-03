package com.example.grego.qualificamestre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{


    private List<Master> masterList;
    private OnFragmentCardClickListener fragmentCardClickListener;


    private int SEARCH_CARD = 1;
    private int EMPTY_CARD = 2;

    public SearchAdapter(List<Master> masterList, OnFragmentCardClickListener fragmentCardClickListener) {
        this.masterList = masterList;
        this.fragmentCardClickListener = fragmentCardClickListener;

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
//            if(master.getGrade() != null){
//                mvh.searchGrade.setText(master.getGrade().toString());
//            }else {
//                mvh.searchGrade.setText("0");
//            }
        }
    }

    @Override
    public int getItemCount() {
        if(masterList.size() == 0){
            return 1;
        }
        return masterList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {


        TextView searchName, searchInstitution, searchGrade;


        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            searchName = itemView.findViewById(R.id.search_master_card_name_field_text_view);
            searchInstitution = itemView.findViewById(R.id.search_master_card_institution_field_text_view);
            searchGrade = itemView.findViewById(R.id.search_master_card_grade_field_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fragmentCardClickListener != null){
                         Master master = masterList.get(getAdapterPosition());
                        fragmentCardClickListener.onCardClick(master);
                    }
                }
            });


        }


    }

//    public void setMasterRecyclerViewCardListener(MasterRecyclerViewCardListener m){
//        mMasterRecyclerViewCardListener = m;
//    }




}





