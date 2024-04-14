package cs.tariq.multiactivitiesprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.View;

public class ActivityImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
    }
    public void openURL(View view) {
        String url="http://Google.com";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);

    }

    public void openMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);

    }

    public void openMessageTxt(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("smsto:" + Uri.encode("029027429")));
        intent.putExtra("sms_body", "Your text message here....");
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Morning Alarm")
                .putExtra(AlarmClock.EXTRA_HOUR, 7)
                .putExtra(AlarmClock.EXTRA_MINUTES, 0);
        if (intent.resolveActivity(getPackageManager()) != null) {  startActivity(intent);
        }

    }

    public void addEvent(View view) {
        long time = System.currentTimeMillis()+1000*60*60*24*5;  Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, "My Appointment")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Unitec, Auckland")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, time)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, time+1000*60*30);
        if (intent.resolveActivity(getPackageManager()) != null) {  startActivity(intent);
        }


    }

    public void dialPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "021111999"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void openMap(View view) {
        Uri geoLocation = Uri.parse("geo:-36.8521257,  174.764455");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}