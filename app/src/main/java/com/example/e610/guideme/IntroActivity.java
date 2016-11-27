package com.example.e610.guideme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.e610.guideme.Utils.MyAlertDialog;

/**
 * Created by E610 on 27/11/2016.
 */
public class IntroActivity extends AppCompatActivity {
    int count;
    EditText radiusText;
    ListView lv1;
    Button continueButton;
    private String lv_items[] = { "cafe", "restaurant", "hospital",
            "airport", "accounting", "bank", "gas_station", "university",
            "train_station", "school", "shopping_mall" ,"post_office","police","lawyer"};
     Intent intent;
    String type="",radius="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.intro_activity);
        count=0;
        lv1 = (ListView) findViewById(R.id.list1);
        continueButton = (Button) findViewById(R.id.Continue);
         radiusText = (EditText) findViewById(R.id.radius);

        //	Set option as Multiple Choice. So that user can able to select more the one option from list
        lv1.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, lv_items));
        lv1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(count==0)
                    type=lv_items[i];
                else
                {
                    type+="|"+lv_items[i];
                }
                count++;
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radius=radiusText.getText().toString();

                try{
                    Double.valueOf(radius);
                }catch (Exception e){
                    radius="10000";
                    MyAlertDialog myAlertDialog=new MyAlertDialog();
                    myAlertDialog.showAlertDialog(IntroActivity.this,"Error","Please Enter Valid Number",false);
                }

                if(type.equals(""))
                    type="hospital|university|gas_station|train_station|school|shopping_mall|post_office|police";
                intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("type",type);
                intent.putExtra("radius",radius);
                startActivity(intent);

            }
        });


    }
}
