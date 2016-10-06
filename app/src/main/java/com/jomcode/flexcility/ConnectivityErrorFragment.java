package com.jomcode.flexcility;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
Displays an error popup saying there was a network error.
Has an OK button that returns user to the screen they were on.
 */
public class ConnectivityErrorFragment extends DialogFragment {
   @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
       /* Build an Alert Dialog */
       AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());
       builder.setTitle(R.string.connection_error)
               .setMessage(R.string.could_not_connect_to_network)
               .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });
       return builder.create();
   }
}
