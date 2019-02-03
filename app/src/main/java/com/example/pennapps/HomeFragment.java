package com.example.pennapps;

import android.animation.ValueAnimator;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Button;
public class HomeFragment extends Fragment {
    private int barStat = 0;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        final ProgressBar bar = (ProgressBar) view.findViewById(R.id.progressbar);

       // final EditText input = (EditText) view.findViewById(R.id.number);
        final ImageView happyImage = (ImageView) view.findViewById(R.id.happy);
        final ImageView sadImage = (ImageView) view.findViewById(R.id.sad);
        sadImage.setVisibility(View.INVISIBLE);
        happyImage.setVisibility(View.INVISIBLE);
        Button button = (Button) view.findViewById(R.id.button);



      button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // String progress = input.getText().toString();
              //  bar.setProgress(Integer.parseInt(progress));
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       while(barStat < 100) {
                           barStat++;
                           android.os.SystemClock.sleep(300);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    bar.setProgress(barStat);
                                    if(bar.getProgress() <= 20) {
                                        sadImage.setVisibility(View.VISIBLE);
                                    } else {
                                        sadImage.setVisibility(View.GONE);
                                        happyImage.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                       }

                   }
               }).start();

                }

        });



        return view;

        // return inflater.inflate(R.layout.fragment_home, null);
    }
}
