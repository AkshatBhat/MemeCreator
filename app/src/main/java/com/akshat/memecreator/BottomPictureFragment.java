package com.akshat.memecreator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;
import android.content.ContentResolver;


import java.io.FileNotFoundException;
import java.io.InputStream;


public class BottomPictureFragment extends Fragment {

    private static TextView topTextView;
    private static TextView bottomTextView;
    RelativeLayout rel;
    ImageView imageView;

    @Nullable
    @Override
    //the following method is to inform the view which layout we are gonna use
    //basically tell it we are using the bottom_section_fragment xml file
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate method->this is what layout we are using for this fragment
        View view = inflater.inflate(R.layout.bottom_section_fragment,container,false);

        topTextView = (TextView)view.findViewById(R.id.topTextView);
        bottomTextView = (TextView)view.findViewById(R.id.bottomTextView);
        imageView = (ImageView)view.findViewById(R.id.imageView);
        rel = (RelativeLayout)view.findViewById(R.id.rel);

        return(view);//return reference to the xml file
    }

    public void setMemeText(String top,String bottom){
        topTextView.setText(top);
        bottomTextView.setText(bottom);
    }

    public void setBackground(Uri uri) {
        try {
            InputStream imageStream = getActivity().getContentResolver().openInputStream(uri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

            selectedImage = getResizedBitmap(selectedImage, 1000);// 400 is for example, replace with desired size

            imageView.setImageBitmap(selectedImage);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }
}

