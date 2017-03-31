/* Created By: Aristotelis Papaioannou
 * This class is for the List Fragment that holds all the Professor names
 * also replaces fragments
*/

package papaioannou.aris.professorrating;

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
import android.widget.Toast;


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

        //Creat and ArrayList of type String
        List<String> array_prof_list = new ArrayList<String>();
        array_prof_list.add("John Baugh"); //Add John Baugh
        array_prof_list.add("David Yoon"); //Add David Yoon
        array_prof_list.add("Bruce Maxim"); //Add Bruce Maxim
        array_prof_list.add("Bruce Elenbogen"); //Add Bruce Elenbogen
        array_prof_list.add("Maroune Kessentini"); //Add Maroune Kessentini

        //Array Adapter for the simple list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array_prof_list);
        profList.setAdapter(arrayAdapter); //Set the Adapter

        //Set the onItemClickListener
        profList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i = positions of the List

                //If the position is 0 for John Baugh
                if(i == 0)
                {
                    Fragment fragment = new BaughFragment(); //set the fragment to Baugh

                     if (getActivity().getResources().getConfiguration().orientation == 2 ||
                             ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                     == Configuration.SCREENLAYOUT_SIZE_LARGE)) //Is the screen in Landscape mode or a Large Screen(Tablet Screen)
                     {
                         setProfBundle(fragment, "0"); //Set Prof Bundle is for Preferences (Explained later in the function)
                         replaceLargeFrag(fragment); //Replace the fragment, but do large version

                     }
                    else //screen is in portrait mode or does not have a large screen
                     {
                         Toast.makeText(getActivity(), "My Milkshakes", Toast.LENGTH_SHORT).show(); //Easter Egg
                         setProfBundle(fragment, "0"); //Set Prof Bundle is for Preferences (Explained later in the function), 0 for Baugh
                         replaceFrag(fragment); //Replace the fragment normally
                     }

                }
                //If the position is 1 on the Listview item clicked, For David Yoon
                if(i == 1)
                {
                    Fragment fragment = new YoonFragment(); //Set the Fragments

                    if (getActivity().getResources().getConfiguration().orientation == 2 ||
                            ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                    == Configuration.SCREENLAYOUT_SIZE_LARGE)) //Is the screen in Landscape mode or a Large Screen(Tablet Screen)
                    {
                        setProfBundle(fragment, "1"); //Set Prof Bundle is for Preferences (Explained later in the function), 1 for Yoon
                        replaceLargeFrag(fragment);//Replace the fragment, but do large version

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Bring All", Toast.LENGTH_SHORT).show(); //Easter Egg
                        setProfBundle(fragment, "1"); //Set Prof Bundle is for Preferences (Explained later in the function), 1 for Yoon
                        replaceFrag(fragment);//Replace the fragment normally
                    }
                }
                //If the position is 2 on the Listview item clicked, For Bruce Maxim
                if(i == 2)
                {
                    Fragment fragment = new MaximFragment();
                    if (getActivity().getResources().getConfiguration().orientation == 2 ||
                            ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                    == Configuration.SCREENLAYOUT_SIZE_LARGE)) //Is the screen in Landscape mode or a Large Screen(Tablet Screen)
                    {
                        setProfBundle(fragment, "2"); //Set Prof Bundle is for Preferences (Explained later in the function), 2 for Maxim
                        replaceLargeFrag(fragment);  //Replace the fragment, but do large version

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "The Boys", Toast.LENGTH_SHORT).show();  //Easter Egg

                        setProfBundle(fragment, "2"); //Set Prof Bundle is for Preferences (Explained later in the function), 2 for Maxim
                        replaceFrag(fragment); //Replace the fragment normally
                    }
                }
                //If the position is 3 on the Listview Item Clicked, For Bruce Elenbogen
                if(i == 3)
                {
                    Fragment fragment = new ElenbogenFragment(); //Create a new fragment for elenbogen

                    if (getActivity().getResources().getConfiguration().orientation == 2 ||
                            ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                    == Configuration.SCREENLAYOUT_SIZE_LARGE)) //Is the screen in Landscape mode or a Large Screen(Tablet Screen)
                    {

                        setProfBundle(fragment, "3");//Set Prof Bundle is for Preferences (Explained later in the function), 3 for Elenbogen
                        replaceLargeFrag(fragment);  //Replace the fragment, but do large version

                    }
                    else
                    {
                        Toast.makeText(getActivity(), "to the", Toast.LENGTH_SHORT).show();

                        setProfBundle(fragment, "3"); //Set Prof Bundle is for Preferences (Explained later in the function), 3 for Elenbogen
                        replaceFrag(fragment); //Replace the fragment normally
                    }
                }
                //If the position on the Listview clicked is 4, For Maroune Kessentini
                if(i == 4)
                {
                    Fragment fragment = new KessFragment(); //Create a new fragment for Maroune Kessentini

                    if(fragment != null) //If the Fragment is not null
                    {
                        if (getActivity().getResources().getConfiguration().orientation == 2 ||
                                ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                        == Configuration.SCREENLAYOUT_SIZE_LARGE)) //Is the screen in Landscape mode or a Large Screen(Tablet Screen)
                        {

                            setProfBundle(fragment, "4"); //Set Prof Bundle is for Preferences (Explained later in the function), 4 for Kessentini
                            replaceLargeFrag(fragment); //Replace the fragment, but do large version

                        } else {
                            Toast.makeText(getActivity(), "yard.  ;)", Toast.LENGTH_SHORT).show();

                            setProfBundle(fragment, "4"); //Set Prof Bundle is for Preferences (Explained later in the function), 4 for Kessentini
                            replaceFrag(fragment); //Replace the fragment normally
                        }
                    }
                    else
                    {
                        replaceNull(); //Replace witht he blank template version
                    }
                }
            }
        });

        return view;
    }


    //Function to replace the fragment normally with another fragment
    //Brings in fragment based on what professor frag was called
    //Opens the fragment after
    public void replaceFrag(Fragment frag)
    {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.fragment, frag); //replace the fragment with the frag(prof fragment)
        trans.addToBackStack(null);
        trans.commit(); //commit the changes
    }

    //Function to replace the fragment in larger version with another fragment
    //Brings in fragment based on what professor frag was called
    //Opens the fragment after
    public void replaceLargeFrag(Fragment frag)
    {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.info_frag, frag); //replace the fragment with the frag(prof fragment)
        trans.addToBackStack(null);
        trans.commit(); //commit the changes
    }

    public void replaceNull()
    {
        ProfInfoFragment newFrag = new ProfInfoFragment();
        Bundle args = new Bundle();
        newFrag.setArguments(args); //Set the bundles arguments

        FragmentManager fragMan = getFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.info_frag, newFrag); //replace the fragment with the frag(prof fragment)
        fragTrans.addToBackStack(null);
        fragTrans.commit(); //commit the changes
    }

    public void setProfBundle(Fragment frag, String info)
    {
        Bundle args = new Bundle(); //get a new bundle
        args.putString("profnum", info); //set eh arg profnum, to info which is passed based on position abvoe
        Log.d("Creating args:" , args.toString()); // Testing Purposes, appears in Android Monitor
        frag.setArguments(args); //Set the Arguments
    }
}
