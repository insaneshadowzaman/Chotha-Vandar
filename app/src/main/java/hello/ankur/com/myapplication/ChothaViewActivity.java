package hello.ankur.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import hello.ankur.com.myapplication.Util.ChothaAdapter;
import hello.ankur.com.myapplication.Util.CourseAdapter;
import hello.ankur.com.myapplication.model.Chotha;
import hello.ankur.com.myapplication.model.Course;

public class ChothaViewActivity extends Activity {
    public static final String ID = "id";
    RecyclerView recyclerView;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chotha_view);

        String id = getIntent().getStringExtra(ID);

        recyclerView = findViewById(R.id.recycler_view_chotha);
        addButton = findViewById(R.id.button_add_chotha);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(Constants.CHOTHAS);
        Query query = FirebaseDatabase.getInstance().getReference().child(id);
        ChothaAdapter adapter = new ChothaAdapter(
                Chotha.class,
                R.layout.chotha_view,
                ChothaAdapter.ChothaViewHolder.class,
                query,
                this
        );

        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChothaViewActivity.this, AddChothaActivity.class);
                startActivity(intent);
            }
        });
    }
}
