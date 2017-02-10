package com.jomcode.flexcility.project.models;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jomcode.flexcility.databinding.FragmentProjectIndexBinding;

/**
 * Created by fadhil on 08/02/2017.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder {
    private FragmentProjectIndexBinding binding;

    public ProjectViewHolder(View view) {
        super(view);
        binding = DataBindingUtil.bind(view);
    }

    public void bind(Project project){
        binding.setProject(project);
    }
}
