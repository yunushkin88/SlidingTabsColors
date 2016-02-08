package com.example.android.common.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.slidingtabscolors.R;

/**
 * Created by kordi on 07.02.2016.
 */
public class Tab2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_2, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
