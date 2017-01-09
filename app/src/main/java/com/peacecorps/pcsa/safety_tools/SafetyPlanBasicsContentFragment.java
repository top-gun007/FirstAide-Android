package com.peacecorps.pcsa.safety_tools;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.peacecorps.pcsa.R;

/*
 * One Fragment which acts like a placeholder for every different screens of Safety Plan Basics
 *
 * @author rohan
 * @since 2016-07-08
 */
public class SafetyPlanBasicsContentFragment extends DialogFragment {

    public static final String TITLE_KEY = "title";
    public static final String CONTENT_KEY = "content";
    TextView titleToDisplay;
    DocumentView contenttoDisplay;
    LinearLayout parentView;

    /**
     * Populates the required data for the dialog box which appears
     *
     * @param title         title of the dialog box
     * @param contentToShow data to be displayed
     */
    public static void showDialog(FragmentActivity context, String title, String contentToShow) {
        FragmentManager fm = context.getSupportFragmentManager();
        SafetyPlanBasicsContentFragment safetyPlanBasicsContentFragment = new SafetyPlanBasicsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_KEY, title);
        bundle.putString(CONTENT_KEY, contentToShow);
        safetyPlanBasicsContentFragment.setArguments(bundle);
        safetyPlanBasicsContentFragment.show(fm, "Sample Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_safety_plan_basics_content, container, false);
        parentView = (LinearLayout) rootView.findViewById(R.id.myView);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        contenttoDisplay = (DocumentView) rootView.findViewById(R.id.justifiedTextView);
        titleToDisplay = (TextView) rootView.findViewById(R.id.safety_plan_basics_title);
        String title = getArguments().getString(TITLE_KEY);
        String content = getArguments().getString(CONTENT_KEY);
        contenttoDisplay.setText(Html.fromHtml(content));
        contenttoDisplay.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        contenttoDisplay.getDocumentLayoutParams().setHyphenated(true);

        //contenttoDisplay.setMovementMethod(new ScrollingMovementMethod());
        if (title != null) {
            titleToDisplay.setText(Html.fromHtml(title));
            titleToDisplay.setTypeface(null, Typeface.BOLD);
            titleToDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            titleToDisplay.setGravity(Gravity.CENTER);
            getDialog().setTitle(title);
        } else {
            titleToDisplay.setVisibility(View.GONE);
            contenttoDisplay.setLayoutParams
                    (new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        return rootView;
    }
}
