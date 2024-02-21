package com.by.myapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;
//import dagger.hilt.android.lifecycle;

@dagger.hilt.android.lifecycle.HiltViewModel
public class HiltViewModel extends ViewModel {
    private MutableLiveData<Integer> uiEvent = new MutableLiveData<>();

    public MutableLiveData<Integer> getUiEvent() {
        uiEvent.postValue(3);
        return uiEvent;
    }

    @Inject
    public HiltViewModel() {

    }
}
