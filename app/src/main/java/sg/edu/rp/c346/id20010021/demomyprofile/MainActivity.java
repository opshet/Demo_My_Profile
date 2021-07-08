package sg.edu.rp.c346.id20010021.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView gpa;
    EditText etname;
    EditText etgpa;

    @Override
    protected void onPause() {
        super.onPause();
        String strname= etname.getText().toString();
        float gpa= Float.parseFloat(etgpa.getText().toString());

        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit= prefs.edit();
        prefEdit.putString("name", strname);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "John");
        Float gpa = prefs.getFloat("3", 3);
        etname.setText(strName);
        etgpa.setText(gpa + "");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        gpa=findViewById(R.id.gpa);
        etname=findViewById(R.id.etname);
        etgpa=findViewById(R.id.etgpa);


    }
}