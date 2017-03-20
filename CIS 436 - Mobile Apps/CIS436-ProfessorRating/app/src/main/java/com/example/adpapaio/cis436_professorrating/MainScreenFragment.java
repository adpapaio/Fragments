package com.example.adpapaio.cis436_professorrating;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainScreenFragment extends Fragment implements View.OnClickListener{

    private AdapterView.OnItemSelectedListener listener;

    public MainScreenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main_screen, container, false);

        Button baugh = (Button) view.findViewById(R.id.baughbutt);
        Button maxim = (Button) view.findViewById(R.id.maximButt);
        Button steiner = (Button) view.findViewById(R.id.steinerButt);
        Button kelly = (Button) view.findViewById(R.id.kellyButt);
        Button elenbogen = (Button) view.findViewById(R.id.elenbogenButt);

        baugh.setOnClickListener(this);
        maxim.setOnClickListener(this);
        steiner.setOnClickListener(this);
        kelly.setOnClickListener(this);
        elenbogen.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
