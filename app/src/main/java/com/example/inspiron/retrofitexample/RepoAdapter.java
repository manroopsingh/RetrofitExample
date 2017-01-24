package com.example.inspiron.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inspiron.retrofitexample.pojos.repoDetails;
import com.example.inspiron.retrofitexample.pojos.repoList;

import java.util.List;

/**
 * Created by INSPIRON on 24-Jan-17.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder>{
    List<repoList> repoLists;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;
        private LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_repoName);
            linearLayout =(LinearLayout) itemView.findViewById(R.id.linear_layout_repos);
        }

        @Override
        public void onClick(View view) {

            linearLayout.setOnClickListener(this);

        }


    }


    public RepoAdapter(RepoListActivity repoListActivity, List<repoList> repoLists){
        this.repoLists = repoLists;
        this.context = repoListActivity;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final repoList repo= repoLists.get(position);

        holder.textView.setText(repo.getName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                repoDetails repoDetails = new repoDetails(repo.getId(),repo.getName(), repo.getFullName());

                Intent intent = new Intent(context, RepoDetails.class);
                intent.putExtra("repo", repo.getName());
                //intent.putExtra("repoObject", repoDetails);
                intent.putExtra("repoOriginalObject", repo);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return repoLists.size();
    }


}
