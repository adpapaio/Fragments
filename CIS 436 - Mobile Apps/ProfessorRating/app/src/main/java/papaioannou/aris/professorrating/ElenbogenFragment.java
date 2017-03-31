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

    RatingBar elenBar;
    SharedPreferences elenPref;
    SharedPreferences.Editor editor;

    public ElenbogenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elenbogen, container, false);
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
        elenBar = (RatingBar) getView().findViewById(R.id.elenRating);
        elenPref = getActivity().getSharedPreferences(num, 0);
        float rating = elenPref.getFloat(num, 0);
        elenBar.setRating(rating);

        setRating(num);
    }

    public void setRating(final String num)
    {
        elenPref = getActivity().getSharedPreferences(num, 1);
        editor = elenPref.edit();

        elenBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, elenBar.getRating());
                editor.commit();
                Log.d("RatingBar", "It changed to" + num);
            }
        });
    }

}
