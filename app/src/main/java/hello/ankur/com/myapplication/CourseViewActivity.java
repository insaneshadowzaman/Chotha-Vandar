package hello.ankur.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import hello.ankur.com.myapplication.Util.CourseAdapter;
import hello.ankur.com.myapplication.model.Course;

public class CourseViewActivity extends Activity {

    RecyclerView recyclerView;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view);

        recyclerView = findViewById(R.id.recycler_view_course);
        addButton = findViewById(R.id.button_add_course);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(Constants.COURSES);
        CourseAdapter adapter = new CourseAdapter(
                Course.class,
                R.layout.course_view,
                CourseAdapter.CourseViewHolder.class,
                db
        );
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseViewActivity.this, AddCourseActivity.class);
                startActivity(intent);
            }
        });



    }
}
