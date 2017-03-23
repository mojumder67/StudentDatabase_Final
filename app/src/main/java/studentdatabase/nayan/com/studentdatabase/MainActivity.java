package studentdatabase.nayan.com.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper mydb;

    EditText editText_Name, editText_Id, editText_MobileNumber, editText_Email;
    Button save_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);

        all_ini();
        all_onclick();

    }

    private void all_ini() {
        editText_Name = (EditText) findViewById(R.id.etName);
        editText_Id = (EditText) findViewById(R.id.etId);
        editText_MobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        editText_Email = (EditText) findViewById(R.id.etEmail);
        save_data = (Button) findViewById(R.id.btSave);

    }


    private void all_onclick() {
        save_data.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = editText_Name.getText().toString();
        String studentId = editText_Id.getText().toString();
        String mobile = editText_MobileNumber.getText().toString();
        String email = editText_Email.getText().toString();


        boolean result = mydb.insertData(name,studentId,mobile,email);
        if (result) {
            Toast.makeText(MainActivity.this, "Data Insert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Data Not Insert", Toast.LENGTH_SHORT).show();
        }

    }
}
