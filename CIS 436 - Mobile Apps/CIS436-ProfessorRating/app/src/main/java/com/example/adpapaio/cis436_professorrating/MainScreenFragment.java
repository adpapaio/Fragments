package com.example.adpapaio.cis436_professorrating;


import android.content.Context;
import android.app.Fragment;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainScreenFragment extends Fragment implements View.OnClickListener{

    private OnItemSelectedListener listener;

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

        switch(v.getId()) //Switch case for which professor button was picked
        {
            case R.id.baughbutt:
                Toast.makeText(getActivity(), "Test Toast Trigga", Toast.LENGTH_SHORT).show(); //If Baugh is Selected
               listener.SelectedProfessor("1");
                break;
            case R.id.maximButt:
                Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show(); //If Maxim is selected
                //listener.SelectedProfessor(2);
                break;
            case R.id.steinerButt:
                Toast.makeText(getActivity(), "Lets get Shwifty", Toast.LENGTH_SHORT).show(); //If Steiner is selected
               // listener.SelectedProfessor(3);
                break;
            case R.id.kellyButt:
                Toast.makeText(getActivity(), "Booty", Toast.LENGTH_SHORT).show(); //If Kelly is selected
               // listener.SelectedProfessor(4);
                break;
            case R.id.elenbogenButt:
                Toast.makeText(getActivity(), "I hope i dont forget to delete these", Toast.LENGTH_SHORT).show(); //If elenbogen is selected
               // listener.SelectedProfessor(5);
                break;

        }
    }

    public interface OnItemSelectedListener
    {
        void SelectedProfessor(String prof_int);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener)
        {
            listener = (OnItemSelectedListener) context;
        }
        else
        {
            throw new ClassCastException(context.toString() + "Why did you do that");
        }
    }
}
