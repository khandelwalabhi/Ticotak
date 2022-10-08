import android.os.Bundle; 
import android.widget.EditText; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 

public class MainActivity extends AppCompatActivity { 

	TextView textView; 
	EditText editText1, editText2; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		// finding the UI elements 

		textView = findViewById(R.id.txtvw1); 
		editText1 = findViewById(R.id.editText1); 
		editText2 = findViewById(R.id.editText2); 
	} 
}
