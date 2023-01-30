package com.example.multirecycler

object Database {

    const val TYPE_ITEM=0
    const val TYPE_HEADER=1

    fun getItem():ArrayList<Any>{
        val itemList= arrayListOf<Any>()
        itemList.add(DataItem.Header("Weeks"))
        itemList.add(DataItem.Item(1,"Sunday"))
        itemList.add(DataItem.Item(2,"Monday"))
        itemList.add(DataItem.Item(3,"Tuesday"))
        itemList.add(DataItem.Item(4,"Wednesday"))
        itemList.add(DataItem.Item(5,"Thurday"))
        itemList.add(DataItem.Item(6,"Friday"))
        itemList.add(DataItem.Item(7,"Satday"))

        itemList.add(DataItem.Header("Working Days"))
        itemList.add(DataItem.Item(1,"Monday"))
        itemList.add(DataItem.Item(1,"Tuesday"))
        itemList.add(DataItem.Item(1,"Wednesday"))
        itemList.add(DataItem.Item(1,"Thursday"))
        itemList.add(DataItem.Item(1,"Friday"))

        itemList.add(DataItem.Header("Non-WorkingDays"))
        itemList.add(DataItem.Item(1,"Saturday"))
        itemList.add(DataItem.Item(2,"Sunday"))

        return itemList
    }

}