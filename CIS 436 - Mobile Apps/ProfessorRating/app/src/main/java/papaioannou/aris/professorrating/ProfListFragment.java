package papaioannou.aris.professorrating;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfListFragment extends Fragment implements AdapterView.OnItemClickListener{


    public ProfListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frag_prof_list,container,false);
        ListView profList = (ListView) view.findViewById(R.id.professor_list);

        List<String> array_prof_list = new ArrayList<String>();
        array_prof_list.add("John Baugh");
        array_prof_list.add("David Yoon");
        array_prof_list.add("Bruce Maxim");
        array_prof_list.add("Bruce Elenbogen");
        array_prof_list.add("Maroune Kessentini");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array_prof_list);
        profList.setAdapter(arrayAdapter);
        return view;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        ListView profList = (ListView) view.findViewById(R.id.professor_list);

        profList.setOnItemClickListener(this);
        AdapterView.OnItemClickListener listener = profList.getOnItemClickListener();
        listener.equals(position);

        if(position == 0)
        {
           Fragment next = new Fragment();
            this.getFragmentManager().beginTransaction().replace(R.id.professor_list, next, String.valueOf(getActivity().getFragmentManager())).addToBackStack(null).commit();
            Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getActivity(), "GoodBye", Toast.LENGTH_SHORT).show();
        }

    }

    public interface OnItemClickListener {

    }
}
