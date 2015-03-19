package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * NumbersFlashCard.java is a fragment class that inflates the view of the app's flashcard portion
 * Initializes and stores values of numbers and images of braille characters
 * Contains logic for two methods: BrailleImages and Numbers, where views are updated depending on the three buttons clicked
 * The braille button displays the braille character corresponding to the number and makes the braille image visible
 * The next button increments the counter and the previous button decrements the counter
 *
 */
import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NumbersFlashCard extends Fragment {

    //Declaring variable for savedInstanceState
    private static final String KEY_NUMBER_COUNTER="numberCounter";

    //initializing variables
    private Button mChoiceBraille;
    private Button mChoiceNext;
    private Button mChoicePrevious;
    private TextView mNumber;
    private ImageView mImageBraille;
    private int i0, i1, i2, i3, i4, i5, i6, i7, i8, i9;
    private int numberCounter = 0;

    /**
     * @param inflater - inflates layout of flashcard fragment
     * @param container - holds fragment UI
     * @param savedInstanceState - saves integer values
     * @return - return view of flashcard layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.flashcard, container, false);

        //specifies that screen orientation is not locked and can be both portrait and landscape
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        //initializing number and braille character views
        mImageBraille =(ImageView)v.findViewById(R.id.braillenumber);
        mNumber = (TextView)v.findViewById(R.id.numbers);

        //set front layout
        mNumber.setVisibility(View.VISIBLE);
        // hides back layout
        mImageBraille.setVisibility(View.GONE);

        //assigning images to respective variables, so that they can be called with their corresponding numbers
        i0 = R.drawable.number0;
        i1 = R.drawable.number1;
        i2 = R.drawable.number2;
        i3 = R.drawable.number3;
        i4 = R.drawable.number4;
        i5 = R.drawable.number5;
        i6 = R.drawable.number6;
        i7 = R.drawable.number7;
        i8 = R.drawable.number8;
        i9 = R.drawable.number9;

        mNumber = (TextView) v.findViewById(R.id.numbers);

        //if savedInstanceState is empty, reset counter for numbers
        if(savedInstanceState == null) {
            numberCounter=0;
        }
        else {
            numberCounter= savedInstanceState.getInt(KEY_NUMBER_COUNTER, 0);
            BrailleImages();
            Numbers();
        }

        //if user presses braille button set mImageBraille to visible and hide textview showing mNumber
        mChoiceBraille = (Button) v.findViewById(R.id.braillebutton);
        mChoiceBraille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageBraille.setVisibility(View.VISIBLE);
                mNumber.setVisibility(View.GONE);
                BrailleImages();
            }
        });

        //increment number by one and once loop is more than nine set it back to zero
        //set mNumber visibility to visible and hide mImageBraille
        //call Numbers method
        mChoiceNext = (Button)v.findViewById(R.id.nextbutton);
        mChoiceNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageBraille.setVisibility(View.GONE);
                mNumber.setVisibility(View.VISIBLE);
                if(numberCounter<10) {
                    numberCounter++;
                }else{
                    numberCounter=0;
                }
                Numbers();
            }
        });

        //decrement number by one and if number equals zero, set counter to nine
        //set mNumber visibility to visible and hide mImageBraille
        //call Numbers method
        mChoicePrevious = (Button)v.findViewById(R.id.previousbutton);
        mChoicePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageBraille.setVisibility(View.GONE);
                mNumber.setVisibility(View.VISIBLE);
                if(numberCounter==0) {
                    numberCounter=9;
                }else{
                    numberCounter--;
                }
                Numbers();
            }
        });

        mNumber = (TextView) v.findViewById(R.id.numbers);
        //convert mNumber to string value to be displayed in textView
        mNumber.setText(String.valueOf(numberCounter));

        return v;
    }

    //Method containing images for the braille characters from 0-9
    //Images are updated via the numberCounter
    //Content Description set for when talk back is enabled
    private void BrailleImages(){
        switch (numberCounter){
            case 0:
                mImageBraille.setImageResource(i0);
                mImageBraille.setContentDescription("Zero");
                break;
            case 1:
                mImageBraille.setImageResource(i1);
                mImageBraille.setContentDescription("One");
                break;
            case 2:
                mImageBraille.setImageResource(i2);
                mImageBraille.setContentDescription("Two");
                break;
            case 3:
                mImageBraille.setImageResource(i3);
                mImageBraille.setContentDescription("Three");
                break;
            case 4:
                mImageBraille.setImageResource(i4);
                mImageBraille.setContentDescription("Four");
                break;
            case 5:
                mImageBraille.setImageResource(i5);
                mImageBraille.setContentDescription("Five");
                break;
            case 6:
                mImageBraille.setImageResource(i6);
                mImageBraille.setContentDescription("Six");
                break;
            case 7:
                mImageBraille.setImageResource(i7);
                mImageBraille.setContentDescription("Seven");
                break;
            case 8:
                mImageBraille.setImageResource(i8);
                mImageBraille.setContentDescription("Eight");
                break;
            case 9:
                mImageBraille.setImageResource(i9);
                mImageBraille.setContentDescription("Nine");
                break;
        }
    }

    //Method containing numbers 0-9
    //Numbers are updated via the numberCounter
    private void Numbers(){
        switch (numberCounter){
            case 0:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 1:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 2:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 3:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 4:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 5:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 6:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 7:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 8:
                mNumber.setText(String.valueOf(numberCounter));
                break;
            case 9:
                mNumber.setText(String.valueOf(numberCounter));
                break;
        }
    }

    /**
     * @param outState- saves integer value of numberCounter
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_NUMBER_COUNTER, numberCounter);
    }
}