package com.example.gratepurchaser.libby

import com.example.gratepurchaser.model.AttributesModel
import kotlin.collections.ArrayList

class H {
    companion object {
        var login_phone = ""
        var login_pass = ""

        const val baseUrl = "http://otapi.net/service-json/GetItemFullInfo?instanceKey=opendemo&language=en&itemId="
        const val baseURL = "http://otapi.net/service-json/SearchItemsFrame?instanceKey=opendemo&language=en&xmlParameters=%3CSearchItemsParameters%3E%3CProvider%3ETaobao%3C%2fProvider%3E%3CItemTitle%3E"
        const val tailURL = "%3C%2fItemTitle%3E%3C%2fSearchItemsParameters%3E&framePosition=0&frameSize=1"

        var searchId = ""
        // for ItemDetailActivity
        var item_d_album_title = ""
        var item_d_album_image = ""
        var item_d_album_id = ""

        // data come from G and set it in ItemDetail// for picture from url
        var item_d_image = ""
        var item_d_title = ""
        var item_d_price = ""

        var image_slider : ArrayList<String> = ArrayList()


        //config true
        var arrayPtrueName : ArrayList<String> = ArrayList()


        //test gmsh
        var attributeList: List<AttributesModel>? = null

        var arrayAttlist : List<AttributesModel>? =null
        var arrayGpby : Collection<List<AttributesModel>>? = null

        var aryValue : List<Pair<String, List<String>>> = ArrayList()
        var resultList : List<String> = listOf()

        var keyValue : String = ""

        var aryPid : ArrayList<String> = ArrayList()  // for Pid with conf "true"
        var aryVid : ArrayList<String> = ArrayList() // for Vid with conf "true"
        var arypvid : ArrayList<String> = ArrayList()
        var chkValue : List<String> = listOf()

        var aryPTrueName : ArrayList<String> = ArrayList()
        var aryGpOfValueId : List<Pair<String,String>>? = null

        // array of id for testing
        var aryTestId : ArrayList<String> = ArrayList()
        var aryTestName : ArrayList<String> = ArrayList()
        var text : String? = "Please select specs" //for text change when i click a cell of recycler

        //
        val first  = ArrayList<String>()
        var uFirst = ArrayList<String>()
        val uSecond = ArrayList<String>()


    }
}