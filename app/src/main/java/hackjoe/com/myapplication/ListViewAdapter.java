package hackjoe.com.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/**
 * Created by keremkusmezer on 21/10/15 01:32.
 */
public class ListViewAdapter extends ExtendedBaseAdapter<SimpleItem> {
    public ListViewAdapter(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void getBoundView(int position, @NonNull Object holderObject, @NonNull View convertView) {

    }

    @Override
    protected int getViewId() {
        return R.layout.listview_item;
    }

    @Override
protected Object getHolderObject() {
return new Holder();
    }
    public static class Holder{
        public TextView tvItemText;
    }
}