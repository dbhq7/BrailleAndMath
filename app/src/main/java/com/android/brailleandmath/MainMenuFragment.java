package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * MainMenuFragment.java is a fragment class that inflates the view of the app's main menu
 * Uses three interfaces that are declared in the MainMenuFragmentCallbacks to communicate with the
 * methods implemented in MainMenu
 * Depending on which button is pressed in the main menu fragment, callbacks are used to call the particular fragment transaction
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

public class MainMenuFragment extends Fragment{

    //initializing variables
    MainMenuFragmentCallbacks mainMenuFragmentCallbacks;

    private Button mChoiceInstruction;
    private Button mChoiceNumber;
    private Button mChoiceMath;

    /**
     * @param inflater - inflate layout of main menu fragment
     * @param container - holds fragment's UI
     * @param savedInstanceState - is not used in this case
     * @return - returns view of main menu layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.main_menu_fragment, container, false);

        //specifies that screen orientation is not locked and can be both portrait and landscape
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        //when either instruction, numbers or math buttons are pressed,
        //callback is called and implemented for the separate methods
        mChoiceInstruction = (Button)v.findViewById(R.id.instructions);
        mChoiceInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainMenuFragmentCallbacks.InstructionsPressed();
            }
        });

        mChoiceNumber = (Button)v.findViewById(R.id.numbers);
        mChoiceNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainMenuFragmentCallbacks.NumbersPressed();
            }
        });

        mChoiceMath = (Button)v.findViewById(R.id.math);
        mChoiceMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainMenuFragmentCallbacks.MathPressed();
            }
        });
        return v;
    }

    //interface required to communicate with the activity
    interface MainMenuFragmentCallbacks {
        public void InstructionsPressed();
        public void NumbersPressed();
        public void MathPressed();
    }

    //attach fragment callbacks to activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mainMenuFragmentCallbacks = (MainMenuFragmentCallbacks) activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException("Need to implement Buttons Pressed methods");
        }
    }
}