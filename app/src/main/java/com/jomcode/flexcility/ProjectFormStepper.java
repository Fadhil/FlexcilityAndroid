package com.jomcode.flexcility;

import android.os.Bundle;

import com.github.fcannizzaro.materialstepper.style.ProgressStepper;

/**
 * Created by fadhil on 26/10/2016.
 */

public class ProjectFormStepper extends ProgressStepper {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setErrorTimeout(1500);
        setTitle("New Project");
        setStateAdapter();

        addStep(new ProjectDetailsStep());
        super.onCreate(savedInstanceState);
    }
}
