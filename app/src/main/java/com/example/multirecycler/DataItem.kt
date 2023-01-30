package com.example.multirecycler

sealed class DataItem{
    data class Item(val id:Int,val text:String)
    data class Header(val text:String)
}
