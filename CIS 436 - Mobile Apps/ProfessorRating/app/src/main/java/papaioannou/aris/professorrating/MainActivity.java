package papaioannou.aris.professorrating;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_prof_list);


        ListView profList = (ListView) findViewById(R.id.professor_list);

        List<String> array_prof_list = new ArrayList<String>();
        array_prof_list.add("John Baugh");
        array_prof_list.add("David Yoon");
        array_prof_list.add("Bruce Maxim");
        array_prof_list.add("Bruce Elenbogen");
        array_prof_list.add("Maroune Kessentini");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_prof_list);


        profList.setAdapter(arrayAdapter);

    }
}
