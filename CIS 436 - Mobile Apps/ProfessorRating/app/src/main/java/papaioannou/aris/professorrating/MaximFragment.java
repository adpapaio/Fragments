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

    RatingBar maxBar;
    SharedPreferences maxPref;
    SharedPreferences.Editor editor;

    public MaximFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maxim, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        Log.d("RatingBar", "Bundle is "+ bundle);
        if(bundle != null)
        {

            String num = bundle.getString("profnum");
            Log.d("RatingBar", "num is " +num);
            setMaximRating(num);

        }
    }


    public void setMaximRating(String num)
    {
        maxBar = (RatingBar) getView().findViewById(R.id.maximBar);
        maxPref = getActivity().getSharedPreferences(num, 0);
        float rating = maxPref.getFloat(num, 0);
        maxBar.setRating(rating);

        setRating(num);
    }

    public void setRating(final String num)
    {
        maxPref = getActivity().getSharedPreferences(num, 1);
        editor = maxPref.edit();

        maxBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, maxBar.getRating());
                editor.commit();
                Log.d("RatingBar", "It changed to" + num);
            }
        });
    }

}
