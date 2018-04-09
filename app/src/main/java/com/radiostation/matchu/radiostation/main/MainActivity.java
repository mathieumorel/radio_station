package com.radiostation.matchu.radiostation.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.radiostation.matchu.radiostation.R;
import com.radiostation.matchu.radiostation.main.presenter.MainPresenter;
import com.radiostation.matchu.radiostation.main.view.MainViewBinder;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainViewBinder {

    @Inject MainPresenter mPresenter;

    private Button mRadioToggleButton;
    private TextView mTrackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRadioToggleButton = findViewById(R.id.radioToggleButton);
        mRadioToggleButton.setOnClickListener(mRadioToggleClickListener);

        mTrackTextView = findViewById(R.id.trackTextView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onViewAvailable(this);
    }

    private View.OnClickListener mRadioToggleClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.listenToRadio(mTrackTextView);
        }
    };

    @Override
    public void disableToggleButton() {
        mRadioToggleButton.setEnabled(false);
    }

    @Override
    public void setRadioToggleText(int res) {
        mRadioToggleButton.setText(res);
    }
}


