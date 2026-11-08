package com.raj.tvlauncher

import android.app.Activity
import android.content.Intent
import android.content.pm.ResolveInfo
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : Activity() {

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var clockView: TextView
    private lateinit var dateView: TextView
    private val timeFmt = SimpleDateFormat("hh:mm a", Locale.getDefault())
    private val dateFmt = SimpleDateFormat("EEEE, d MMMM", Locale.getDefault())

    private val ticker = object : Runnable {
        override fun run() {
            val now = Date()
            clockView.text = timeFmt.format(now)
            dateView.text = dateFmt.format(now)
            handler.postDelayed(this, 10000)
        }
    }

    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(Intent.ACTION_MAIN)...
