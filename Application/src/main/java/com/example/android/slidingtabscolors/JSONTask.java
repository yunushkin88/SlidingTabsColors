package com.example.android.slidingtabscolors;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.common.logger.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONTask extends AsyncTask<String,String,String> {
    @Override
    protected String doInBackground(String... params) {

       // HttpURLConnection connection = null;
        //BufferedReader reader = null;
        try {

           // URL url = new URL(params[0]);
           // connection = (HttpURLConnection) url.openConnection();
          //  connection.connect();
          //  InputStream stream = connection.getInputStream();

            //reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = MainActivity.reader.readLine()) != null) {
                buffer.append(line);

            }

            String finalJSON = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJSON);
                JSONArray parentArray = parentObject.getJSONArray("cars");


            StringBuffer finalBufferedData = new StringBuffer();


               for (int i=0; i<parentArray.length(); i++) {
                   JSONObject finalObject = parentArray.getJSONObject(i);

                   String movieName = finalObject.getString("model");
                   int year = finalObject.getInt("year");
                   finalBufferedData.append(movieName +  "\n");
               }



                return finalBufferedData.toString();
                //return movieName;

            //return buffer.toString();


        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (JSONException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            /*if (connection != null) {
                connection.disconnect();
            }*/
            try {
                if (MainActivity.reader != null) {
                  MainActivity.reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

       // Log.e("TAG", s);
        MainActivity.string = s;
        Log.e("TAG", MainActivity.string);
    }



}
