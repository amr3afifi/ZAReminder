package com.example.reminder;

import android.content.Context;
import android.database.Cursor;
import com.example.reminder.RemindersDbAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;

public class RemindersSimpleCursorAdapter extends SimpleCursorAdapter {
    private LayoutInflater cursorInflater;

    public RemindersSimpleCursorAdapter(Context context, int layout, Cursor c, String[]
            from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //to use a viewholder, you must override the following two methods and define a ViewHolder class
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.colImp = cursor.getColumnIndexOrThrow(RemindersDbAdapter.COL_IMPORTANT);
            holder.listTab = view.findViewById(R.id.row_tab);
            view.setTag(holder);

        }
        if (cursor.getInt(holder.colImp) > 0) {
            holder.listTab.setBackgroundColor(ContextCompat.getColor(context,R.color.important));
        } else {
            holder.listTab.setBackgroundColor(ContextCompat.getColor(context,R.color.normal));
        }
    }
    static class ViewHolder {
        //store the column index
        int colImp;
        //store the view
        View listTab;
    }

}
