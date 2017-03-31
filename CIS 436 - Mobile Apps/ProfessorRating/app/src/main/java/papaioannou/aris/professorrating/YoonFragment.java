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

    RatingBar yoonBar;
    SharedPreferences yoonPref;
    SharedPreferences.Editor editor;

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
        Bundle bundle = getArguments();
        Log.d("RatingBar", "Bundle is "+ bundle);
        if(bundle != null)
        {

            String num = bundle.getString("profnum");
            Log.d("RatingBar", "num is " +num);
            setYoonRating(num);

        }
    }

    public void setYoonRating(String num)
    {
        yoonBar = (RatingBar) getView().findViewById(R.id.yoonRating);
        yoonPref = getActivity().getSharedPreferences(num, 0);
        float rating = yoonPref.getFloat(num, 0);
        yoonBar.setRating(rating);

        setRating(num);
    }

    public void setRating(final String num)
    {
        yoonPref = getActivity().getSharedPreferences(num, 1);
        editor = yoonPref.edit();

        yoonBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, yoonBar.getRating());
                editor.commit();
                Log.d("RatingBar", "It changed to" + num);
            }
        });
    }

}
