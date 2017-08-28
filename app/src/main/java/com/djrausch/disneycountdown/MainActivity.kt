package com.djrausch.disneycountdown

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.PeriodType
import org.joda.time.format.PeriodFormatter
import org.joda.time.format.PeriodFormatterBuilder
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION



/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class MainActivity : AppCompatActivity() {

    private var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.activity_main)
        val handler = Handler();

        val endDate = DateTime(2017, 11, 25, 0, 0)

        runnable = Runnable {
            val period: Period = Period(DateTime.now(), endDate, PeriodType.dayTime())
            val periodFormatter: PeriodFormatter = PeriodFormatterBuilder()
                    .appendDays().appendSuffix(" day ", " days ")
                    .appendHours().appendSuffix(" hour ", " hours ")
                    .appendMinutes().appendSuffix(" minute ", " minutes ")
                    .appendSeconds().appendSuffix(" second ", " seconds ")
                    .toFormatter()
            fullscreen_content.text = periodFormatter.print(period)
            handler.postDelayed(runnable, 1000);
        }

        handler.post(runnable);

    }
}
