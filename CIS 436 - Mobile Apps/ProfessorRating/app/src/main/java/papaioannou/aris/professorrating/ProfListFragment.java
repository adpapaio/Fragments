package papaioannou.aris.professorrating;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfListFragment extends Fragment {


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

        profList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Fragment fragment = new BaughFragment();

                     if (getActivity().getResources().getConfiguration().orientation == 2 ||
                             ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                     == Configuration.SCREENLAYOUT_SIZE_LARGE))
                     {
                         setProfBundle(fragment, "0");
                         replaceLargeFrag(fragment);

                     }
                    else
                     {
                         Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show();
                         setProfBundle(fragment, "0");
                         replaceFrag(fragment);
                     }

                }
                if(i == 1)
                {
                    Fragment fragment = new YoonFragment();

                    if (getActivity().getResources().getConfiguration().orientation == 2 ||
                            ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                    == Configuration.SCREENLAYOUT_SIZE_LARGE))
                    {
                        setProfBundle(fragment, "1");
                        replaceLargeFrag(fragment);

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show();
                        setProfBundle(fragment, "1");
                        replaceFrag(fragment);
                    }
                }
                if(i == 2)
                {
                    Fragment fragment = new MaximFragment();
                    if (getActivity().getResources().getConfiguration().orientation == 2 ||
                            ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                    == Configuration.SCREENLAYOUT_SIZE_LARGE))
                    {
                        setProfBundle(fragment, "2");
                        replaceLargeFrag(fragment);

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show();

                        setProfBundle(fragment, "2");
                        replaceFrag(fragment);
                    }
                }
                if(i == 3)
                {
                    Fragment fragment = new ElenbogenFragment();

                    if (getActivity().getResources().getConfiguration().orientation == 2 ||
                            ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                    == Configuration.SCREENLAYOUT_SIZE_LARGE))
                    {

                        setProfBundle(fragment, "3");
                        replaceLargeFrag(fragment);

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show();

                        setProfBundle(fragment, "3");
                        replaceFrag(fragment);
                    }
                }
                if(i == 4)
                {
                    Fragment fragment = new KessFragment();

                    if(fragment != null)
                    {
                        if (getActivity().getResources().getConfiguration().orientation == 2 ||
                                ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                        == Configuration.SCREENLAYOUT_SIZE_LARGE)) {

                            setProfBundle(fragment, "4");
                            replaceLargeFrag(fragment);

                        } else {
                            Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show();

                            setProfBundle(fragment, "4");
                            replaceFrag(fragment);
                        }
                    }
                    else
                    {
                        replaceNull();
                    }
                }
            }
        });

        return view;
    }


    public void replaceFrag(Fragment frag)
    {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.fragment, frag);
        trans.addToBackStack(null);
        trans.commit();
    }

    public void replaceLargeFrag(Fragment frag)
    {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.info_frag, frag);
        trans.addToBackStack(null);
        trans.commit();
    }

    public void replaceNull()
    {
        ProfInfoFragment newFrag = new ProfInfoFragment();
        Bundle args = new Bundle();
        newFrag.setArguments(args);
        FragmentManager fragMan = getFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.info_frag, newFrag);
        fragTrans.addToBackStack(null);
        fragTrans.commit();
    }

    public void setProfBundle(Fragment frag, String info)
    {
        Bundle args = new Bundle();
        args.putString("profnum", info);
        Log.d("Creating args:" , args.toString());
        frag.setArguments(args);
    }
}
