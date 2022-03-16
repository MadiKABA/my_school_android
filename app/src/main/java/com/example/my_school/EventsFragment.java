package com.example.my_school;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class EventsFragment extends Fragment {

    private VideoView videoView;
    private MediaController mediaController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_events, container, false);
        String videoPath="android.resource://"+getActivity().getPackageName()+"/"+R.raw.isi;

        videoView=view.findViewById(R.id.videoView);
        mediaController=new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(videoPath);
        videoView.start();

        return view;
    }
}