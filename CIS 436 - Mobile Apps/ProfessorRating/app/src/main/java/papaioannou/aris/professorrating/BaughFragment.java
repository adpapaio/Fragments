package papaioannou.aris.professorrating;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaughFragment extends Fragment  {

    RatingBar baughBar;
    SharedPreferences baughPref;
    SharedPreferences.Editor editor;

    public BaughFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_baugh, container, false);
        Log.d("RatingBar", "Imade it to oncreateview");

      /*  baughBar = (RatingBar) view.findViewById(R.id.baughRate);
        baughPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        float rating = baughPref.getFloat("num", 0f);


        baughBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                final int num = baughBar.getNumStars();
                editor = baughPref.edit();
                editor.putFloat("num", rating);
                editor.commit();
                int ratings = baughPref.getInt("num", 0);
            }
        });

        baughBar.setRating(rating);*/
        // Inflate the layout for this fragment
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
            Log.d("Bundle dbnfuo", "num is " + num);
            setPrefRating(num);

        }
    }

  public void setPrefRating(String num)
  {
      baughBar = (RatingBar) getView().findViewById(R.id.baughRate);
      baughPref = getActivity().getSharedPreferences(num, 0);
      float rating = baughPref.getFloat(num, 0);
      baughBar.setRating(rating);

      setRating(num);
  }

  public void setRating(final String num)
  {
      baughPref = getActivity().getSharedPreferences(num, 1);
      editor = baughPref.edit();

      baughBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
          @Override
          public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
              editor.putFloat(num, baughBar.getRating());
              editor.commit();
              Log.d("RatingBar", "It changed to" + num);
          }
      });
  }



}
