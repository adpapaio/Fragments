/* Created by: Aristotelis Papaioannou
**This class is for the John Baugh Fragment**
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
public class BaughFragment extends Fragment  {

    RatingBar baughBar; //Rating Bar for John Baugh
    SharedPreferences baughPref;    //Pull the preferences for JohnBaugh
    SharedPreferences.Editor editor; //Bsic sharedpreferences editor

    public BaughFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_baugh, container, false); //Inflate the Fragment

        // return the current view
        return view;
    }

    //when the activity is created
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState); //Create the super
        Bundle bundle = getArguments(); //Get this bundles arguments
        Log.d("RatingBar", "Bundle is "+ bundle);
        if(bundle != null)  //If there are arguments go inside
        {
            String num = bundle.getString("profnum");   //set num to the bundle profnum argument
            Log.d("Bundle dbnfuo", "num is " + num);
            setPrefRating(num); //send the argument to the set rating function
        }
    }

    //set the default rating, pulled from preferences
  public void setPrefRating(String num)
  {
      baughBar = (RatingBar) getView().findViewById(R.id.baughRate); //pull the John Baugh Rating Bar
      baughPref = getActivity().getSharedPreferences(num, 0); //In this activity get the activities shared preferences
      float rating = baughPref.getFloat(num, 0); //set rating to the saved rating, default 0
      baughBar.setRating(rating); //set the rating based on what the rating gets set to

      setRating(num); //set the rating (For OnChange Listener)
  }

  //set the bars new rating
  public void setRating(final String num)
  {
      baughPref = getActivity().getSharedPreferences(num, 1); //get the preferences
      editor = baughPref.edit(); //edit the preferences

      baughBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
          @Override
          public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
              editor.putFloat(num, baughBar.getRating()); //set the preferenced rating
              editor.commit(); //commit that rating to the preferences suing editor
              Log.d("RatingBar", "It changed to" + num); //Test for the Log
          }
      });
  }
}
