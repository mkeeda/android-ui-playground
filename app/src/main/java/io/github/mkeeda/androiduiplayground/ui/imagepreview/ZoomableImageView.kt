package io.github.mkeeda.androiduiplayground.ui.imagepreview

import android.content.Context
import android.graphics.Matrix
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.values

class ZoomableImageView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attr, defStyleAttr) {
    fun zoom(scale: Float) {
        val values = imageMatrix.values()
        values[Matrix.MSCALE_X] *= scale
        values[Matrix.MSCALE_Y] *= scale
        imageMatrix.setValues(values)
        invalidate()
    }
}
