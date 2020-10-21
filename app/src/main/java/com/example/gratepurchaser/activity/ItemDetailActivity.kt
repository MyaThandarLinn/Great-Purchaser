package com.example.gratepurchaser.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gratepurchaser.R
import com.example.gratepurchaser.adapter.CustomDetailAdapter
import com.example.gratepurchaser.adapter.CustomMainAdapter
import com.example.gratepurchaser.adapter.ItemSliderAdapter
import com.example.gratepurchaser.libby.H
import com.example.gratepurchaser.model.AttributesModel
import com.example.gratepurchaser.model.HistoryModel
import com.example.gratepurchaser.model.PVIdModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.squareup.picasso.Picasso
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_custom_dialog_fragment.view.*
import kotlinx.android.synthetic.main.album_detail_activity.*
import org.json.JSONObject

class ItemDetailActivity : AppCompatActivity() {
    var items : List<PVIdModel> = listOf()
    var idArray : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_detail_activity)
        setSupportActionBar(toolbar)

        asyncFun("623691062113")  //for item image slide at ViewPager
        attributeFun("623691062113") // for attribute of item to mention items' spec
        idCheck("623691062113") // to check pid, vid from detail of each spec and get id back

        item_detail_cardView.setOnClickListener {
            //this is for bottom sheet dialog
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.activity_custom_dialog_fragment, null)

            val recyAdapter = CustomDetailAdapter(applicationContext, H.arrayPtrueName)
            view.detail_main_recycler.adapter = recyAdapter
            view.detail_main_recycler.layoutManager = GridLayoutManager(applicationContext,1, LinearLayoutManager.VERTICAL,false)

            view.txtPrice.text = "${H.item_d_price} Ks"
            Picasso.get().load(H.image_slider[0]).into(view.img)

            dialog.setContentView(view)
            dialog.show()
        }

        btn_item_search.setOnClickListener {
            onDataChange()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun onDataChange() {
        slide_progress.visibility = View.VISIBLE

        var searchId = search_url.text
        var sUrl = H.baseURL+searchId+H.tailURL

        val client = AsyncHttpClient()
        client.get(sUrl,object : JsonHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                super.onSuccess(statusCode, headers, response)
                var cnt = response!!.getJSONObject("Result").getJSONObject("Items").getJSONArray("Content").length()-1

                for (j in 0..cnt){
                    var sResponseId = (response.getJSONObject("Result").getJSONObject("Items").getJSONArray("Content").getJSONObject(j).getString("Id"))
                    H.searchId = sResponseId
                }
                asyncFun(H.searchId.toString())
                attributeFun(H.searchId.toString())
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                Log.d("hello","onDataChange error : $errorResponse")
            }
        })
    }

    fun asyncFun(id: String) {
        var imageArray: ArrayList<String> = ArrayList()
        var url = H.baseUrl + id

        val client = AsyncHttpClient()
        client.get(url,object : JsonHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                super.onSuccess(statusCode, headers, response)
                Log.d("hello", "-- on Success --")

                H.item_d_image =
                    response!!.getJSONObject("OtapiItemFullInfo").get("MainPictureUrl")
                        .toString()

                H.item_d_title =
                    response.getJSONObject("OtapiItemFullInfo").get("Title").toString()

                H.item_d_price =
                    response.getJSONObject("OtapiItemFullInfo").getJSONObject("Price")
                        .get("OriginalPrice").toString()

                var count =
                    response.getJSONObject("OtapiItemFullInfo").getJSONArray("Pictures")
                        .length() - 1

                //for image slider
                for (i in 0..count) {
                    imageArray.add(
                        i,
                        (response.getJSONObject("OtapiItemFullInfo")
                            .getJSONArray("Pictures").getJSONObject(i)
                            .getJSONObject("Medium").getString("Url"))
                    )
                }

                if (H.image_slider.isEmpty()) {
                    H.image_slider = imageArray

                    item_title.text = H.item_d_title
                    item_price.text = H.item_d_price
                    item_detail_image.adapter =
                        ItemSliderAdapter(applicationContext, H.image_slider)
                    slide_progress.visibility = View.GONE
                }

                else {
                    H.image_slider.clear()
                    H.image_slider = imageArray

                    item_title.text = H.item_d_title
                    item_price.text = H.item_d_price
                    item_detail_image.adapter =
                        ItemSliderAdapter(applicationContext, H.image_slider)
                    slide_progress.visibility = View.GONE
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                Log.d("hello","asyncFun error : $errorResponse")
            }
        })
    }

    fun attributeFun(attId: String) {
        var attUrl = H.baseUrl + attId
        var num = 0 //to add property name in array where configure is true
        var pCount = 0 //for all property name , configure is true
        var pNameArray: ArrayList<String> = ArrayList() //PropertyName
        var pTrueNameArray: ArrayList<String> = ArrayList() //PropertyName filter with configurator "true"
        var vidArray : ArrayList<String> = ArrayList() //Vid
        var vidTrueArray : ArrayList<String> = ArrayList() //Vid filter with configurator "true"
        var pidArray : ArrayList<String> = ArrayList() //Pid
        var pidTrueArray : ArrayList<String> = ArrayList() //Pid filter with configurator "true"
        var pvid : ArrayList<String> = ArrayList()

        val client = AsyncHttpClient()
        client.get(attUrl,object : JsonHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                super.onSuccess(statusCode, headers, response)
                var attribute =
                    response!!.getJSONObject("OtapiItemFullInfo").getJSONArray("Attributes")

                H.attributeList = Gson().fromJson(
                    attribute.toString(),
                    Array<AttributesModel>::class.java
                ).toList()

                // for property name array // need
                for (i in H.attributeList!!.indices) {
                    pNameArray.add(
                        i,
                        (response.getJSONObject("OtapiItemFullInfo")
                            .getJSONArray("Attributes").getJSONObject(i)
                            .getString("PropertyName"))
                    )

                    // get value for vid
                    vidArray.add(i,
                        (response.getJSONObject("OtapiItemFullInfo")
                            .getJSONArray("Attributes").getJSONObject(i)
                            .getString("Vid")))

                    // get value for pid
                    pidArray.add(i,
                        (response.getJSONObject("OtapiItemFullInfo")
                            .getJSONArray("Attributes").getJSONObject(i)
                            .getString("Pid")))


                    if (H.attributeList!![i].IsConfigurator == "true") {
                        pCount++

                        if (num < pCount) {
                            pTrueNameArray.add(num, pNameArray[i]) // for propertyName true value
                            vidTrueArray.add(num,vidArray[i])  //for vid true value
                            pidTrueArray.add(num,pidArray[i]) // for pid true value

                            num++
                        }
                    }
                }

                H.aryPid = pidArray
                H.aryVid = vidArray

                // this is for pid , vid plus array
                for(d in pidArray.indices){
                    pvid.add(pidArray[d].plus(vidArray[d]))
                }
                H.arypvid = pvid

                H.aryPTrueName = pTrueNameArray
                uniqueArray(pTrueNameArray)

                val attributeList = H.attributeList!!.filter { s-> s.IsConfigurator == "true" }
                val gpBy = attributeList.groupBy { it.PropertyName }.values

                H.arrayAttlist = attributeList
                H.arrayGpby = gpBy

                var value : ArrayList<String> = ArrayList()
                for(a in attributeList.indices){
                    value.add(attributeList[a].Value)
                }

                // need
                val valueZip = pTrueNameArray.zip(value)
                val valueGp = valueZip.groupBy ( {it.first},{it.second} ).toList()
                H.aryValue = valueGp

                //test -> group with value and id
                val gpOfvalueId = value.zip(pvid)
                H.aryGpOfValueId = gpOfvalueId

                val recyAdapter = CustomMainAdapter(applicationContext, H.arrayPtrueName)
                main_recycler.adapter = recyAdapter
                main_recycler.layoutManager = GridLayoutManager(applicationContext,1, LinearLayoutManager.VERTICAL,false)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                Log.e("error: ",errorResponse.toString())
            }
        })
    }

    // for unique array, sometime array index have one more time like {A, A, B, C, C, D, E}, so i wanna get {A,B,C,D,E}, use following
    private fun uniqueArray(pinyinArrayList: ArrayList<String>) {
        val uniquePinyinArrayList = ArrayList<String>()
        for(currentPinyin in pinyinArrayList){
            if (currentPinyin in uniquePinyinArrayList){
                // do nothing
            }
            else {
                uniquePinyinArrayList.add(currentPinyin)
            }
        }
        H.arrayPtrueName = uniquePinyinArrayList
    }

    // intent to use pid , vid check and get back id
    private fun idCheck(id : String){
        val client = AsyncHttpClient()
        var url = H.baseUrl + id

        client.get(url, object : JsonHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                super.onSuccess(statusCode, headers, response)
                var c =
                    response!!.getJSONObject("OtapiItemFullInfo").getJSONArray("ConfiguredItems")
                        .length() - 1

                for (i in 0..c) {

                    var confItems =
                        response.getJSONObject("OtapiItemFullInfo")
                            .getJSONArray("ConfiguredItems").getJSONObject(i)
                            .getString("Configurators")

                    var id = response.getJSONObject("OtapiItemFullInfo")
                        .getJSONArray("ConfiguredItems").getJSONObject(i)
                        .getString("Id")

                    idArray.add(id)

                    items = Gson().fromJson(
                        confItems.toString(),
                        Array<PVIdModel>::class.java
                    ).toList()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                Log.e("error : ",errorResponse.toString())
            }
        })
    }
}
