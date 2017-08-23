package com.example.uu119632.okhttptutorial;

import android.os.AsyncTask;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * RequestMethod:GET
 */
class AsyncTaskOkHttp extends AsyncTask<Void, Void, String> {

    private TextView textView;

    /**
     * コンストラクタ
     *
     * @param textView textView
     */
    AsyncTaskOkHttp(TextView textView) {
        super();
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result = null;
        // リクエストオブジェクトの生成
        Request request = new Request.Builder()
                .url("http://httpbin.org/headers")
                .get()
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

    /**
     * onBackgroundで取得した値をtextViewにセットする。
     *
     * @param result onBackgroundの結果
     */
    @Override
    protected void onPostExecute(String result) {
        textView.setText(result);
    }
}
