package leonreimann.example.lotto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText editTextLottozahl1;
    EditText editTextLottozahl2;
    EditText editTextLottozahl3;
    EditText editTextLottozahl4;
    EditText editTextLottozahl5;
    EditText editTextLottozahl6;

    List<EditText> listOfEditTextElements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//public void

        editTextLottozahl1 = findViewById(R.id.editTextLottozahl1);
        editTextLottozahl1.addTextChangedListener(new MyTextWatcher());

        editTextLottozahl2 = findViewById(R.id.editTextLottozahl2);
        editTextLottozahl2.addTextChangedListener(new MyTextWatcher());

        editTextLottozahl3 = findViewById(R.id.editTextLottozahl3);
        editTextLottozahl3.addTextChangedListener(new MyTextWatcher());

        editTextLottozahl4 = findViewById(R.id.editTextLottozahl4);
        editTextLottozahl4.addTextChangedListener(new MyTextWatcher());

        editTextLottozahl5 = findViewById(R.id.editTextLottozahl5);
        editTextLottozahl5.addTextChangedListener(new MyTextWatcher());

        editTextLottozahl6 = findViewById(R.id.editTextLottozahl6);
        editTextLottozahl6.addTextChangedListener(new MyTextWatcher());

        listOfEditTextElements = new ArrayList<>();
        listOfEditTextElements.add(editTextLottozahl1);
        listOfEditTextElements.add(editTextLottozahl2);
        listOfEditTextElements.add(editTextLottozahl3);
        listOfEditTextElements.add(editTextLottozahl4);
        listOfEditTextElements.add(editTextLottozahl5);
        listOfEditTextElements.add(editTextLottozahl6);

       }

       //onClick
        public void onClick(View view) {

            //get LottoNumbers from Text Fields and
            //call BruteForece method
            find6from49(getNumbersFromTextFields(listOfEditTextElements));

        }

        public List<Integer> getNumbersFromTextFields(List<EditText> listOfEditTextElements ) {
            List<Integer> lottoNumbers = new ArrayList<>();
            for (EditText elem: listOfEditTextElements) {
                lottoNumbers.add(Integer.valueOf(elem.getText().toString()));
            }
            return lottoNumbers;
        }

       //logik
       public void find6from49(List<Integer> numbers) {
           List<Integer> lottoSearch = new ArrayList<Integer>();
           lottoSearch.add(1);
           lottoSearch.add(1);
           lottoSearch.add(1);
           lottoSearch.add(1);
           lottoSearch.add(1);
           lottoSearch.add(1);
            for (int digit = 5; digit >= 0; digit--) {
               for (int i = 1; i < 50; i++) {
                   System.out.println("Gewinnzahlen: " + Arrays.toString(numbers.toArray()));
                   System.out.println("Versuch: " + i + " an Stelle: " + digit );
                   System.out.println("Versuchszahlen: " + Arrays.toString(lottoSearch.toArray()));

                    if(lottoSearch.get(digit).equals(numbers.get(digit))) {
                        System.out.println("FOUND DIGIT on : " + digit);
                        System.out.println("Versuchszahlen: " + Arrays.toString(lottoSearch.toArray()));
                        break;
                    }
                    lottoSearch.set(digit,new Integer(i));
               }
                if(lottoSearch.equals(numbers)) {
                    System.out.println("FOUND FINALLY: ");
                    System.out.println("Gewinnzahlen: " + Arrays.toString(numbers.toArray()));
                    System.out.println("Versuchszahlen: " + Arrays.toString(lottoSearch.toArray()));
                }
           }
       }
}

