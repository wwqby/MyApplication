package com.example.zy.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zy.myapplication.R;
import com.example.zy.myapplication.Utils.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_pictures)
    RecyclerView rvPictures;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "1");
        args.putString(ARG_PARAM2, "2");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        rvPictures=(RecyclerView)view.findViewById(R.id.rv_pictures);
        List<Integer> datas=new ArrayList<>();
        datas.add(R.drawable.ic_back_1);
        datas.add(R.drawable.ic_back_2);
        datas.add(R.drawable.ic_back_3);
        datas.add(R.drawable.ic_back_4);
        datas.add(R.drawable.ic_back_5);
        datas.add(R.drawable.ic_back_6);

        LinearLayoutManager linear = new LinearLayoutManager(this.getContext());
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        rvPictures.setLayoutManager(linear);
        RecycleViewAdapter adapter=new RecycleViewAdapter(this.getContext(),datas);
        adapter.setOnItemClickListener(new RecycleViewAdapter.OnItemClickListener() {
            @Override
            public void ItemClick(View view, int position) {
                Toast.makeText(getActivity(), "You click picture "+position, Toast.LENGTH_SHORT).show();
            }
        });
        rvPictures.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
