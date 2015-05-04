package rejasupotaro.mds.view.holders;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rejasupotaro.mds.R;
import rejasupotaro.mds.activities.ItemDetailActivity;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.item_image)
    ImageView itemImageView;

    @InjectView(R.id.title)
    TextView textView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public static ItemViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    public void bind(List<Object> items, int position) {
        textView.setText("position: " + position);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemDetailActivity.launch((Activity) itemView.getContext(), itemImageView, "");
            }
        });
    }
}

