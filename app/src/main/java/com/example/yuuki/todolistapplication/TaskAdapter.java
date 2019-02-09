package com.example.yuuki.todolistapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class TaskAdapter extends RealmBaseAdapter<Task> {
    private static class ViewHolder{
        TextView deadline;
        TextView title;
    }
    public TaskAdapter(OrderedRealmCollection<Task> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.
                    layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.deadline = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.title = (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Task task = adapterData.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = sdf.format(task.getDeadline());
        viewHolder.deadline.setText(formatDate);
        viewHolder.title.setText(task.getTitle());
        return convertView;
    }
}
