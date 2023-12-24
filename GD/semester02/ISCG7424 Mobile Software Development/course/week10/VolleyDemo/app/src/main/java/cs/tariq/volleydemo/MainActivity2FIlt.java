package cs.tariq.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2FIlt extends AppCompatActivity {

    RequestQueue queue = null;
    public RequestQueue getRequestQueue(Context context)
    {
        Log.d("JSON", " getRequestQueue ");
        if(queue == null)
        {
            queue = Volley.newRequestQueue(this);
        }

        return queue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_filt);

        RequestQueue q = Volley.newRequestQueue(getApplicationContext());

        queue = getRequestQueue(getApplicationContext());

        final TextView output = (TextView)findViewById(R.id.txtJSON);

        final Button request  = (Button)findViewById(R.id.btnRequest);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("JSON", "Button Clicked ");

                String url ="https://api.geonet.org.nz/quake?MMI=1";

                JsonObjectRequest jsObjRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                StringBuilder localities = new StringBuilder();

                                try {
                                    JSONArray data = response.getJSONArray("features");

                                    for(int index = 0; index < data.length(); index++)
                                    {
                                        JSONObject quake = data.getJSONObject(index);

                                        JSONObject properties = quake.getJSONObject("properties");
                                        localities.append(properties.getString("locality")+"\n");
                                    }


                                } catch (JSONException e) {
                                    Log.e("JSON Error","Error in parsing");
                                    e.printStackTrace();
                                }


                                output.setText(localities.toString());

                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub

                            }
                        });
                // Add the request to the RequestQueue.
                queue.add(jsObjRequest);


            }
        });

    }
}