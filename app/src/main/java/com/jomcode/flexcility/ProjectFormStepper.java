package com.jomcode.flexcility;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ImageButton;

import com.github.fcannizzaro.materialstepper.style.ProgressStepper;

import java.io.FileNotFoundException;

/**
 * Created by fadhil on 26/10/2016.
 *
 * This is the Main Project Form Stepper in which we'll add the Details and Address forms
 */

public class ProjectFormStepper extends ProgressStepper implements DashboardFragment.OnFragmentInteractionListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setErrorTimeout(1500);
        setTitle("New Project");
        setStateAdapter();

        addStep(new ProjectDetailsStep());
        addStep(new ProjectAddressStep());
        super.onCreate(savedInstanceState);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(targetUri));
                Log.d("DEBUG", "here in the image loader!!");
                ImageButton buttonLoadImage = (ImageButton) this.findViewById(R.id.imageButton);
                buttonLoadImage.setImageBitmap(bitmap);
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }

        }
    }


    @Override
    public void onComplete(Bundle data) {
        Log.d("DEBUG", "Completed!");
        // Here's where we should save the data, etc.
        Intent mainIntent = new Intent(this,MainActivity.class);
        finish();

    }

    public void onFragmentInteraction(Uri uri){

        //you can leave it empty
    }
}
