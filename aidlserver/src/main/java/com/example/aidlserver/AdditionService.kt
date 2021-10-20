package com.example.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException

class AdditionService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    private val mBinder: IAdd.Stub = object : IAdd.Stub() {
        @Throws(RemoteException::class)
        override fun addNumbers(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }
}