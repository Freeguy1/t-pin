package es.esy.practikality.t_pin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static es.esy.practikality.t_pin.R.id.member2pin;
import static es.esy.practikality.t_pin.R.id.text;

public class PinManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_manage);
        showToast("Click to Edit User's Name and Pins");
        SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        //master user
        String masterName = sharedPref.getString("masterName","Master User");
        setTextcustom(R.id.masterusername,masterName);
        //user 2
        String member2Name = sharedPref.getString("mem2Name","User 2");
        setTextcustom(R.id.member2name,member2Name);
        int member2Pin = sharedPref.getInt("mem2Pin",10101);
        String m2Pin = addornot(member2Pin);
        setTextcustom(R.id.member2pin,m2Pin);
        //user 3
        String member3Name = sharedPref.getString("mem3Name","User 3");
        setTextcustom(R.id.member3name,member3Name);
        int member3Pin = sharedPref.getInt("mem3Pin",10101);
        String m3Pin = addornot(member3Pin);
        setTextcustom(R.id.member3pin,m3Pin);
        //user 4
        String member4Name = sharedPref.getString("mem4Name","User 4");
        setTextcustom(R.id.member4name,member4Name);
        int member4Pin = sharedPref.getInt("mem4Pin",10101);
        String m4Pin = addornot(member4Pin);
        setTextcustom(R.id.member4pin,m4Pin);
        //user 5
        String member5Name = sharedPref.getString("mem5Name","User 5");
        setTextcustom(R.id.member5name,member5Name);
        int member5Pin = sharedPref.getInt("mem5Pin",10101);
        String m5Pin = addornot(member5Pin);
        setTextcustom(R.id.member5pin,m5Pin);
        //user 6
        String member6Name = sharedPref.getString("mem6Name","User 6");
        setTextcustom(R.id.member6name,member6Name);
        int member6Pin = sharedPref.getInt("mem6Pin",10101);
        String m6Pin = addornot(member6Pin);
        setTextcustom(R.id.member6pin,m6Pin);
    }
    public void logs(View view){
        Button viewLogs = (Button) findViewById(R.id.viewlogs_button);
        Intent viewLogsIntent = new Intent(PinManage.this, LogScreen.class);
        startActivity(viewLogsIntent);
    }
    private void showToast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }
    public void setTextcustom(int inp_id, String texttoadd){
        TextView textView = (TextView) findViewById(inp_id);
        textView.setText(texttoadd);
    }
    public void masterChange(View view){toChange("masteruser");}
    public void secondChange(View view){toChange("member2");}
    public void thirdChange(View view){toChange("member3");}
    public void fourthChange(View view){toChange("member4");}
    public void fifthChange(View view){toChange("member5");}
    public void sixthChange(View view){toChange("member6");}
    public void toChange(String memberName){
        SharedPreferences sharedPref = getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("toChange",memberName);
        editor.apply();
        Intent viewLogsIntent = new Intent(PinManage.this, ChangeDetails.class);
        startActivity(viewLogsIntent);
    }
    public String addornot(int pinNow){
        if(pinNow==10101){
            return "Click to Add";
        }else{
            return String.valueOf(pinNow);
        }
    }
}
