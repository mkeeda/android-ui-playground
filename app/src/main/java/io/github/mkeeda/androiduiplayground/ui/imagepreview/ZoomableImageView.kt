package io.github.mkeeda.androiduiplayground.ui.imagepreview

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GestureDetectorCompat
import kotlin.math.max
import kotlin.math.min

class ZoomableImageView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attr, defStyleAttr) {
    private val scaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            // Don't let the object get too small or too large.
            val scaleFactor = max(0.1f, min(detector.scaleFactor, 5.0f))

            zoom(scaleFactor, detector.focusX, detector.focusY)
            return true
        }
    }

    private val scaleDetector = ScaleGestureDetector(context, scaleListener)

    private val panListener = object : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            drag(x = -distanceX, y = -distanceY)
            return true
        }
    }

    private val gestureDetector = GestureDetectorCompat(context, panListener)

    private fun zoom(scale: Float, focusX: Float, focusY: Float) {
        imageMatrix.postScale(scale, scale, focusX, focusY)
        invalidate()
    }

    private fun drag(x: Float, y: Float) {
        imageMatrix.postTranslate(x, y)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleDetector.onTouchEvent(event)
        scaleDetector.isQuickScaleEnabled = true
        gestureDetector.onTouchEvent(event)
        return true
    }
}
