/* Created by: Aristotelis Papaioannou
 *This Class is for the David Yoon Fragment
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
public class YoonFragment extends Fragment {

    RatingBar yoonBar; //bar associated with David Yoon
    SharedPreferences yoonPref; //David Yoon Preferences
    SharedPreferences.Editor editor; //basic Editor

    public YoonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yoon, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments(); //Get this bundles arguments
        Log.d("RatingBar", "Bundle is "+ bundle); //For Testing Purposes, appears in Android Monitor
        if(bundle != null) //If the bundle is not null
        {
            String num = bundle.getString("profnum"); //set num to the bundles profnum
            Log.d("RatingBar", "num is " +num); //For Testing Purposes, appears in Android Monitor
            setYoonRating(num); //Call Function, pass in num
        }
    }

    //Set the default rating
    public void setYoonRating(String num)
    {
        yoonBar = (RatingBar) getView().findViewById(R.id.yoonRating); //find the bar for David Yoon
        yoonPref = getActivity().getSharedPreferences(num, 0); //get the preferences
        float rating = yoonPref.getFloat(num, 0); //set rating to the current rating
        yoonBar.setRating(rating); //set the rating

        setRating(num); //call the function pass in num, OnChangeListener is in here
    }

    //set the Rating using OnChangeListener
    public void setRating(final String num)
    {
        yoonPref = getActivity().getSharedPreferences(num, 1); //get preferences
        editor = yoonPref.edit(); //open the preferences for editing

        yoonBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, yoonBar.getRating()); //put the new rating in num
                editor.commit(); //commit these changes
                Log.d("RatingBar", "It changed to" + num); //For Testing Purposes, appears in Android Monitor
            }
        });
    }
}
