package com.akshat.memecreator;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
public class TopSectionFragment extends Fragment {
    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top,String bottom);
    }

    @Override
    //attach this fragment to Main Activity
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener)getActivity();// Say Here
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString());
        }
    }

    @Nullable
    @Override
    //the following method is to inform the view which layout we are gonna use
    //basically tell it we are using the top_section_fragment xml file
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate method->this is what layout we are using for this fragment
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);

        topTextInput = (EditText)view.findViewById(R.id.topTextInput); //note view object...
        // we arent in onCreate method!!
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
        final Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        buttonClicked();
                    }
                }
        );
        return(view);//return reference to the xml file
    }
    //calls the following when the button is clicked
    public void buttonClicked(){
        activityCommander.createMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }

}

