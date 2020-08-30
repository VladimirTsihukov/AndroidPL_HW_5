package com.example.androidpl_hw_5.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidpl_hw_5.R;
import com.example.androidpl_hw_5.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.ed_color_fruit)
    EditText editTextColorFruit;

    @BindView(R.id.ed_name_fruit)
    EditText editTextNameFruit;

    @BindView(R.id.ed_get_data_for_id)
    EditText editTextGetDataForId;

    @BindView(R.id.ed_delete_fruit_for_id)
    EditText editTextDeleteFruitForId;

    @BindView(R.id.text_view_name_fruit)
    TextView textViewNameFruit;

    @BindView(R.id.text_view_color_fruit)
    TextView textViewColorFruit;

    @BindView(R.id.ed_delete_fruit_for_name)
    EditText editTextDeleteForName;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainPresenter = new MainPresenter(this);
    }

    @OnClick({R.id.btn_create_data})
    void createData() {
        String nameFruit = editTextNameFruit.getText().toString();
        String colorFruit = editTextColorFruit.getText().toString();

        if (!nameFruit.isEmpty() && !colorFruit.isEmpty()) {
            mainPresenter.putData(nameFruit, colorFruit);
        }
    }

    @OnClick({R.id.btn_get_data})
    void getData() {
        int dataId = Integer.parseInt(editTextGetDataForId.getText().toString());
        if (dataId >= 0) {
            mainPresenter.getDataForId(dataId);
        }
    }

    @OnClick({R.id.btn_delete_data})
    void deleteData() {
        int deleteId = Integer.parseInt(editTextDeleteFruitForId.getText().toString());
        if (deleteId >= 0) {
            mainPresenter.deleteDataForId(deleteId);
        }
    }

    @OnClick(R.id.btn_delete_data_for_name)
    void deleteForName() {
        String deleteName = editTextDeleteForName.getText().toString();
        if (!deleteName.isEmpty()) {
            mainPresenter.deleteForName(deleteName);
        }
    }

    @Override
    public void getData(Fruit fruit) {
        if (fruit != null) {
            textViewNameFruit.setText(fruit.nameFruit);
            textViewColorFruit.setText(fruit.colorFruit);
        }
    }
}