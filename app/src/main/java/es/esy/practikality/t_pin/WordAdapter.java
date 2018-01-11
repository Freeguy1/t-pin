package es.esy.practikality.t_pin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words){
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView nameTV = (TextView) listItemView.findViewById(R.id.listitem_name);
        nameTV.setText(currentWord.getName());

        TextView dayTV = (TextView) listItemView.findViewById(R.id.listitem_day);
        dayTV.setText(currentWord.getDay());

        TextView dateTV = (TextView) listItemView.findViewById(R.id.listitem_date);
        dateTV.setText(currentWord.getDate());

        TextView timeTV = (TextView) listItemView.findViewById(R.id.listitem_time);
        timeTV.setText(currentWord.getTime());

        return listItemView;
    }
}
