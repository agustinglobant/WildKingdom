package co.mobilemakers.wildkingdom;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {
    public static final String  DESCRIPTION = "DESC";
    public static final String  HABITAT = "HAB";
    public static final String  IMAGE_ID = "IMAGE_ID";
    public static final String  NAME = "NAME";
    TextView mTextViewDesc, mTextViewHab, mTextViewName;
    ImageView mImageView;
    Button mButton;

    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_animal, container, false);
        findWidgets(rootView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().
                        beginTransaction().
                        replace(R.id.fragment_container, new AnimalsListFragment()).
                        addToBackStack(null).
                        commit();
            }
        });
        getAndSetData();
        return rootView;
    }

    private void getAndSetData() {
        mTextViewName.setText(getArguments().getString(NAME).toString());
        mTextViewDesc.setText(mTextViewDesc.getText()+" "+getArguments().getString(DESCRIPTION).toString());
        mTextViewHab.setText(mTextViewHab.getText()+" "+getArguments().getString(HABITAT).toString());
        mImageView.setImageResource(getArguments().getInt(IMAGE_ID));
    }

    private void findWidgets(View rootView) {
        mTextViewDesc = (TextView) rootView.findViewById(R.id.text_description);
        mTextViewHab = (TextView) rootView.findViewById(R.id.text_habitat);
        mTextViewName = (TextView) rootView.findViewById(R.id.text_name);
        mImageView = (ImageView) rootView.findViewById(R.id.imageView);
        mButton = (Button) rootView.findViewById(R.id.button_home);
    }


}
