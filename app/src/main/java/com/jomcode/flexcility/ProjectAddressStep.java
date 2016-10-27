package com.jomcode.flexcility;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.fcannizzaro.materialstepper.AbstractStep;



/**
 * Created by fadhil on 27/10/2016.
 *
 * This gets the Project Address form
 */

public class ProjectAddressStep extends AbstractStep {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        View v = layoutInflater.inflate(R.layout.project_address, container, false);
        return v;
    }

    @Override
    public String name() {
        return "Project Address";
    }

}
