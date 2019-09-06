package com.pakistan.adilfarooq.Utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentUtils {

    public static void addFragment(FragmentManager fm, Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(fragment, fragment.getTag());
        ft.commit();
    }

    public static void replaceFragment(FragmentManager fm, Fragment fragment, int container){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container, fragment, fragment.getTag());
        ft.commit();
    }
}
