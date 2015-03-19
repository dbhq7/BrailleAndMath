package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * *GameFragment's contain the same logic*
 * GameFragmentMultiply.java is a fragment class that inflates the view of the multiplication portion of the game
 * Stores equations for multiplication questions in varaibles
 * Contains toast methods for correct and incorrect answers
 * Uses flags to indicate if braille dot is inflated or not
 * Flags are used to store correct answer for each question as well, thus user answer and correct answer can be compared
 *
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class GameFragmentMultiply extends Fragment {

    //Declaring variables for savedInstanceState
    private static final String KEY_FLAG1 = "flag1";
    private static final String KEY_FLAG2 = "flag2";
    private static final String KEY_FLAG3 = "flag3";
    private static final String KEY_FLAG4 = "flag4";
    private static final String KEY_FLAG5 = "flag5";
    private static final String KEY_FLAG6 = "flag6";
    private static final String KEY_DRAWCOUNTER = "drawcounter";
    private static final String KEY_CORRECT = "correct answer";
    private static final String KEY_INCORRECT = "incorrect answer";

    //initialize variables
    FragmentManager fragManager;

    private Button button1, button2, button3, button4, button5, button6;
    private Button nextmultiply;
    private ImageView t1, t2, t3, t4, t5, t6;
    private ImageView questionMultiply;
    private boolean flag1, flag2, flag3, flag4, flag5, flag6;
    private int draw1, draw2, draw3, draw4, draw5;
    private int drawcounter;
    private int correctans, incorrectans;

    /**
     * The following two methods are Toasts for correct and incorrect answers
     * Specifically sets message to show at the bottom center of the screen
     */
    private void showCorrectToast(){
        Toast toast5 = Toast.makeText(getActivity(), R.string.correct_toast, Toast.LENGTH_SHORT);
        toast5.setGravity(Gravity.BOTTOM, 0, 0);
        toast5.show();
    }

    private void showIncorrectToast(){
        Toast toast6 = Toast.makeText(getActivity(), R.string.incorrect_toast, Toast.LENGTH_SHORT);
        toast6.setGravity(Gravity.BOTTOM, 0, 0);
        toast6.show();
    }

    /**
     * @param inflater - inflates multiplication game fragment layout
     * @param container - holds fragment UI
     * @param savedInstanceState -saves boolean and integer values
     * @return - return view- layout of fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_fragment_multiply, container, false);

        //specifies that screen orientation should be locked to portrait view only
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //set and initialize values for braille dots (t1-t6), flags, equations (draw1-draw5) and counters
        t1 = (ImageView)v.findViewById(R.id.dot1);
        t2 = (ImageView)v.findViewById(R.id.dot2);
        t3 = (ImageView)v.findViewById(R.id.dot3);
        t4 = (ImageView)v.findViewById(R.id.dot4);
        t5 = (ImageView)v.findViewById(R.id.dot5);
        t6 = (ImageView)v.findViewById(R.id.dot6);
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag6 = false;
        draw1 = R.drawable.fivetimesone;
        draw2 = R.drawable.fourtimestwo;
        draw3 = R.drawable.threetimesthree;
        draw4 = R.drawable.zerotimesthree;
        draw5 = R.drawable.twotimesthree;
        drawcounter = 0;
        correctans = 0;
        incorrectans = 0;

        //retrieves values of variables if any configuration change occurs
        //if savedInstanceState is empty reset all values
        if(savedInstanceState == null) {
            flag1 = false;
            flag2 = false;
            flag3 = false;
            flag4 = false;
            flag5 = false;
            flag6 = false;
            drawcounter=0;
            correctans=0;
            incorrectans=0;
        }else{
            flag1 = savedInstanceState.getBoolean(KEY_FLAG1, false);
            flag2 = savedInstanceState.getBoolean(KEY_FLAG2, false);
            flag3 = savedInstanceState.getBoolean(KEY_FLAG3, false);
            flag4 = savedInstanceState.getBoolean(KEY_FLAG4, false);
            flag5 = savedInstanceState.getBoolean(KEY_FLAG5, false);
            flag6 = savedInstanceState.getBoolean(KEY_FLAG6, false);
            drawcounter = savedInstanceState.getInt(KEY_DRAWCOUNTER, 0);
            correctans = savedInstanceState.getInt(KEY_CORRECT, 0);
            incorrectans = savedInstanceState.getInt(KEY_INCORRECT, 0);
        }

        //initializes ImageView for equation with the first question
        //includes content description in case talk back was enabled
        questionMultiply = (ImageView)v.findViewById(R.id.equation2);
        questionMultiply.setImageResource(draw1);
        questionMultiply.setContentDescription("What does five times one equal");

        //flags are set to indicate whether button was pressed
        //if flag is true, inflate view of braille dot
        //content description for images is set for when talk back is enabled
        button1 = (Button) v.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag1) {
                    flag1 = true;
                    t1.setImageResource(R.drawable.braille_dot_on);
                    t1.setContentDescription("Dot 1 enabled");
                } else {
                    flag1 = false;
                    t1.setImageResource(R.drawable.braille_dot_off);
                }
            }
        });

        button2 = (Button) v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag2) {
                    flag2 = true;
                    t2.setImageResource(R.drawable.braille_dot_on);
                    t1.setContentDescription("Dot 2 enabled");
                } else {
                    flag2 = false;
                    t2.setImageResource(R.drawable.braille_dot_off);
                }
            }
        });

        button3 = (Button) v.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag3) {
                    flag3 = true;
                    t3.setImageResource(R.drawable.braille_dot_on);
                    t1.setContentDescription("Dot 3 enabled");
                } else {
                    flag3 = false;
                    t3.setImageResource(R.drawable.braille_dot_off);
                }
            }
        });

        button4 = (Button) v.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag4) {
                    flag4 = true;
                    t4.setImageResource(R.drawable.braille_dot_on);
                    t1.setContentDescription("Dot 4 enabled");
                } else {
                    flag4 = false;
                    t4.setImageResource(R.drawable.braille_dot_off);
                }
            }
        });

        button5 = (Button) v.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag5) {
                    flag5 = true;
                    t5.setImageResource(R.drawable.braille_dot_on);
                    t1.setContentDescription("Dot 5 enabled");
                } else {
                    flag5 = false;
                    t5.setImageResource(R.drawable.braille_dot_off);
                }
            }
        });

        button6 = (Button) v.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag6) {
                    flag6 = true;
                    t6.setImageResource(R.drawable.braille_dot_on);
                    t1.setContentDescription("Dot 6 enabled");
                } else {
                    flag6 = false;
                    t6.setImageResource(R.drawable.braille_dot_off);
                }
            }
        });

        //when next button is pressed, increment drawcounter by one and update equation image to reveal new question
        //reset flags for each new question when next button pressed
        //compare user answer with correct answer (shown via flags)
        //if answer is correct display correct toast, or else display incorrect toast
        //content description set for each new equation to be read when talk back enabled
        nextmultiply = (Button) v.findViewById(R.id.nextbuttonmultiply);
        nextmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(drawcounter) {
                    case 0:
                        if (flag1 && !flag2 && !flag3 && !flag4 && flag5 && !flag6) {
                            showCorrectToast();
                            correctans++;
                        } else {
                            showIncorrectToast();
                            incorrectans++;
                        }
                        drawcounter++;
                        questionMultiply.setImageResource(draw2);
                        questionMultiply.setContentDescription("What does four times two equal");
                        break;
                    case 1:
                        if (flag1 && flag2 && !flag3 && !flag4 && flag5 && !flag6) {
                            showCorrectToast();
                            correctans++;
                        } else {
                            showIncorrectToast();
                            incorrectans++;
                        }
                        drawcounter++;
                        questionMultiply.setImageResource(draw3);
                        questionMultiply.setContentDescription("What does three times three equal");
                        break;
                    case 2:
                        if (!flag1 && flag2 && !flag3 && flag4 && !flag5 && !flag6) {
                            showCorrectToast();
                            correctans++;
                        } else {
                            showIncorrectToast();
                            incorrectans++;
                        }
                        drawcounter++;
                        questionMultiply.setImageResource(draw4);
                        questionMultiply.setContentDescription("What does zero times three equal");
                        break;
                    case 3:
                        if (!flag1 && !flag2 && !flag3 && flag4 && flag5 && !flag6) {
                            showCorrectToast();
                            correctans++;
                        } else {
                            showIncorrectToast();
                            incorrectans++;
                        }
                        drawcounter++;
                        questionMultiply.setImageResource(draw5);
                        questionMultiply.setContentDescription("What does two times three equal");
                        break;
                    case 4:
                        if (flag1 && flag2 && !flag3 && flag4 && !flag5 && !flag6) {
                            showCorrectToast();
                            correctans++;
                        } else {
                            showIncorrectToast();
                            incorrectans++;
                        }
                        //Show user results
                        //If user answered three or more incorrectly, show toast saying "Go review flashcards!"
                        if(incorrectans >= 3) {
                            Toast toast = Toast.makeText(getActivity(), "You answered " + correctans + " correctly. Go review flashcards!", LENGTH_LONG);
                            toast.setGravity(Gravity.BOTTOM, 0, 0);
                            toast.show();
                        }else {
                            Toast toast = Toast.makeText(getActivity(), "You answered "+correctans + " correctly. Nice Job!", LENGTH_LONG);
                            toast.setGravity(Gravity.BOTTOM, 0, 0);
                            toast.show();
                        }
                        //Fragment replaced and takes user back to MainMenuFragment after fifth question
                        //reset answer counter values
                        fragManager = getFragmentManager();
                        FragmentTransaction fragTransaction = fragManager.beginTransaction();
                        MainMenuFragment menuFrag = new MainMenuFragment();
                        fragTransaction.replace(R.id.fragment_place, menuFrag);
                        fragTransaction.commit();
                        correctans=0;
                        incorrectans=0;
                        break;
                }
                //reset flags
                //reset buttons
                flag1 = false;
                flag2 = false;
                flag3 = false;
                flag4 = false;
                flag5 = false;
                flag6 = false;
                t1.setImageResource(R.drawable.braille_dot_off);
                t2.setImageResource(R.drawable.braille_dot_off);
                t3.setImageResource(R.drawable.braille_dot_off);
                t4.setImageResource(R.drawable.braille_dot_off);
                t5.setImageResource(R.drawable.braille_dot_off);
                t6.setImageResource(R.drawable.braille_dot_off);
            }
        });

        return v;
    }

    /**
     * @param outState - Saves Bundle for the following integers and boolean variables
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_DRAWCOUNTER, drawcounter);
        outState.putInt(KEY_CORRECT, correctans);
        outState.putInt(KEY_INCORRECT, incorrectans);
        outState.putBoolean(KEY_FLAG1, flag1);
        outState.putBoolean(KEY_FLAG2, flag2);
        outState.putBoolean(KEY_FLAG3, flag3);
        outState.putBoolean(KEY_FLAG4, flag4);
        outState.putBoolean(KEY_FLAG5, flag5);
        outState.putBoolean(KEY_FLAG6, flag6);
    }
}