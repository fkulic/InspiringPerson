package com.fkulic.inspired;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Filip on 18.3.2017..
 */

public class PersonAdapter  extends BaseAdapter{

    private static final String TAG = "PersonAdapter";

    Context mContext;
    ArrayList<InspiringPerson> inspiringPeople;

    public PersonAdapter(Context context, ArrayList<InspiringPerson> inspiringPeople) {
        mContext = context;
        this.inspiringPeople = inspiringPeople;
    }

    @Override
    public int getCount() {
        return inspiringPeople.size();
    }

    @Override
    public Object getItem(int position) {
        return inspiringPeople.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: started");
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item_person, null);
        }

        ImageView iwPicture = (ImageView) convertView.findViewById(R.id.iwPicture);
        TextView twName = (TextView) convertView.findViewById(R.id.twName);
        TextView twLifespan = (TextView) convertView.findViewById(R.id.twLifespan);
        TextView twBio = (TextView) convertView.findViewById(R.id.twBio);

        InspiringPerson person = inspiringPeople.get(position);

        iwPicture.setImageResource(person.getImgLoc());
        twName.setText(person.getName());
        twLifespan.setText(person.getLifespan());
        twBio.setText(person.getShortBio());

        Log.d(TAG, "getView: returning view for" + person.getName());
        return convertView;
    }
}
