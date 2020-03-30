package com.archangel.droidcafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    private static String mOrderMessage;
    public static final String EXTRA_MESSAGE = "com.archangel.droidcafe.extra.MESSAGE";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Add clickable behavior to the images set of android versions

        view.findViewById(R.id.dounts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrderMessage = getString(R.string.donut_order_message);
                displayToast(mOrderMessage);
            }
        });

        view.findViewById(R.id.ice_cream).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrderMessage = getString(R.string.ice_cream_order_message);
                displayToast(mOrderMessage);
            }
        });

        view.findViewById(R.id.froyo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrderMessage = getString(R.string.froyo_order_message);
                displayToast(mOrderMessage);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static String getOrderMessage() {
        return mOrderMessage;
    }
}
