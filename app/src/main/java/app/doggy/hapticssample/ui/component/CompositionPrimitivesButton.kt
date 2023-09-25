package app.doggy.hapticssample.ui.component

import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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

internal data class Primitive(
  val primitiveId: Int,
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
@Preview
@Composable
private fun CompositionPrimitivesButtonPreview() {
  val context = LocalContext.current
  val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java)!!

  val primitiveList = listOf(
    Primitive(
      primitiveId = VibrationEffect.Composition.PRIMITIVE_SLOW_RISE,
      scale = 0.3f,
    ),
    Primitive(
      primitiveId = VibrationEffect.Composition.PRIMITIVE_QUICK_FALL,
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
