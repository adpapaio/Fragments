/* Created by: Aristotelis Papaioannou
** This class is for the Bruce Elenbogen Fragment
*/

package papaioannou.aris.professorrating;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElenbogenFragment extends Fragment {

    RatingBar elenBar; //Going to set this as elenbogen rating bar
    SharedPreferences elenPref; //elenbogens preferences
    SharedPreferences.Editor editor; //basic editor for sharedpreferences

    public ElenbogenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elenbogen, container, false);
    }

    //When the activity is created
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments(); //get this bundles arguments
        Log.d("RatingBar", "Bundle is "+ bundle); //Testing purposes
        if(bundle != null) //if the bundle is not null
        {
            String num = bundle.getString("profnum");  //Set num to this bundles prof num arguments
            Log.d("RatingBar", "num is " +num); //Testing purposes
            setMaximRating(num); //Set maxim rating with this
        }
    }

    //Set the bars default rating for when the fragment is opened
    public void setMaximRating(String num)
    {
        elenBar = (RatingBar) getView().findViewById(R.id.elenRating); //find Elenbogens rating bar
        elenPref = getActivity().getSharedPreferences(num, 0); //get elenbogens preferences
        float rating = elenPref.getFloat(num, 0); //set the rating to saved rating
        elenBar.setRating(rating); //set the rating

        setRating(num); //Onchangelistener
    }

    //Set the rating of the bar
    public void setRating(final String num)
    {
        elenPref = getActivity().getSharedPreferences(num, 1); //get the preferences
        editor = elenPref.edit(); //edit the preferences

        //when the rating is changed call the listener
        elenBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, elenBar.getRating());  //put the new rating
                editor.commit(); //commit the new rating
                Log.d("RatingBar", "It changed to" + num); //Testing purposes: appears in Android Monitor Log
            }
        });
    }
}
