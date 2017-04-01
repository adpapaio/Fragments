/* Created by: Aristotelis Papaioannou
 * This class is for the Bruce Maxim Fragment
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
public class MaximFragment extends Fragment {

    RatingBar maxBar; //Associates with the maxim rating bar
    SharedPreferences maxPref; //Maxim Preferences
    SharedPreferences.Editor editor; //basic editor

    public MaximFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maxim, container, false);
    }

    //when the activity is created
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments(); //get this bundles arguments
        if(bundle != null) //if the bundle is not null
        {
            String num = bundle.getString("profnum"); //set the string to the bundles arg
            setMaximRating(num); //call the function and pass in num
        }
    }


    //Set the rating for Maxim
    public void setMaximRating(String num)
    {
        maxBar = (RatingBar) getView().findViewById(R.id.maximBar); //Find the bar for Bruce Maxim
        maxPref = getActivity().getSharedPreferences(num, 0); //get the preferences
        float rating = maxPref.getFloat(num, 0); //set the rating
        maxBar.setRating(rating); //pass in the function

        setRating(num); //call the function that hold OnChangeListener
    }

    //set the rating of the bar based on the listener
    public void setRating(final String num)
    {
        maxPref = getActivity().getSharedPreferences(num, 1); //get the preferences
        editor = maxPref.edit(); //open them for editing

        maxBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, maxBar.getRating()); //get the new rating and put it in num
                editor.commit(); //commit the changes
            }
        });
    }

}
