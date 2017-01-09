package com.peacecorps.pcsa.safety_tools;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.peacecorps.pcsa.R;

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 *
 * @author rohan
 * @since 08-07-2016.
 */
public class ScreenSlideCustomPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    int no_of_pages;
    private int[] steps;

    public ScreenSlideCustomPagerAdapter(Context context, int[] steps, int no_of_pages) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.steps = steps;
        this.no_of_pages = no_of_pages;
    }

    @Override
    public int getCount() {
        return no_of_pages;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.fragment_viewpager, container, false);
        DocumentView textView = (DocumentView) itemView.findViewById(R.id.justifiedTextView);
        textView.setText(Html.fromHtml(mContext.getString(steps[position])));
        textView.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        textView.getDocumentLayoutParams().setHyphenated(true);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}