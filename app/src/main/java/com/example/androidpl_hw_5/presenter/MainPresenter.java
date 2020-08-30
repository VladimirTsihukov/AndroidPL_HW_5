package com.example.androidpl_hw_5.presenter;

import android.util.Log;

import com.example.androidpl_hw_5.view.App;
import com.example.androidpl_hw_5.view.Fruit;
import com.example.androidpl_hw_5.view.FruitDao;
import com.example.androidpl_hw_5.view.MainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private static final String TAG = "MainPresenter";
    private MainView mainView;
    private FruitDao fruitDao;

    public MainPresenter(MainView view) {
        fruitDao = App.getAppDatabase().fruitDao();
        mainView = view;
    }

    public void putData(String nameFruit, String colorFruit) {
        Fruit fruit = new Fruit();
        fruit.nameFruit = nameFruit;
        fruit.colorFruit = colorFruit;

        Disposable disposable = fruitDao.insert(fruit).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(id -> {
                    Log.d(TAG, "putData id: " + id);
                }, throwable -> {
                    Log.e(TAG, "putData error: " + throwable);
                });
    }

    public void getDataForId(int id) {
        Disposable disposable = fruitDao.getAllById(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(fruits -> {
                    Log.d(TAG, "getData: " + fruits + " " + Thread.currentThread().getName());
                    mainView.getData(fruits);
                }, throwable -> {
                    Log.e(TAG, "getData: " + throwable);
                });
    }

    public void deleteDataForId(int dataId) {
        Fruit fruit = new Fruit();
        fruit.id = dataId;

        Disposable disposable = fruitDao.delete(fruit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteData: " + id);
                }, throwable -> {
                    Log.e(TAG, "deleData: " + throwable);
                });
    }

    public void deleteForName(String deleteName) {
        Disposable disposable = fruitDao.deleteForName(deleteName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(fruit -> {
                    Log.d(TAG, "Delete line: " + fruit);
                }, throwable -> {
                    Log.e(TAG, "deleteForName error: " + throwable);
                });
    }
}
