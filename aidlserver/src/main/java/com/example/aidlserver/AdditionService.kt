package com.example.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import android.util.Log

class AdditionService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    private val mBinder: IAdd.Stub = object : IAdd.Stub() {
        @Throws(RemoteException::class)
        override fun addNumbers(num1: Int, num2: Int): Int {
            return num1 + num2
        }

        @Throws(RemoteException::class)
        override fun getNumbers(num:Numbers):Int{
            Log.d("kajal", "getNumbers: "+num.num1+num.num2)
            return  num.num1+num.num2
        }
    }
}