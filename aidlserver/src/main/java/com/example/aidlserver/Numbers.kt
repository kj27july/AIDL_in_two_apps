package com.example.aidlserver

import android.os.Parcel
import android.os.Parcelable

//// @Parcelize
data class Numbers(val num1: Int, val num2: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(num1)
        parcel.writeInt(num2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Numbers> {
        override fun createFromParcel(parcel: Parcel): Numbers {
            return Numbers(parcel)
        }

        override fun newArray(size: Int): Array<Numbers?> {
            return arrayOfNulls(size)
        }
    }
}