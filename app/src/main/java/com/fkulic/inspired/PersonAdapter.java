package com.fkulic.inspired;

import android.content.Context;
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
//        Log.d(TAG, "getView: started");
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item_person, null);
        }

        ImageView ivPicture = (ImageView) convertView.findViewById(R.id.ivPicture);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvLifespan = (TextView) convertView.findViewById(R.id.tvLifespan);
        TextView tvBio = (TextView) convertView.findViewById(R.id.tvBio);

        InspiringPerson person = inspiringPeople.get(position);

        ivPicture.setImageResource(person.getImgLoc());
        tvName.setText(person.getName());
        tvLifespan.setText(person.getLifespan());
        tvBio.setText(person.getShortBio());

//        Log.d(TAG, "getView: returning view for" + person.getName());
        return convertView;
    }
}
