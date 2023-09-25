package app.doggy.hapticssample.ui.component

import android.annotation.SuppressLint
import android.os.Build
import android.os.VibrationEffect
import android.os.VibrationEffect.EFFECT_CLICK
import android.os.Vibrator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@Composable
internal fun PredefinedEffectsButton(
  vibrator: Vibrator,
  label: String,
  effectId: Int,
) {
  CustomButton(label = label) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      vibrator.vibrate(VibrationEffect.createPredefined(effectId))
    }
  }
}

@SuppressLint("InlinedApi")
@Preview
@Composable
private fun PredefinedEffectsButtonPreview() {
  val context = LocalContext.current
  val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java)!!

  HapticsSampleTheme {
    Surface {
      PredefinedEffectsButton(
        vibrator = vibrator,
        label = "VIRTUAL_KEY",
        effectId = EFFECT_CLICK,
      )
    }
  }
}