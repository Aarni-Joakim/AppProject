package com.team1.hyteproject.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.team1.hyteproject.R;
import com.team1.hyteproject.ui.SharedViewModel;

import static android.app.Activity.RESULT_OK;
import static com.google.gson.reflect.TypeToken.get;

public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";
    private static final int PICK_IMAGE = 1;
    private SharedViewModel sharedViewModel;
    private CardView cardView;
    private ImageView profileImage;
    Uri imageUri;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        /*sharedViewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            // Update the UI.
        });*/
        final TextView textView = view.findViewById(R.id.text_notifications);
        profileImage = view.findViewById(R.id.Profile_Image);
        cardView = view.findViewById(R.id.CardView);

        Log.d(TAG, "onCreateView: start.");
        Log.d(TAG, "getting age:" + sharedViewModel);

        sharedViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGallery();
            }
        });
        return view;
    }

    //TODO

    protected void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    // TODO change to protected
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
                imageUri = data.getData();
                profileImage.setImageURI(imageUri);
            }
    }
}