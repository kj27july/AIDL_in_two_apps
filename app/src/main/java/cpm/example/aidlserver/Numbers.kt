package com.example.aidlserver

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Numbers(val num1: Int, val num2: Int) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readInt()
//    ) {
//    }
//
//    companion object : Parceler<Numbers> {
//
//        override fun Numbers.write(parcel: Parcel, flags: Int) {
//            parcel.writeInt(num1)
//            parcel.writeInt(num2)
//        }
//
//        override fun create(parcel: Parcel): Numbers {
//            return Numbers(parcel)
//        }
//    }
}
