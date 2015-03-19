package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * MainMenu.java implements the fragments from MainMenuFragment.java and MathMenuFragment.java
 * Holds fragment transactions for all buttons pressed in each of the fragment classes;
 * methods replace, add to backstack and inflate layouts
 *
 */

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainMenu extends FragmentActivity
        implements MainMenuFragment.MainMenuFragmentCallbacks, MathMenuFragment.MathMenuFragmentCallbacks{

    //initializing FragmentManager variable
    FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //if savedInstanceState is empty, add MainMenuFragment containing menu layout to activity
        if(savedInstanceState == null) {
            fragManager = getFragmentManager();
            FragmentTransaction fragTransaction = fragManager.beginTransaction();
            MainMenuFragment menuFrag = new MainMenuFragment();
            fragTransaction.add(R.id.fragment_place, menuFrag);
            fragTransaction.commit();
        }
    }

    //when the back button is pressed, display previous transaction on the screen
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    //method to replace current fragment with instructions fragment, and save fragment transaction to backstack
    @Override
    public void InstructionsPressed(){
        fragManager = getFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        InstructionsFragment instructionsFrag = new InstructionsFragment();
        ft.replace(R.id.fragment_place, instructionsFrag);
        ft.addToBackStack(null);
        ft.commit();
    }

    //method to replace current fragment with numbers fragment, which contains the flashcards for the app
    // save fragment to backstack
    @Override
    public void NumbersPressed(){
        fragManager = getFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        NumbersFlashCard numbersFlashCard = new NumbersFlashCard();
        ft.replace(R.id.fragment_place, numbersFlashCard);
        ft.addToBackStack(null);
        ft.commit();
    }

    //method to replace current fragment with MathMenuFragment, which shows user a menu with choices for the math game
    //save fragment transaction to backstack
    @Override
    public void MathPressed(){
        fragManager = getFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        MathMenuFragment mathFrag = new MathMenuFragment();
        ft.replace(R.id.fragment_place, mathFrag);
        ft.addToBackStack(null);
        ft.commit();
    }

    //method to replace current fragment with GameFragmentAdd, which brings up the questions for the addition portion of the game
    //save transaction fragment to backstack
    @Override
    public void AddPressed() {
        fragManager = getFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        GameFragmentAdd gameFragmentAdd = new GameFragmentAdd();
        ft.replace(R.id.fragment_place, gameFragmentAdd);
        ft.addToBackStack(null);
        ft.commit();
    }

    //method to replace current fragment with GameFragmentSubtract, which brings up the questions for the subtraction portion of the game
    //save fragment transaction to backstack
    @Override
    public void SubtractPressed() {
        fragManager = getFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        GameFragmentSubtract gameFragmentSub = new GameFragmentSubtract();
        ft.replace(R.id.fragment_place, gameFragmentSub);
        ft.addToBackStack(null);
        ft.commit();
    }

    //method to replace current fragment with GameFragmentMultiply, which brings up the questions for the multiplication portion of the game
    //save fragment transaction to backstack
    @Override
    public void MultiplyPressed() {
        fragManager = getFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        GameFragmentMultiply gameFragmentMultiply = new GameFragmentMultiply();
        ft.replace(R.id.fragment_place, gameFragmentMultiply);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        }
    @Override
    protected void onResume() {
        super.onResume();

        }
    @Override
    protected void onPause() {
        super.onPause();

        }
    @Override
    protected void onStop() {
        super.onStop();

        }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}