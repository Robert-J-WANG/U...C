package cs.tariq.filehandlingdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    final String FILE_NAME = "test_file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveFile(View view)  {
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE|MODE_APPEND);
            //String str = "Welcome to file handling\n";
            String str = "this is another line\n";
            //int arr []={33,23,12};
            //int val = arr[10];
            fos.write(str.getBytes());
            fos.close();
            Toast.makeText(this,FILE_NAME +" save successfully",
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLine(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            Toast.makeText(this,FILE_NAME +" File is open ",
                    Toast.LENGTH_LONG).show();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String str = reader.readLine();
            Toast.makeText(this," first line: "+ str,
                    Toast.LENGTH_LONG).show();
        }catch(FileNotFoundException e){
            Toast.makeText(this,FILE_NAME +" unable to open ",
                    Toast.LENGTH_LONG).show();


        }catch(IOException e){
            Toast.makeText(this,FILE_NAME +" unable to read file ",
                    Toast.LENGTH_LONG).show();
        }

    }
    public void readFile(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            Toast.makeText(this,FILE_NAME +" File is open ",
                    Toast.LENGTH_LONG).show();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String str = "";
            String  line = "";
            while((line = reader.readLine()) !=null){
                str += line +"\n";

            }
            Toast.makeText(this, str,
                    Toast.LENGTH_LONG).show();
        }catch(FileNotFoundException e){
            Toast.makeText(this,FILE_NAME +" unable to open ",
                    Toast.LENGTH_LONG).show();


        }catch(IOException e){
            Toast.makeText(this,FILE_NAME +" unable to read file ",
                    Toast.LENGTH_LONG).show();
        }

    }
}