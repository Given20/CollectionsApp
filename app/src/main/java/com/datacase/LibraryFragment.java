package com.datacase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LibraryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LibraryFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View veiw;

    public LibraryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LibraryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LibraryFragment newInstance(String param1, String param2) {
        LibraryFragment fragment = new LibraryFragment();
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
        veiw = inflater.inflate(R.layout.fragment_library, container, false);

        FloatingActionButton createLibrary = veiw.findViewById(R.id.fbCreateLibrary);
        LinearLayout library = veiw.findViewById(R.id.library1);


        LinearLayout ParentLayout = veiw.findViewById(R.id.LibraryScrollLayout);

        library.setOnClickListener(this);
        createLibrary.setOnClickListener(this);

        LinearLayout.LayoutParams libraryMargin = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        libraryMargin.setMargins(0,15,0,0);

        LinearLayout library2 = new LinearLayout(veiw.getContext());
        library2.setOrientation(LinearLayout.HORIZONTAL);
        library2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        library2.setLayoutParams(libraryMargin);
        //library2.setId();

        LinearLayout.LayoutParams leftMargin = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftMargin.setMargins(40,0,0,0);

        ImageView libraryImage = new ImageView(veiw.getContext());
        libraryImage.setImageResource(R.drawable.books_icon);
        libraryImage.setLayoutParams(leftMargin);
        libraryImage.getLayoutParams().height = 60;
        libraryImage.getLayoutParams().width = 60;
        libraryImage.requestLayout();
        library2.addView(libraryImage);

        LinearLayout.LayoutParams MarginLibraryName = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        MarginLibraryName.setMargins(25,0,0,0);

        TextView LibraryName = new TextView(veiw.getContext());
        LibraryName.setLayoutParams(MarginLibraryName);
        LibraryName.setTextColor(ContextCompat.getColor(veiw.getContext(),R.color.white));
        LibraryName.setText("Books");
        LibraryName.setTextSize(20);
        LibraryName.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        LibraryName.getLayoutParams().width = 476;
        library2.addView(LibraryName);

        LinearLayout.LayoutParams RightMargin = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RightMargin.setMargins(0,0,28,0);

        TextView LibraryItemCount = new TextView(veiw.getContext());
        LibraryItemCount.setLayoutParams(RightMargin);
        LibraryItemCount.setTextColor(ContextCompat.getColor(veiw.getContext(),R.color.white));
        LibraryItemCount.setText("4/5");
        LibraryItemCount.setTextSize(20);
        LibraryItemCount.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        LibraryItemCount.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        LibraryItemCount.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        library2.addView(LibraryItemCount);


        ParentLayout.addView(library2);

        return veiw;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fbCreateLibrary:
                //openCreateLibraryFragment();
                Navigation.findNavController(veiw).navigate(R.id.navigate_to_createLibraryFragment);
                break;
            case R.id.library1:
                Navigation.findNavController(veiw).navigate(R.id.navigate_to_libraryItemFragment);
                break;
        }
    }

    private void openCreateLibraryFragment() {
        //toolbar.setTitle("Feed");
        //FragmentManager fragmentManager = getFragmentManager();
        //FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.setReorderingAllowed(true);
        //Fragment createLibrary = new CreateLibraryFragment();
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.replace(R.id.fragment, createLibrary);
        //transaction.addToBackStack(null);
        //transaction.commit();

        //Navigation.findNavController(R.id.fragment).navigate(R.id.navigate_to_createLibraryFragment);

    }
}