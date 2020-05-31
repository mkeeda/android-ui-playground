package io.github.mkeeda.androiduiplayground.ui.imagepreview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.widget.AppCompatImageView
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

    private fun zoom(scale: Float, focusX: Float, focusY: Float) {
        imageMatrix.postScale(scale, scale, focusX, focusY)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // Let the ScaleGestureDetector inspect all events.
        scaleDetector.onTouchEvent(event)
        return true
    }
}
