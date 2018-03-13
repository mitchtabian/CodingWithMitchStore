package pluralsight.com.codingwithmitchstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import pluralsight.com.codingwithmitchstore.models.Product;
import pluralsight.com.codingwithmitchstore.util.BigDecimalUtil;


public class CartRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "CartRecyclerViewAd";

    private static final int PRODUCT_TYPE = 1;
    private static final int HEADER_TYPE = 2;

    //vars
    private ArrayList<Product> mProducts = new ArrayList<>();
    private Context mContext;


    public CartRecyclerViewAdapter(Context context, ArrayList<Product> products) {
        mContext = context;
        mProducts = products;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case PRODUCT_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_cart_list_item, parent, false);
                return new ViewHolder(view);
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_cart_section_header, parent, false);
                return new SectionHeaderViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_cart_list_item, parent, false);
                return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);
        if (itemViewType == PRODUCT_TYPE) {
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);

            Glide.with(mContext)
                    .setDefaultRequestOptions(requestOptions)
                    .load(mProducts.get(position).getImage())
                    .into(((ViewHolder)holder).image);

            ((ViewHolder)holder).title.setText(mProducts.get(position).getTitle());
            ((ViewHolder)holder).price.setText(BigDecimalUtil.getValue(mProducts.get(position).getPrice()));
        }
        else{
            SectionHeaderViewHolder headerViewHolder = (SectionHeaderViewHolder) holder;
            headerViewHolder.sectionTitle.setText(mProducts.get(position).getTitle());
        }


    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(TextUtils.isEmpty(mProducts.get(position).getType())){
            return HEADER_TYPE;
        }
        else{
            return PRODUCT_TYPE;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, price;
        RelativeLayout parentView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            parentView = itemView.findViewById(R.id.parent);
        }
    }

    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {

        TextView sectionTitle;

        public SectionHeaderViewHolder(View itemView) {
            super(itemView);
            sectionTitle = itemView.findViewById(R.id.cart_section_header);
        }
    }
}

















