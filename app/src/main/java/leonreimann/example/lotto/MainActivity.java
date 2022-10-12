package leonreimann.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText editTextLottozahl1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//public void

        editTextLottozahl1 = findViewById(R.id.editTextLottozahl1);
        editTextLottozahl1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("after Changes");
            }
        });
       }

       //onClick
        public void onClick(View view) {

            String zahl1String =editTextLottozahl1.getText().toString();

            int ersteZahl = Integer.valueOf(zahl1String);

            List lottoNumbers = new ArrayList<Integer>();
            lottoNumbers.add(ersteZahl);

            //rufe die BruteForce Methode auf
            find6from49(lottoNumbers);

        }

       //logik
       public void find6from49(List numbers) {


       }
}

