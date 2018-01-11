package es.esy.practikality.t_pin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_details);
        SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String toChange = sharedPref.getString("toChange","error");
        TextView detailsAbout = (TextView) findViewById(R.id.details_about);
        detailsAbout.setText("Details about " + toChange);
    }
    public void gotomanage(View view){
        goBacktoManage();
    }
    public void saveDetails(View view){
        SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String toChange = sharedPref.getString("toChange","error");
        EditText nameAdd = (EditText) findViewById(R.id.name_add);
        EditText pinAdd = (EditText) findViewById(R.id.pin_add);
        if (pinAdd.getText().length()!=4){
            showToast("Enter a 4-digit pin please");
        } else{
            SharedPreferences.Editor editor = sharedPref.edit();
            String pintoaddstring = pinAdd.getText().toString();
            int pintoadd = Integer.parseInt(pintoaddstring);
            String nametoadd = nameAdd.getText().toString();
            if(toChange=="masteruser"){
                editor.putString("masterName",nametoadd);
                editor.putInt("masterPin",pintoadd);
                editor.apply();
            }
            else if(toChange=="member2"){
                editor.putString("mem2Name",nametoadd);
                editor.putInt("mem2Pin",pintoadd);
                editor.apply();
            }
            else if(toChange=="member3"){
                editor.putString("mem3Name",nametoadd);
                editor.putInt("mem3Pin",pintoadd);
                editor.apply();
            }
            else if(toChange=="member4"){
                editor.putString("mem4Name",nametoadd);
                editor.putInt("mem4Pin",pintoadd);
                editor.apply();
            }
            else if(toChange=="member5"){
                editor.putString("mem5Name",nametoadd);
                editor.putInt("mem5Pin",pintoadd);
                editor.apply();
            }
            else if(toChange=="member6"){
                editor.putString("mem6Name",nametoadd);
                editor.putInt("mem6Pin",pintoadd);
                editor.apply();
            }
            showToast("Updated details of " + nametoadd);
            goBacktoManage();
        }
    }
    public void goBacktoManage(){
        Intent backfromEditIntent = new Intent(ChangeDetails.this, PinManage.class);
        startActivity(backfromEditIntent);
    }
    private void showToast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }
}
