package net.example.aidlserver

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Numbers(val num1: Int, val num2: Int) : Parcelable {

}
