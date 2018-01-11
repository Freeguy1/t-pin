package es.esy.practikality.t_pin;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView timeview = (TextView) findViewById(R.id.time_view);
        TextView dateview = (TextView) findViewById(R.id.date_view);
        Date time = new Date();
        String date = new SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(time);
        String timeNow = new SimpleDateFormat("HH:mm" , Locale.getDefault()).format(time);
        timeview.setText(timeNow);
        dateview.setText(date);
        SharedPreferences sharedPref = getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
        int firstTime = sharedPref.getInt("firstTime",9876789);
        if (firstTime==9876789){
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("firstTime",1);
            editor.putInt("masterPin",1111);
            editor.putString("masterName","Master User");
            editor.putInt("mem2Pin",1111);
            editor.putString("mem2Name","User 2");
            editor.putInt("mem3Pin",1111);
            editor.putString("mem3Name","User 3");
            editor.putInt("mem4Pin",1111);
            editor.putString("mem4Name","User 4");
            editor.putInt("mem5Pin",1111);
            editor.putString("mem5Name","User 5");
            editor.putInt("mem6Pin",1111);
            editor.putString("mem6Name","User 6");
            editor.putString("toChange","masteruser");
            editor.putString("savedLogs","-mamarray-mamarray-mamarray-");
            showToast("Default pin is 1111");
            editor.commit();
        }
    }
    public void gotomanage(){
        Intent backfromlogsIntent = new Intent(MainActivity.this, PinManage.class);
        startActivity(backfromlogsIntent);
    }
    public void press1(View view){ pinbuilder("1");}
    public void press2(View view){ pinbuilder("2");}
    public void press3(View view){ pinbuilder("3");}
    public void press4(View view){ pinbuilder("4");}
    public void press5(View view){ pinbuilder("5");}
    public void press6(View view){ pinbuilder("6");}
    public void press7(View view){ pinbuilder("7");}
    public void press8(View view){ pinbuilder("8");}
    public void press9(View view){ pinbuilder("9");}
    public void press0(View view){ pinbuilder("0");}

    private void pinbuilder(String currentNumber){
        pin += currentNumber;
        switch (pin.length()){
            case 1:
                ImageView pin1 = (ImageView) findViewById(R.id.pin1);
                pin1.setBackgroundResource(R.drawable.filled);
                break;
            case 2:
                ImageView pin2 = (ImageView) findViewById(R.id.pin2);
                pin2.setBackgroundResource(R.drawable.filled);
                break;
            case 3:
                ImageView pin3 = (ImageView) findViewById(R.id.pin3);
                pin3.setBackgroundResource(R.drawable.filled);
                break;
            case 4:
                ImageView pin4 = (ImageView) findViewById(R.id.pin4);
                pin4.setBackgroundResource(R.drawable.filled);
                SharedPreferences sharedPref = getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
                int masterpin = sharedPref.getInt("masterPin",111111);
                int mem2pin = sharedPref.getInt("mem2Pin",222222);
                int mem3pin = sharedPref.getInt("mem3Pin",333333);
                int mem4pin = sharedPref.getInt("mem4Pin",444444);
                int mem5pin = sharedPref.getInt("mem5Pin",555555);
                int mem6pin = sharedPref.getInt("mem6Pin",666666);
                int pinNow = Integer.parseInt(pin);
                pin = "";
                String logsString = sharedPref.getString("savedLogs","-mamarray-mamarray-mamarray-");
                Date time = new Date();
                String date = new SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(time);
                String timeNow = new SimpleDateFormat("HH:mm" , Locale.getDefault()).format(time);
                Calendar cal = Calendar.getInstance(Locale.getDefault());
                int day = cal.get(Calendar.DAY_OF_WEEK);
                String dayNow = getDayName(day);
                String logToPut = "mamarray" + dayNow + "mamarray" + date + "mamarray" + timeNow + "paparray" + logsString;
                SharedPreferences.Editor editor = sharedPref.edit();
                if(pinNow==masterpin){
                    String userName = sharedPref.getString("masterName","Master User");
                    logToPut = userName + logToPut;
                    editor.putString("savedLogs",logToPut);
                    editor.apply();
                    gotomanage();
                }
                else if(pinNow==mem2pin){
                    String userName = sharedPref.getString("mem2Name","User 2");
                    logToPut = userName + logToPut;
                    editor.putString("savedLogs",logToPut);
                    editor.apply();
                    finish();
                }
                else if(pinNow==mem3pin){
                    String userName = sharedPref.getString("mem3Name","User 3");
                    logToPut = userName + logToPut;
                    editor.putString("savedLogs",logToPut);
                    editor.apply();
                    finish();
                }
                else if(pinNow==mem4pin){
                    String userName = sharedPref.getString("mem4Name","User 4");
                    logToPut = userName + logToPut;
                    editor.putString("savedLogs",logToPut);
                    editor.apply();
                    finish();
                }
                else if(pinNow==mem5pin){
                    String userName = sharedPref.getString("mem5Name","User 5");
                    logToPut = userName + logToPut;
                    editor.putString("savedLogs",logToPut);
                    editor.apply();
                    finish();
                }
                else if(pinNow==mem6pin){
                    String userName = sharedPref.getString("mem6Name","User 6");
                    logToPut = userName + logToPut;
                    editor.putString("savedLogs",logToPut);
                    editor.apply();
                    finish();
                }
                else{
                    ImageView pinFirst = (ImageView) findViewById(R.id.pin1);
                    pinFirst.setBackgroundResource(R.drawable.pink);
                    ImageView pinSecond = (ImageView) findViewById(R.id.pin2);
                    pinSecond.setBackgroundResource(R.drawable.pink);
                    ImageView pinThird = (ImageView) findViewById(R.id.pin3);
                    pinThird.setBackgroundResource(R.drawable.pink);
                    ImageView pinFour = (ImageView) findViewById(R.id.pin4);
                    pinFour.setBackgroundResource(R.drawable.pink);
                    showToast("Try Again");
                }
                break;
            default:
                break;
        }
    }
    public String pin = "";
    private void showToast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();
    }
    private String getDayName(int day){
        switch(day){
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "Error";
        }
    }
}
