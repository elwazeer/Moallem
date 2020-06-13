package com.moallem.task.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.moallem.task.R;
import com.moallem.task.adapters.VerticalRecyclerViewAdapter;
import com.moallem.task.models.HorizontalModel;
import com.moallem.task.models.VerticalModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvVertical)
    RecyclerView rvVertical;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ArrayList<VerticalModel> mArrayList = new ArrayList<>();

    VerticalRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        rvVertical.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new VerticalRecyclerViewAdapter(this, mArrayList);

        rvVertical.setAdapter(mAdapter);

        setDataOnVerticalRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void setDataOnVerticalRecyclerView() {

        for (int i = 1; i <= 3; i++) {

            final int resId = getResources().getIdentifier("name" + i, "array", getBaseContext().getPackageName());
            final String[] testArray = getResources().getStringArray(resId);

            final int imgId = getResources().getIdentifier("img" + i, "array", getBaseContext().getPackageName());
            final String[] imgArray = getResources().getStringArray(imgId);

            int count = imgArray.length;
            final int[] ids = new int[count];

            for (int x = 0; x < ids.length; x++)
                ids[x] =  this.getResources().getIdentifier(imgArray[x], "drawable",  getBaseContext().getPackageName());

            VerticalModel mVerticalModel = new VerticalModel();
            if (i==1) mVerticalModel.setTitle(" Subject");
            else if (i==3) mVerticalModel.setTitle(" Professors");
            else mVerticalModel.setTitle(" Welcome Back!\n Continue Learning?");

            ArrayList<HorizontalModel> cartList = new ArrayList<>();

            for (int j = 0; j < testArray.length; j++) {
                HorizontalModel item = new HorizontalModel(ids[j], testArray[j]);
                cartList.add(item);
            }

            mVerticalModel.setArrayList(cartList);

            mArrayList.add(mVerticalModel);
        }
        mAdapter.notifyDataSetChanged();
    }
}
