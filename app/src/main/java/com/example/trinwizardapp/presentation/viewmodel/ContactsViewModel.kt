package com.example.trinwizardapp.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trinwizardapp.R
import com.example.trinwizardapp.data.model.ContactObj
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.*
import java.lang.reflect.Type


class ContactsViewModel constructor(
   val context:Context
) : ViewModel() {
    private val getContactListLiveData = MutableLiveData<ArrayList<ContactObj>>()

    fun getContactListLiveData() = getContactListLiveData

    fun getContactList() {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.data)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        inputStream.use { inputStream ->
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        val jsonString: String = writer.toString()
        val gson = Gson()
        val listType: Type = object : TypeToken<List<ContactObj?>?>() {}.type
        getContactListLiveData.value= gson.fromJson(jsonString, listType)
    }
}