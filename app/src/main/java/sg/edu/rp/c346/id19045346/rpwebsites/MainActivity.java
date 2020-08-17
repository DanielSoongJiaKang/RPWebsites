package sg.edu.rp.c346.id19045346.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Spinner spnCategory;
    Spinner spnSub;
    String website;
    Button btngo;

    ArrayList<String> alsubcategory;
    ArrayAdapter<String> aasubcategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spnCategory = findViewById(R.id.SpinnerCategory);
        spnSub = findViewById(R.id.SpinnerSubCategory);

        btngo = findViewById(R.id.ButtonGo);

        alsubcategory = new ArrayList<>();

        aasubcategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alsubcategory);

        spnSub.setAdapter(aasubcategory);


        final String[] subcategoryRP = getResources().getStringArray(R.array.subcategoryRP);
        final String[] subcategorySOI = getResources().getStringArray(R.array.subcategorySOI);




        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:

                        alsubcategory.clear();
                        alsubcategory.addAll(Arrays.asList(subcategoryRP));
                        spnSub.setSelection(0);
                        break;
                    case 1:
                        alsubcategory.clear();
                        alsubcategory.addAll(Arrays.asList(subcategorySOI));
                        spnSub.setSelection(0);
                        break;
                }
                aasubcategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "";

                if (spnCategory.getSelectedItemPosition() == 0) {


                    if (spnSub.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/";
                    } else if (spnSub.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }


                }

                else if (spnCategory.getSelectedItemPosition() == 1) {
                    if(spnSub.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    }
                    else if (spnSub.getSelectedItemPosition() == 1) {
                        url ="https://www.rp.edu.sg/student-life";
                    }
                }
                Intent intent = new Intent(MainActivity.this,Webpageview.class);
                intent.putExtra("website", url);
                startActivity(intent);




            }
        });

    }
}
