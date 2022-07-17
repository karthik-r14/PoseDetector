package com.karthikr.posedetection

import android.os.Bundle
import com.google.mlkit.vision.pose.PoseDetector
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions
import com.karthikr.posedetection.vision.posedetector.PoseDetectorProcessor
import com.karthikr.posedetection.helper.MLVideoHelperActivity

class MainActivity : MLVideoHelperActivity() {
    lateinit var poseDetector: PoseDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setProcessor() {
        val options = AccuratePoseDetectorOptions.Builder()
            .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
            .build()
        cameraSource?.setMachineLearningFrameProcessor(
            PoseDetectorProcessor(
                this,
                options,
                true,
                false,
                false,
                false,
                true
            )
        )
    }
}