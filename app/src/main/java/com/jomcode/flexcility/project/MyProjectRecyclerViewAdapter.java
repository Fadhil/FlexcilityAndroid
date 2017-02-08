package com.jomcode.flexcility.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jomcode.flexcility.R;
import com.jomcode.flexcility.project.ProjectFragment.OnListFragmentInteractionListener;
import com.jomcode.flexcility.project.dummy.ProjectContent.ProjectItem;
import com.jomcode.flexcility.project.models.Project;
import com.jomcode.flexcility.project.models.ProjectViewHolder;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ProjectItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProjectRecyclerViewAdapter extends RecyclerView.Adapter<ProjectViewHolder> {
    private List<Project> projects;

    public MyProjectRecyclerViewAdapter(List<Project> projects){
        this.projects = projects;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View projectContainer = inflater.inflate(R.layout.fragment_project_index, parent, false);
        return new ProjectViewHolder(projectContainer);
    }
    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.bind(project);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }
}
