package com.example.uu119632.okhttptutorial;

import android.os.AsyncTask;
import android.widget.TextView;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * RequestMethod:Post
 */
class AsyncTaskOkHttpPost extends AsyncTask<Void, Void, String> {

    private TextView textView;

    AsyncTaskOkHttpPost(TextView textView) {
        super();
        this.textView = textView;
    }


    @Override
    protected String doInBackground(Void... voids) {
        String result = null;

        MediaType MIMEType= MediaType.parse("text/plain; charset=utf-8");
        RequestBody requestBody = RequestBody.create (MIMEType,"{}");


        // リクエストオブジェクトの生成
        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(requestBody)
                .build();

        // クライアントオブジェクトの生成
        OkHttpClient client = new OkHttpClient();

        // リクエストして結果を受け取る
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        textView.setText(result);
    }
}
