package com.example.connection

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://mysafeinfo.com/api/data?list=presidents&format=json"


        AsyncTaskHandleJson().execute(url)
    }

    inner class AsyncTaskHandleJson :AsyncTask<String,String,String>()
    {
        override fun doInBackground(vararg url: String?): String {
              var text : String
              val connection = URL(url[0]).openConnection() as HttpURLConnection

              try {
                  connection.connect()
                  text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
              }finally {
                     connection.disconnect()

              }
            return text
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            handleJson(result)
        }

    }

    private fun handleJson(jsonString: String?) {
         val jsonArray = JSONArray(jsonString)
         val list = ArrayList<PresidentData>()
         var x= 0;

        while(x <jsonArray.length())
        {
            val jsonObject = jsonArray.getJSONObject(x)

            list.add(
                PresidentData(
                jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("politic"),
                    jsonObject.getString("time")
            )
            )
            x++
        }
             val adapter = ListAdapter(this,list)
              president_list.adapter
    }
}
