package app.doggy.hapticssample.ui.component

import android.os.Build
import android.os.VibrationEffect
import android.os.VibrationEffect.Composition.PRIMITIVE_CLICK
import android.os.VibrationEffect.Composition.PRIMITIVE_QUICK_FALL
import android.os.VibrationEffect.Composition.PRIMITIVE_QUICK_RISE
import android.os.VibrationEffect.Composition.PRIMITIVE_SLOW_RISE
import android.os.VibrationEffect.Composition.PRIMITIVE_TICK
import android.os.Vibrator
import androidx.annotation.FloatRange
import androidx.annotation.IntDef
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@RequiresApi(Build.VERSION_CODES.R)
@Composable
internal fun CompositionPrimitivesButton(
  label: String,
  primitiveList: List<Primitive>,
  vibrator: Vibrator,
  modifier: Modifier = Modifier,
) {
  CustomButton(
    label = label,
    modifier = modifier,
  ) {
    vibrator.vibrate(
      VibrationEffect.startComposition().apply {
        primitiveList.forEach {
          addPrimitive(
            it.primitiveId,
            it.scale,
            it.delay,
          )
        }
      }.compose(),
    )
  }
}

@Stable
internal data class Primitive(
  @PrimitiveId val primitiveId: Int,
  @FloatRange(
    from = 0.0,
    to = 1.0,
  )
  val scale: Float = 1.0f,
  @IntRange(
    from = 0,
  )
  val delay: Int = 0,
)

@RequiresApi(Build.VERSION_CODES.R)
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
@IntDef(
  PRIMITIVE_CLICK,
  // PRIMITIVE_THUD,
  // PRIMITIVE_SPIN,
  PRIMITIVE_QUICK_RISE,
  PRIMITIVE_SLOW_RISE,
  PRIMITIVE_QUICK_FALL,
  PRIMITIVE_TICK,
  // PRIMITIVE_LOW_TICK,
)
private annotation class PrimitiveId

@RequiresApi(Build.VERSION_CODES.R)
@Preview
@Composable
private fun CompositionPrimitivesButtonPreview() {
  val context = LocalContext.current
  val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java)!!

  val primitiveList = listOf(
    Primitive(
      primitiveId = PRIMITIVE_SLOW_RISE,
      scale = 0.3f,
    ),
    Primitive(
      primitiveId = PRIMITIVE_QUICK_FALL,
      scale = 0.3f,
    ),
  )

  HapticsSampleTheme {
    Surface {
      CompositionPrimitivesButton(
        label = "Custom Haptic",
        primitiveList = primitiveList,
        vibrator = vibrator,
      )
    }
  }
}
