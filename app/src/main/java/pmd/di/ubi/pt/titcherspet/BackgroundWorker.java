package pmd.di.ubi.pt.titcherspet;

/**
 * Created by Rabasco0 on 22/12/2016.
 */


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    public static int tipo;
    Context context;
    AlertDialog alertDialog;
    String res;
    BackgroundWorker (Context ctx, String res) {
        context = ctx;
        this.res = res;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.137.1/app/login.php";
        if(type.equals("login")) {
            try{
                String username = (String)params[1];
                String password = (String)params[2];

                String link=login_url;
                String data  = URLEncoder.encode("user_name", "UTF-8") + "=" +
                        URLEncoder.encode(username, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                        URLEncoder.encode(password, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(String result) {

        res=result;
        tipo=Integer.valueOf(res);

        System.out.println(res+"++++++"+result+"*******");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
