package id.rofiqoff.examplefilterdataactivityfragment.java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.rofiqoff.examplefilterdataactivityfragment.Data;
import id.rofiqoff.examplefilterdataactivityfragment.DataViewHolder;
import id.rofiqoff.examplefilterdataactivityfragment.R;
import id.rofiqoff.examplefilterdataactivityfragment.Adapter;

import static id.rofiqoff.examplefilterdataactivityfragment.DataKt.getDatas;

public class DataFragment extends Fragment {

    private RecyclerView listData;

    private Adapter<Data, DataViewHolder> adapter;

    private View itemView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.fragment_data, container, false);
        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        listData = itemView.findViewById(R.id.list_data);

        initAdapter();

        listData.setAdapter(adapter);

        ((MainActivity) getActivity()).setDataSearch(new MainActivity.SearchListener() {
            @Override
            public void onSearch(String dataToString) {
                search(dataToString);
            }
        });
    }

    private void initAdapter() {
        adapter = new Adapter<Data, DataViewHolder>(R.layout.row_list_data, DataViewHolder.class, getDatas()) {
            @Override
            protected void bindView(@org.jetbrains.annotations.Nullable DataViewHolder holder, Data model, int position) {
                holder.onBind(model);
            }
        };
    }

    private void search(String dataToString) {
        List<Data> dataFilter = new ArrayList<Data>();

        for (int i = 0; i < dataFilter.size() - 1; i++) {
            String textData = getDatas().get(i).getTextData();

            if (dataToString.contains(textData.toLowerCase())) {
                dataFilter.add(new Data(textData));
            }
        }

        if (dataToString == "") {
            adapter.updateData(getDatas());
        } else {
            adapter.updateData(dataFilter);
        }

    }
}
