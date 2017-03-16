package papaioannou.aris.professorrating;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfListFragment extends Fragment implements View.OnClickListener{


    public ProfListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_prof_list,container,false);



        return view;
    }

    @Override
    public void onClick(View v)
    {
        ListView profList = (ListView) v.findViewById(R.id.professor_list);

        profList.setOnClickListener(this);
    }

}
