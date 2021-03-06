package com.team1.hyteproject.ui.profile;

import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.team1.hyteproject.R;
import com.team1.hyteproject.program.Credentials;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.google.gson.reflect.TypeToken.get;

/**
 * Displays user info, including a picture selectable from devices memory
 * Login data is (currently) saved in shared preferences and loaded to be displayed here
 */
public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";
    private static final String CREDS = "CredentialsDB";
    private static final int PICK_IMAGE = 1;
    private SharedViewModel sharedViewModel;
    private Credentials credentials;
    private CardView cardView;
    private TextView name;
    private TextView email;
    private TextView age;
    private ImageView profileImage;
    Uri imageUri;

    private ArrayList users;
    private ArrayList usernames;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        /*sharedViewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            // Update the UI.
        });*/
        final TextView textView = view.findViewById(R.id.profileNameTextView);
        profileImage = view.findViewById(R.id.profile_image);
        cardView = view.findViewById(R.id.cardView);

        name = view.findViewById(R.id.profileNameTextView);
        email = view.findViewById(R.id.profileEmailTextView);
        age = view.findViewById(R.id.profileAgeTextView);

        users = SaveLoad.getInstance().loadUserList(getActivity(), "user");
        usernames = SaveLoad.getInstance().loadUsernameList(getActivity(), "usernames");

        Log.d(TAG, "onCreateView: start.");

        Log.d(TAG, "users is empty: " + users.isEmpty());
        Log.d(TAG, "index 0: " + users.get(0));


        /*sharedViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "addExercise clicked.");
                openGallery();
            }
        });

        return view;
    }

    //TODO

    /**
     * Uses an intent to open the phones gallery and allows for picture selection
     * code based on (add link)
     */
    protected void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    // TODO change to protected

    /**
     * overrides default onActivityResult to check if picture selection from gallery has succeeded
     * sets the selected picture as profile image if resultCode is OK.
     * sets retrieved imageUri data as profileImage
     * @param requestCode checks the result to see if image selection has "succeeded"
     * @param resultCode identifies the intent returned to
     * @param data to be set in imageUri Universal resource identifier
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
                imageUri = data.getData();
                profileImage.setImageURI(imageUri);
            }
    }
}