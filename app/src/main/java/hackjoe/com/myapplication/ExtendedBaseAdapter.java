package hackjoe.com.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;

public abstract class ExtendedBaseAdapter<T> extends BaseAdapter {

    /**
     *
     */
    private Context context;
    private LayoutInflater inflater;
    private List<T> baseList;

    protected ExtendedBaseAdapter(@NonNull Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        baseList = new ArrayList<>();
    }

    public Context getContext() {
        return context;
    }

    public List<T> getBaseList()
    {
        return baseList;
    }

    protected ExtendedBaseAdapter(@NonNull Context context,@NonNull T[] baseList)
    {
        this(context, Arrays.asList(baseList));
    }

    protected ExtendedBaseAdapter(@NonNull Context context, @NonNull List<T> baseList) {
        this.baseList = baseList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    protected LayoutInflater getInflater() {
        return inflater;
    }

    public void appendToList(@NonNull List<T> baseList) {
        this.baseList.addAll(baseList);
        notifyDataSetChanged();
    }

    public void emptyList()
    {
        this.baseList = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void switchList(@NonNull List<T> baseList) {
        this.baseList = baseList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return baseList.size();
    }

    @Override
    public Object getItem(int position) {
        return baseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract int getViewId();

    protected abstract Object getHolderObject();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object holderObject;
        if(convertView == null)
        {
            convertView = inflater.inflate(getViewId(), parent, false);
            holderObject = getHolderObject();
            convertView.setTag(holderObject);
            ButterKnife.bind(holderObject, convertView);
        }
        else {
            holderObject = convertView.getTag();
        }
        getBoundView(position,holderObject,convertView);
        return convertView;
    }

    protected abstract void getBoundView(int position,@NonNull Object holderObject,@NonNull View convertView);

}