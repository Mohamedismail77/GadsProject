package com.ismail.gads;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.ismail.gads.network.ServicesModule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GADsProject extends ViewModel implements LifecycleObserver {

    public enum States{
        CHECK,ERROR,SUCCESS,PROGRESS,IDLE
    }

    private static final String TAG = "SubmitViewModel";
    private Disposable subscribe;

    public MutableLiveData<String> firstName = new MutableLiveData<>("");
    public MutableLiveData<String> lastName = new MutableLiveData<>("");
    public MutableLiveData<String> email = new MutableLiveData<>("");
    public MutableLiveData<String> link = new MutableLiveData<>("");
    private MutableLiveData<List<Record>> leadersList = new MutableLiveData<>(new ArrayList<Record>());
    private MutableLiveData<States> states = new MutableLiveData<>();

    public LiveData<States> getStates() {
        return states;
    }

    public LiveData<List<Record>> getLeadersList() {
        return leadersList;
    }


    public void loadLeadersList(String topic){
        leadersList.setValue(new ArrayList<>());
        states.setValue(States.PROGRESS);
        subscribe = ServicesModule.getInstance("https://gadsapi.herokuapp.com").Routes().getLeadersList(topic)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recordList -> {
                    leadersList.setValue(recordList);
                    states.setValue(States.IDLE);
                }, throwable -> {

                });
    }

    public void submit() {
        // submit project
        states.setValue(States.PROGRESS);
        subscribe = ServicesModule.getInstance("https://docs.google.com/forms/d/e/").Routes().submitProjectWithFields(
                    firstName.getValue(),
                    lastName.getValue(),
                    email.getValue(),
                    link.getValue())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(objectResponse -> {
                        if (objectResponse.code() == 200) {
                            states.setValue(States.SUCCESS);
                        }else {
                            states.setValue(States.ERROR);
                        }

                    },throwable -> {
                        throwable.printStackTrace();
                        states.setValue(States.ERROR);
                    });
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        subscribe.dispose();
    }

}
