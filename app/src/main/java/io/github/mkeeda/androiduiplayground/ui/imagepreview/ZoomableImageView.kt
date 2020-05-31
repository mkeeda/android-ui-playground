package io.github.mkeeda.androiduiplayground.ui.imagepreview

import android.content.Context
import android.graphics.Matrix
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.values
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

            zoom(scaleFactor)
            return true
        }
    }

    private val scaleDetector = ScaleGestureDetector(context, scaleListener)

    private fun zoom(scale: Float) {
        println("⭐: $scale")
        val values = imageMatrix.values()
        values[Matrix.MSCALE_X] *= scale
        values[Matrix.MSCALE_Y] *= scale
        imageMatrix.setValues(values)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // Let the ScaleGestureDetector inspect all events.
        scaleDetector.onTouchEvent(event)
        return true
    }
}
