package cs.tariq.filehandlingdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity2 extends AppCompatActivity {
    final String FILE_NAME = "my_notes.txt";
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et = findViewById(R.id.txt);
        tv = findViewById(R.id.tv_notes);
    }

    public void saveFile(View view) {
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE|MODE_APPEND);
            //String str = "Welcome to file handling\n";

            String str = et.getText().toString()+"\n";
            Note n = new Note(str);

            fos.write(n.getNote().getBytes());
            fos.close();
            Toast.makeText(this,FILE_NAME +" note saved successfully",
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readNote(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            Toast.makeText(this,FILE_NAME +" File is open ",
                    Toast.LENGTH_LONG).show();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String str = reader.readLine();
            tv.setText(str);
        }catch(FileNotFoundException e){
            Toast.makeText(this,FILE_NAME +" unable to open ",
                    Toast.LENGTH_LONG).show();


        }catch(IOException e){
            Toast.makeText(this,FILE_NAME +" unable to read file ",
                    Toast.LENGTH_LONG).show();
        }

    }
    public void readNotes(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            Toast.makeText(this,FILE_NAME +" File is open ",
                    Toast.LENGTH_LONG).show();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String str = "";
            String  line = "";
            while((line = reader.readLine()) !=null){
                str += line +"\n\n";

            }
            tv.setText(str);
            tv.setMovementMethod( new ScrollingMovementMethod());
        }catch(FileNotFoundException e){
            Toast.makeText(this,FILE_NAME +" unable to open ",
                    Toast.LENGTH_LONG).show();


        }catch(IOException e){
            Toast.makeText(this,FILE_NAME +" unable to read file ",
                    Toast.LENGTH_LONG).show();
        }

    }
}