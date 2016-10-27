package com.jomcode.flexcility;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.fcannizzaro.materialstepper.AbstractStep;

import java.io.FileNotFoundException;
import java.util.jar.Manifest;

import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.app.Activity.RESULT_OK;

/**
 * Created by fadhil on 26/10/2016.
 *
 * This generates the Project Details form
 */

public class ProjectDetailsStep extends AbstractStep {
    private static final int REQUEST_READ_EXTERNAL_STORAGE = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.project_details, container, false);

        final ImageButton buttonLoadImage = (ImageButton) v.findViewById(R.id.imageButton);
        buttonLoadImage.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!mayViewGallery()) {
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }

            private boolean mayViewGallery() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    return true;
                }

                if (ContextCompat.checkSelfPermission(getContext(), READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    return true;
                }

                requestPermissions(new String[]{READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE);

                return false;
            }

        });

        return v;
    }



    @Override
    public String name() {
        return "Project Details";
    }


    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    @Override
    public boolean isOptional() {
        return true;
    }


    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        return "You can skip";
    }

    @Override
    public boolean nextIf() {
        return true;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }

}
