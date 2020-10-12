package com.example.gratepurchaser.model

class HistoryModel {
    var current: Int? = 0
    var subtract : Int? = 0
    var remain : Int? = 0
    var note : String? = null
    var date : String? = null

    constructor(current: Int?, subtract: Int?, remain: Int?, note: String?, date: String?) {
        this.current = current
        this.subtract = subtract
        this.remain = remain
        this.note = note
        this.date = date
    }
}