package com.peacecorps.pcsa.support_services;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.peacecorps.pcsa.R;

/**
 * Steps in Reporting
 *
 * @author Buddhiprabha Erabadda
 * @since 07-08-2015
 */
public class StepsFragment extends Fragment {

    public final static String TAG = StepsFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reporting_steps, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.after_assault);

        DocumentView reporting_step1 = (DocumentView) rootView.findViewById(R.id.reporting_step1);
        DocumentView reporting_step2 = (DocumentView) rootView.findViewById(R.id.reporting_step2);
        DocumentView reporting_step3 = (DocumentView) rootView.findViewById(R.id.reporting_step3);
        DocumentView reporting_step4 = (DocumentView) rootView.findViewById(R.id.reporting_step4);
        DocumentView reporting_step5 = (DocumentView) rootView.findViewById(R.id.reporting_step5);
        DocumentView reporting_step6 = (DocumentView) rootView.findViewById(R.id.reporting_step6);

        reporting_step1.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        reporting_step1.getDocumentLayoutParams().setHyphenated(true);
        reporting_step2.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        reporting_step2.getDocumentLayoutParams().setHyphenated(true);
        reporting_step3.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        reporting_step3.getDocumentLayoutParams().setHyphenated(true);
        reporting_step4.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        reporting_step4.getDocumentLayoutParams().setHyphenated(true);
        reporting_step5.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        reporting_step5.getDocumentLayoutParams().setHyphenated(true);
        reporting_step6.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.
                getInstance(DefaultHyphenator.HyphenPattern.PT));
        reporting_step6.getDocumentLayoutParams().setHyphenated(true);

        reporting_step1.setText(Html.fromHtml(getResources().getString(R.string.reporting_step1)));
        reporting_step2.setText(Html.fromHtml(getResources().getString(R.string.reporting_step2)));
        reporting_step3.setText(Html.fromHtml(getResources().getString(R.string.reporting_step3)));
        reporting_step4.setText(Html.fromHtml(getResources().getString(R.string.reporting_step4)));
        reporting_step5.setText(Html.fromHtml(getResources().getString(R.string.reporting_step5)));
        reporting_step6.setText(Html.fromHtml(getResources().getString(R.string.reporting_step6)));
        return rootView;
    }
}
