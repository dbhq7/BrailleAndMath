package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * MathMenuFragment.java is a fragment class that inflates the view of the app's math menu
 * Uses three interfaces that are declared in the MathMenuFragmentCallbacks to communicate with the
 * methods implemented in MainMenu
 * Depending on which button is pressed in the math menu fragment, callbacks are used to call the particular fragment transaction
 *
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MathMenuFragment extends Fragment {

    //initializing variables
    MathMenuFragmentCallbacks mathMenuFragmentCallbacks;

    private Button mChoiceAdd;
    private Button mChoiceSubtract;
    private Button mChoiceMultiply;

    /**
     * @param inflater - inflates view of math menu fragment
     * @param container - holds fragment UI
     * @param savedInstanceState - is set to false
     * @return - returns view of math menu layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v2 = inflater.inflate(R.layout.math_menu, container, false);

        //specifies that screen orientation is not locked and can be both portrait and landscape
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        //when either add, subtract or multiply buttons are pressed,
        // callback is called and implemented for the separate methods
        mChoiceAdd = (Button)v2.findViewById(R.id.addition);
        mChoiceAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathMenuFragmentCallbacks.AddPressed();
            }
        });

        mChoiceSubtract = (Button)v2.findViewById(R.id.subtraction);
        mChoiceSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathMenuFragmentCallbacks.SubtractPressed();
            }
        });

        mChoiceMultiply = (Button)v2.findViewById(R.id.multiplication);
        mChoiceMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathMenuFragmentCallbacks.MultiplyPressed();
            }
        });
        return v2;
    }

    //interface required to communicate with the activity
    interface MathMenuFragmentCallbacks {
        public void AddPressed();
        public void SubtractPressed();
        public void MultiplyPressed();
    }

    //attach fragment callbacks to activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mathMenuFragmentCallbacks = (MathMenuFragmentCallbacks) activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException("Need to implement Math Buttons Pressed methods");
        }
    }
}