package hello.ankur.com.myapplication.Util;

import android.support.annotation.StringDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

import hello.ankur.com.myapplication.R;
import hello.ankur.com.myapplication.model.Course;

public class CourseAdapter extends FirebaseRecyclerAdapter<Course, CourseAdapter.CourseViewHolder> {
    public CourseAdapter(Class<Course> modelClass, int modelLayout, Class<CourseViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(CourseViewHolder viewHolder, Course model, int position) {
        viewHolder.nameText.setText(model.getName());
        String temp = "Total Number of Contents : " + String.valueOf(model.getTotalContent());
        viewHolder.countText.setText(temp);
        viewHolder.teacher1Text.setText(model.getTeacher1());
        viewHolder.teacher2Text.setText(model.getTeacher2());

    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, teacher1Text, teacher2Text, countText;
        public CourseViewHolder(View itemView) {

            super(itemView);
            nameText = itemView.findViewById(R.id.course_view_name);
            teacher1Text = itemView.findViewById(R.id.course_view_teacher1);
            teacher2Text = itemView.findViewById(R.id.course_view_teacher2);
            countText = itemView.findViewById(R.id.course_view_count);
        }



    }
}
