package com.example.fragmentsemvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SecondViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SecondViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Second Fragment");
    }

    public void setText(String s) {
        mText.setValue(s);
    }

    public LiveData<String> getText() {
        return mText;
    }
}