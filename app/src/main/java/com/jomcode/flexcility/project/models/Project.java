package com.jomcode.flexcility.project.models;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jomcode.flexcility.ProjectShowActivity;

/**
 * Created by fadhil on 08/02/2017.
 */

public class Project {
    public final String name;
    public final String description;
    public final String imageUrl;

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public Project(String name, String description, String imageUrl){
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String theImageUrl) {
        Log.d("DEBUG", "Loading image " + theImageUrl + " into " + view.toString());
        Glide.with(view.getContext()).load(theImageUrl).centerCrop().into(view);
    }

    public void onClickProject(View view, Project project){
        Toast toast = Toast.makeText(view.getContext(), project.getName(), Toast.LENGTH_SHORT);
        toast.show();
        Context context = view.getContext();
        Intent intent = new Intent(context, ProjectShowActivity.class);
        context.startActivity(intent);
        Log.d("DEBUG", "clicked " + project.name);
    }
}
