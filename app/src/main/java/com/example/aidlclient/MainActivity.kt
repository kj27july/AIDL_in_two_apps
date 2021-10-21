package com.example.aidlclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aidlserver.IAdd
import com.example.aidlserver.Numbers

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var num1: EditText
    lateinit var num2: EditText
    lateinit var btnAdd: Button
    lateinit var total: TextView
    lateinit var addService: IAdd
    private val Tag = "kajal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        btnAdd = findViewById(R.id.btnAdd)
        total = findViewById(R.id.total)
        btnAdd.setOnClickListener(this)
        initConnection()
    }

    private fun initConnection() {

            val intent = Intent(IAdd::class.java.name)

            /*this is service name which has been declared in the server's manifest file in service's intent-filter*/
            intent.action = "service.calc"

            /*From 5.0 annonymous intent calls are suspended so replacing with server app's package name*/
            intent.setPackage("com.example.aidlserver")

            // binding to remote service
            bindService(intent, serviceConnection, BIND_AUTO_CREATE)

    }

    override fun onClick(p0: View?) {
        //total.text = (addService.addNumbers(num1.text.toString().toInt(), num2.text.toString().toInt())).toString()
        var nums= Numbers(num1.text.toString().toInt(),num2.text.toString().toInt())
        total.text = (addService.getNumbers(nums)).toString()
//        total.text=addService.getNumbers()
    }

    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
            Log.d(Tag, "Service Connected")
            addService = IAdd.Stub.asInterface(iBinder)
        }

        override fun onServiceDisconnected(componentName: ComponentName) {
            Log.d(Tag, "Service Disconnected")
            //addService = null
        }
    }

}