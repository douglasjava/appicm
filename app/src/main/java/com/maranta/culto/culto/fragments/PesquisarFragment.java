package com.maranta.culto.culto.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maranta.culto.culto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisarFragment extends Fragment {


    public PesquisarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pesquisar, container, false);

        return view;
    }

}
