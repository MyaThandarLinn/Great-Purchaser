package com.example.gratepurchaser.libby

import com.example.gratepurchaser.model.AttributesModel
import java.util.*
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

        var item_test_image = ""

        // for attribute from url
        var arrayConfig : ArrayList<String> = ArrayList()
        var arrayTrue : ArrayList<String> = ArrayList()
        var arrayName : ArrayList<String> = ArrayList()
        var arrayValue : ArrayList<String> = ArrayList()
        var arrayPid : ArrayList<String> = ArrayList()
        var arrayVid : ArrayList<String> = ArrayList()

        //size
        var arrayPnameSize : ArrayList<String> = ArrayList()
        var arrayPsize : ArrayList<String> = ArrayList()
        var arrayVsize : ArrayList<String> = ArrayList()

        //config true
        var arrayPtrueName : ArrayList<String> = ArrayList()


        //test gmsh
        var attributeList: List<AttributesModel>? = null
        var attributeTrueList: ArrayList<String>? = null
        var modelList : ArrayList<AttributesModel>?= null

        var arrayPairlist : List<Pair<String, AttributesModel>>? = null
        var arrayAttlist : List<AttributesModel>? =null
        var arrayFirstList : List<Pair<String, AttributesModel>>? = null
//        var arrayGpby : Map<String, List<AttributesModel>>? = null
        var arrayGpby : Collection<List<AttributesModel>>? = null

        var aryValue : List<Pair<String, List<String>>> = ArrayList()
        var resultList : List<String> = listOf()

        var keyValue : String = ""


        var aryPid : ArrayList<String> = ArrayList()
        var aryVid : ArrayList<String> = ArrayList()
        var arypvid : ArrayList<String> = ArrayList()
        var aryPVid : List<Pair<String,String>>? = null
        var aryitem : List<Pair<String,String>>? = null
        var chkPVid : ArrayList<String> = ArrayList()
        var chkValue : List<String> = listOf()

        //for group of name and id [(body color, 16272077996777722), (body color, 16272077996777723),
        var aryNameId : List<Pair<String,String>>? = null

    }
}