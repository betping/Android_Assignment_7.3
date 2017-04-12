package mr_auspicious.shivam_kr_shiv.com.sqlite2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

import mr_auspicious.shivam_kr_shiv.com.sqlite2.data.Employee;
import mr_auspicious.shivam_kr_shiv.com.sqlite2.data.EmployeeHelper;

public class MainActivity extends AppCompatActivity {

    EmployeeHelper db;

    List<Employee> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new EmployeeHelper(this); //refrencing the databse

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        byte[] byteArray = getBytes(bmp); //Converting bitmap to byte[]

        db.addEmployeeDetails(new Employee("Kumar",12,byteArray));

        data = db.getEmployeeDetails(); //getting the lists of data

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(data.get(0).getName()); //Setting the employee name

        TextView textView1 = (TextView) findViewById(R.id.textView6);
        textView1.setText(String.valueOf(data.get(0).getAge())); //Setting the employee age

        byte[] img_bytes = data.get(0).getImage();
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageBitmap(getImage(img_bytes)); //setting the employee image

    }

    // converts from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // converts from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

}
