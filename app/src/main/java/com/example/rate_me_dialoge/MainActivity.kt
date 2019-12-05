package com.example.rate_me_dialoge

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import hotchemi.android.rate.AppRate

class MainActivity : AppCompatActivity() {

    //    implementation'com.github.hotchemi:android-rate:1.0.1'

    // add in build.gradle

    // all the strings of this dialog will work automaticaly.
    // if i want to write my own string in rate dialog then go to strings.xml


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // intall days means if we install app then after one day rate me dialog will apear.
        // launch time means usne app ko khola ho
        // default value of install day is 10
        // also default value of launch time is 10
        // remindinterval time default value is 1
        // remindinterval if user say remind later then it will again show after 2 days.
        // if all condition that we have applied true then rate dialoge will be shown

        AppRate.with(this)
                .setInstallDays(1)
                .setLaunchTimes(2)
                .setRemindInterval(2)
                .monitor()

      // when we click on rate me button then it will go to playstore and directly
        // in our app folder but currently this app not on playstore
        // so it will move toward playstore but not did anything becaues app not on playstore.
        // showRateDialogIfMeetsCondition check if all condition true then he will show rate dialog.
        // it will show 3 button
        // rate me : if i click on it then he directly move toward playstore.
        // no thanks : it will not show again rate me dialog.
        // remind later: now at this condition RemindInterval will be check
        // as i set the 2 days so it will again show after 2 days .


        AppRate.showRateDialogIfMeetsConditions(this)

        // clearAgreeShowDialog will work when we click on nothanks.

        AppRate.with(this).clearAgreeShowDialog()

        // if i want to show dialog when our app will install then

        AppRate.with(this).shouldShowRateDialog()


    }
}
