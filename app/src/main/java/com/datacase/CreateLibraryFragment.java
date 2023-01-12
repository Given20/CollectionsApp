package com.datacase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateLibraryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateLibraryFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    TextView LibraryName;
    TextView LibraryGoal;
    Button AddLibrary;
    RadioGroup radioGroup;

    public CreateLibraryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateLibraryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateLibraryFragment newInstance(String param1, String param2) {
        CreateLibraryFragment fragment = new CreateLibraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        view = inflater.inflate(R.layout.fragment_create_library, container, false);

        LibraryName = view.findViewById(R.id.etLibraryName);
        LibraryGoal = view.findViewById(R.id.etLibraryGoal);
        AddLibrary = view.findViewById(R.id.btnAddLibrary);
        radioGroup = view.findViewById(R.id.rdGroupLibraryType);

        AddLibrary.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(!TextUtils.isEmpty(LibraryName.getText()) && !TextUtils.isEmpty(LibraryGoal.getText()) && radioGroup.getCheckedRadioButtonId() != -1){

            createLibrary();

            Toast.makeText(view.getContext(), "Library created Successfully", Toast.LENGTH_SHORT).show();

            //Close Fragment
            Navigation.findNavController(view).navigate(R.id.navigate_to_libraryFragment_from_createLibrary);

        }
        else{

            Toast.makeText(view.getContext(), "Please complate all feilds", Toast.LENGTH_SHORT).show();
        }
    }

    private void createLibrary() {

    }

}