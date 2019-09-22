package com.akshat.memecreator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class BottomPictureFragment extends Fragment {

    private static TextView topTextView;
    private static TextView bottomTextView;

    @Nullable
    @Override
    //the following method is to inform the view which layout we are gonna use
    //basically tell it we are using the bottom_section_fragment xml file
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate method->this is what layout we are using for this fragment
        View view = inflater.inflate(R.layout.bottom_section_fragment,container,false);

        topTextView = (TextView)view.findViewById(R.id.topTextView);
        bottomTextView = (TextView)view.findViewById(R.id.bottomTextView);

        return(view);//return reference to the xml file
    }

    public void setMemeText(String top,String bottom){
        topTextView.setText(top);
        bottomTextView.setText(bottom);
    }
}

