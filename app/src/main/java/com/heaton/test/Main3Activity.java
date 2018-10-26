package com.heaton.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.radioButton)
    RadioButton radioButton;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.switch1)
    Switch switch1;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.seekBar2)
    SeekBar seekBar2;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.toggl_button)
    ToggleButton togglButton;
    @BindView(R.id.button)
    Button button;
    Disposable mDisposable = null;
    private Observable novel;
    private Observer<String> reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
       /* reader = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(String value) {
                Logger.d(value);
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("--onError");
            }

            @Override
            public void onComplete() {
                Logger.d("onComplete");
            }
        };
*/

    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Logger.d("onViewClicked");
        Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("连1");
                e.onNext("连2");
                e.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Logger.e("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                Logger.e("onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("onError=" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Logger.e("onComplete()");
            }
        });


        //novel.subscribe(reader);
    }
}
