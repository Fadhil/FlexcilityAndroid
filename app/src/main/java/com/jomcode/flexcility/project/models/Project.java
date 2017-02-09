package com.jomcode.flexcility.project.models;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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

    public Project(String name, String description){
        this.name = name;
        this.description = description;
        this.imageUrl = "http://cdn.meme.am/instances/60677654.jpg";
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String theImageUrl) {
        Log.d("DEBUG", "Loading image " + theImageUrl + " into " + view.toString());
        Glide.with(view.getContext()).load(theImageUrl).into(view);
    }

    public void onClickProject(View view, Project project){
        Toast toast = Toast.makeText(view.getContext(), project.getName(), Toast.LENGTH_SHORT);
        toast.show();
        Log.d("DEBUG", "clicked " + project.name);
    }
}
