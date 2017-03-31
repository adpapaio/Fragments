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

    RatingBar kessBar;
    SharedPreferences kessPref;
    SharedPreferences.Editor editor;

    public KessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kess, container, false);
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
        kessBar = (RatingBar) getView().findViewById(R.id.kessRate);
        kessPref = getActivity().getSharedPreferences(num, 0);
        float rating = kessPref.getFloat(num, 0);
        kessBar.setRating(rating);

        setRating(num);
    }

    public void setRating(final String num)
    {
        kessPref = getActivity().getSharedPreferences(num, 1);
        editor = kessPref.edit();

        kessBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(num, kessBar.getRating());
                editor.commit();
                Log.d("RatingBar", "It changed to" + num);
            }
        });
    }

}
