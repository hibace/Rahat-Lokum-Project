package io.yalkaev.rahat_lokum.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import io.yalkaev.rahat_lokum.dto.OrderDTO;
import java.util.List;
import io.yalkaev.rahat_lokum.R;


public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private List<OrderDTO> data;

    public OrderListAdapter(List<OrderDTO> data) {
        this.data = data;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        OrderDTO item = data.get(position);
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;

        public OrderViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void setData(List<OrderDTO> data) {
        this.data = data;
    }
}
