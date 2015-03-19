package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * Fragment that inflates and holds the layout for the Instructions section of the app
 *
 */

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InstructionsFragment extends Fragment{

    /**
     * @param inflater - inflates layout of instruction fragment
     * @param container - holds fragment UI
     * @param savedInstanceState - set to false
     * @return - returns view of instruction layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.instructions, container, false);

        //specifies that screen orientation is not locked and can be both portrait and landscape
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        return v;
    }
}