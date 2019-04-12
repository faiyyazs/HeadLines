package com.headlines.utility;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentTransactionsUtil {



    private FragmentTransactionsUtil(){
        throw new IllegalStateException("Utility class");
    }

    public static void loadFragment(Fragment fragment,
                                    int containerId,
                                    int transactionType,
                                    boolean additToBackstack,
                                    AppCompatActivity context, View sharedElement){

        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();

        switch (transactionType){

            case 0:
                fragmentTransaction.add(containerId,fragment,fragment.getClass().getSimpleName());
                if(additToBackstack) {
                    fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
                }
                break;

            default:
            case 1:
                fragmentTransaction.replace(containerId,fragment,fragment.getClass().getSimpleName());
                if(additToBackstack) {
                    fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
                }
                break;


            case 2:
                fragmentTransaction.remove(fragment);
                context.getSupportFragmentManager().popBackStack();
                break;



        }
        if(sharedElement != null) {
            fragmentTransaction.addSharedElement(sharedElement, String.valueOf(sharedElement.getTag()));
        }
        fragmentTransaction.commit();

    }
}
