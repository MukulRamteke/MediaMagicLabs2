package com.example.mediamagiclabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mediamagiclabs.Model.Loreum;
import com.example.mediamagiclabs.adapter.CustomAdapter;
import com.example.mediamagiclabs.adapter.LoreumAdapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button click;
    public static TextView textView;
    public static ImageView imageView;

public static ListView li;
    ArrayList<Loreum> loreums = new ArrayList<>();

//  public static RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//textView = findViewById(R.id.authorname);
//    recyclerView = findViewById(R.id.recyclerView);

        li  = findViewById(R.id.l1);
//        imageView = findViewById(R.id.imageView);

click = (Button) findViewById(R.id.button);
//    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//



        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
   		.cacheInMemory(true).resetViewBeforeLoading(true)
                .cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
           .defaultDisplayImageOptions(defaultOptions)
           .build();
        ImageLoader.getInstance().init(config);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper helper = new Helper();
                helper.execute();
            }
        });

    }

//
  @Override
    protected void onResume() {
        super.onResume();




  }










    public class Helper extends AsyncTask<Void,Void,Void> {


        LoreumAdapter loreumAdapter;
//
//        public static  String imageName;
//        static String stream = null;
        String data = "";
        String singleParsed = "";
        String dataParsed = "";
        ArrayList<Loreum> loreums = new ArrayList<>();
        public Helper() {

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://picsum.photos/list");
                //URL url = new URL("https://picsum.photos/300/300?image=1");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = "";
                    while ((line = reader.readLine()) != null)
//                    sb.append(line);
//                stream  = sb.toString();
//                httpURLConnection.disconnect();
                        data = data + line;



//
//                    JSONObject object = new JSONObject("data");
//                    JSONArray cars = new JSONArray(data);
//
//
//
//                    for (int i =0 ; i < cars.length();i++)
//                    {
//                        JSONObject obj = (JSONObject) cars.get(i);
//                        Loreum loreum = new Loreum();
//                        loreum.setId(obj.getInt("id"));
//                        loreum.setAuthor(obj.getString("author"));
//                        loreum.setThumbnail(obj.getString("post_url"));
//                        loreums.add(loreum);
//
//                    }
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {

                 super.onPostExecute(aVoid);
            JSONArray items = null;
            try {
                items = new JSONArray(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0 ; i < items.length() ; i++)
            {
                JSONObject object = null;
                try {
                    object = (JSONObject) items.get(i);
                    Loreum loreum = new Loreum();
                    loreum.setId(object.getInt("id"));
                    loreum.setAuthor(object.getString("author"));
                    loreum.setThumbnail(object.getString("post_url"));
                    loreums.add(loreum);
                    singleParsed = "ID:" + object.get("id") + "\n" +
                            "Author:" + object.get("author") + "\n" +
                            "Filename" + object.get("filename") + "\n"


                    ;

                    dataParsed = dataParsed + singleParsed + "\n";


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //                    Loreum loreum = new Loreum(object.getInt("id"),object.getString("author"),object.getString("filename"));
//                    loreums.add(loreum);

//                    imageName = object.getString("post_url");


            }



//            MainActivity.textView.setText(dataParsed);

            CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.recylerview_item_product_grid,loreums);
li.setAdapter(adapter);

        }

    }

}
