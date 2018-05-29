package cl.magnet.mobileappsexample;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;

public class AddFormFragment extends Fragment {
    private FormViewModel mFormViewModel;

    public AddFormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_form, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mFormViewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        final EditText newFormName = (EditText) view.findViewById(R.id.add_form_name_et);
        final EditText newFormDate = (EditText) view.findViewById(R.id.add_form_date_et);
        Button createFormButton = (Button) view.findViewById(R.id.add_form_button);

        createFormButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*Guardar Variables name y date*/
                    String formName = newFormName.getText().toString();
                    String formDate = newFormDate.getText().toString();
                /*random java*/
                    Random random = new Random(System.currentTimeMillis());
                    int intRandom = random.nextInt(1000);
                /*form form = new form*/
                    Form form = new Form(intRandom, formName, formDate);
                /*lista form vacia, luego insertar form*/
                    List<Form> forms = new ArrayList<Form>();
                    forms.add(form);
                    mFormViewModel.insert((List<Form>) forms);


                }
        });



    }
}
