package hello.ankur.com.myapplication.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import hello.ankur.com.myapplication.R;
import hello.ankur.com.myapplication.model.Chotha;
import hello.ankur.com.myapplication.model.Course;


public class ChothaAdapter extends FirebaseRecyclerAdapter<Chotha, ChothaAdapter.ChothaViewHolder> {
    private Context context;
    public ChothaAdapter(Class<Chotha> modelClass, int modelLayout, Class<ChothaViewHolder> viewHolderClass, Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(ChothaViewHolder viewHolder, final Chotha model, int position) {
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getLink()));
                context.startActivity(intent);
            }
        });
        viewHolder.nameText.setText(model.getName());
        viewHolder.uploaderText.setText(model.getUploader());
    }

    public class ChothaViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, uploaderText;
        Button btn;
        public ChothaViewHolder(View itemView) {

            super(itemView);
            nameText = itemView.findViewById(R.id.course_view_name);
            uploaderText = itemView.findViewById(R.id.chotha_view_uploader);
            btn = itemView.findViewById(R.id.chotha_view_button);
        }



    }
}
