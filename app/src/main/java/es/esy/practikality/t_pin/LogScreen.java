package es.esy.practikality.t_pin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class LogScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_screen);
        SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String mainArray = sharedPref.getString("savedLogs","-mamarray-mamarray-mamarray-");
        String[] subArray = mainArray.split("paparray");
        ArrayList<Word> words = new ArrayList<Word>();
        for(int i=0;i<subArray.length;i++){
            String[] currentArr = subArray[i].split("mamarray");
            words.add(new Word(currentArr[0],currentArr[1],currentArr[2],currentArr[3]));
        }

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.logviewlist);
        listView.setAdapter(adapter);
    }
    public void backfromlogs(View view){
        Intent backfromlogsIntent = new Intent(LogScreen.this, PinManage.class);
        startActivity(backfromlogsIntent);
    }
    public void clearLogs(View view){
        SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("savedLogs","-mamarray-mamarray-mamarray-");
        editor.apply();
    }
}
