package com.fortests.meet7practicediff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"Person1",27));
        personList.add(new Person(2,"Person2",26));
        personList.add(new Person(3,"Person3",25));
        personList.add(new Person(4,"Person4",24));
        personList.add(new Person(5,"Person5",23));
        personList.add(new Person(6,"Person6",22));
        personList.add(new Person(7,"Person7",21));
        personList.add(new Person(8,"Person8",20));

        mAdapter = new MyAdapter(personList);
        mRecyclerView.setAdapter(mAdapter);

        mButton = findViewById(R.id.update_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Person> personList = new ArrayList<>();
                personList.add(new Person(1,"Person123",27));
                personList.add(new Person(2,"Person21",26));
                personList.add(new Person(3,"Person3",25));
                personList.add(new Person(4,"Person4",24));
                personList.add(new Person(5,"Person5",233));
                personList.add(new Person(6,"Person633",22));
                personList.add(new Person(7,"Person7",21));
                personList.add(new Person(8,"Person8",2));
                mAdapter.onNewData(personList);
            }
        });

    }
}
