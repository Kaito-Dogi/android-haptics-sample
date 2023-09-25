package app.doggy.hapticssample.ui.component

import android.os.Build
import android.os.VibrationEffect
import android.os.VibrationEffect.EFFECT_CLICK
import android.os.VibrationEffect.EFFECT_DOUBLE_CLICK
import android.os.VibrationEffect.EFFECT_HEAVY_CLICK
import android.os.VibrationEffect.EFFECT_TICK
import android.os.Vibrator
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
internal fun PredefinedEffectsButton(
  label: String,
  @EffectId effectId: Int,
  vibrator: Vibrator,
  modifier: Modifier = Modifier,
) {
  CustomButton(
    label = label,
    modifier = modifier,
  ) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      vibrator.vibrate(VibrationEffect.createPredefined(effectId))
    }
  }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
@IntDef(
  EFFECT_TICK,
  EFFECT_CLICK,
  EFFECT_HEAVY_CLICK,
  EFFECT_DOUBLE_CLICK,
)
private annotation class EffectId

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun PredefinedEffectsButtonPreview() {
  val context = LocalContext.current
  val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java)!!

  HapticsSampleTheme {
    Surface {
      PredefinedEffectsButton(
        label = "VIRTUAL_KEY",
        effectId = EFFECT_CLICK,
        vibrator = vibrator,
      )
    }
  }
}
