package com.example.aidlserver

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class Person : Parcelable {
    var name: String? = null
    var age = 0

    constructor(name: String?, age: Int) {
        this.name = name
        this.age = age
    }

    constructor() {}
    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        age = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

//    companion object {
//        val CREATOR: Creator<Person> = object : Creator<Person> {
//            override fun createFromParcel(`in`: Parcel): Person? {
//                return Person(`in`)
//            }
//
//            override fun newArray(size: Int): Array<Person?> {
//                return arrayOfNulls(size)
//            }
//        }
//    }


    companion object CREATOR : Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}