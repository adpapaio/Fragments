package papaioannou.aris.professorrating;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements ProfListFragment.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Hello", "SetConsergsdgdesgerswgtentView");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one);
        Log.d("Hello", "SetContentView");

    }


}
