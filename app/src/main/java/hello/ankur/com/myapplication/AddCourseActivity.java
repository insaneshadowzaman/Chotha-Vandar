package hello.ankur.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import hello.ankur.com.myapplication.model.Course;

public class AddCourseActivity extends Activity {

    EditText nameEdittext, codeEdittext, teacherEdittext1, teacherEdittext2;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        initViews();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference db = database.getReference().child(Constants.COURSES);

                Course course = new Course(
                    nameEdittext.getText().toString(),
                    teacherEdittext1.getText().toString(),
                    teacherEdittext2.getText().toString(),
                    0,
                    null
                );
                String key = db.push().getKey();
                db.child(key).setValue("A radom string").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(!task.isSuccessful())

                            Toast.makeText(AddCourseActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
//                db.child(key).setValue(course).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(!task.isSuccessful())
//                            Toast.makeText(AddCourseActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                });
            }
        });
    }

    private void initViews() {
        submitButton = findViewById(R.id.button_submit_course);
        nameEdittext = findViewById(R.id.edittext_course_name);
        codeEdittext = findViewById(R.id.edittext_course_code);
        teacherEdittext1 = findViewById(R.id.edittext_teacher1);
        teacherEdittext2 = findViewById(R.id.edittext_teacher2);
    }
}
