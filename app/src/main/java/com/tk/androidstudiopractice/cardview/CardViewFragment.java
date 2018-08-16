package com.tk.androidstudiopractice.cardview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.tk.androidstudiopractice.R;

public class CardViewFragment extends Fragment{

    TextView textCardGreeting;
    EditText editCardGreeting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.from(getContext()).inflate(R.layout.fragment_cardview,container,false);

        textCardGreeting = root.findViewById(R.id.text_card_greeting);
        editCardGreeting = root.findViewById(R.id.edit_card_greeting);

        editCardGreeting.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    switch(keyEvent.getKeyCode()){
                        case KeyEvent.KEYCODE_ENTER:
                            textCardGreeting.setText(editCardGreeting.getText());
                            editCardGreeting.setText("");
                            return  true;
                    }
                }
                return false;
            }
        });

        return root;
    }
}
