package com.jomcode.flexcility.project.models;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by fadhil on 08/02/2017.
 */

public class Project {
    public final String name;
    public final String description;
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }

    public void onClickProject(View view, Project project){
        Toast toast = Toast.makeText(view.getContext(), project.getName(), Toast.LENGTH_SHORT);
        toast.show();
        Log.d("DEBUG", "clicked " + project.name);
    }
}
