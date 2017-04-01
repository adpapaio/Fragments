/* Created by: Aristotelis Papaioannou
 * This Class is for the Maroune Kessentini Fragment
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
public class KessFragment extends Fragment {

    RatingBar kessBar; //Rating Bar for Maroune Kessentini
    SharedPreferences kessPref; //Preferences for Maroune Kessentini
    SharedPreferences.Editor editor; //basic Shared Preferences Editor

    public KessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kess, container, false);
    }

    //When the Activity is Created
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments(); //Get this bundles arguments
        if(bundle != null) //if the bundle is not null
        {
            String num = bundle.getString("profnum"); //set the num to the bundles profnum
            setKessRating(num); //Call the function pass in num

        }
    }

    //seting the rating bar for Maroune Kessentini
    public void setKessRating(String num)
    {
        kessBar = (RatingBar) getView().findViewById(R.id.kessRate); //Find the bar for Maroune Kessentini
        kessPref = getActivity().getSharedPreferences(num, 0); //get the preferences
        float rating = kessPref.getFloat(num, 0);
        kessBar.setRating(rating);  //set the default rating pulled from preferences, 0 is default

        setRating(num);//set the rating OnChangeListener is in here
    }

    //set the rating with the changes, if any
    public void setRating(final String num)
    {
        kessPref = getActivity().getSharedPreferences(num, 1);
        editor = kessPref.edit();

        //Maroune Kessentini rating bar listener
        kessBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, kessBar.getRating()); //put the num in the rating bar
                editor.commit(); //commit the changes
            }
        });
    }
}
