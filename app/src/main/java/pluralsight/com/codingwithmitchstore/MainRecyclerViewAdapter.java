package pluralsight.com.codingwithmitchstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import pluralsight.com.codingwithmitchstore.models.Product;


public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MainRecyclerViewAd";

    //vars
    private ArrayList<Product> mProducts = new ArrayList<>();
    private Context mContext;

    public MainRecyclerViewAdapter(Context context, ArrayList<Product> products) {
        mContext = context;
        mProducts = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_feed_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(mProducts.get(position).getImage())
                .into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ViewProductActivity.class);
                intent.putExtra(mContext.getString(R.string.intent_product), mProducts.get(position));
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mProducts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}

















