package app.doggy.hapticssample.ui.screen

import android.os.Build
import android.os.VibrationEffect.Composition.PRIMITIVE_CLICK
import android.os.VibrationEffect.Composition.PRIMITIVE_QUICK_FALL
import android.os.VibrationEffect.Composition.PRIMITIVE_QUICK_RISE
import android.os.VibrationEffect.Composition.PRIMITIVE_SLOW_RISE
import android.os.VibrationEffect.Composition.PRIMITIVE_TICK
import android.os.VibrationEffect.EFFECT_CLICK
import android.os.VibrationEffect.EFFECT_DOUBLE_CLICK
import android.os.VibrationEffect.EFFECT_HEAVY_CLICK
import android.os.VibrationEffect.EFFECT_TICK
import android.os.Vibrator
import android.view.HapticFeedbackConstants.CLOCK_TICK
import android.view.HapticFeedbackConstants.CONFIRM
import android.view.HapticFeedbackConstants.CONTEXT_CLICK
import android.view.HapticFeedbackConstants.GESTURE_END
import android.view.HapticFeedbackConstants.GESTURE_START
import android.view.HapticFeedbackConstants.KEYBOARD_PRESS
import android.view.HapticFeedbackConstants.KEYBOARD_RELEASE
import android.view.HapticFeedbackConstants.KEYBOARD_TAP
import android.view.HapticFeedbackConstants.LONG_PRESS
import android.view.HapticFeedbackConstants.REJECT
import android.view.HapticFeedbackConstants.TEXT_HANDLE_MOVE
import android.view.HapticFeedbackConstants.VIRTUAL_KEY
import android.view.HapticFeedbackConstants.VIRTUAL_KEY_RELEASE
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import app.doggy.hapticssample.ui.component.CompositionPrimitivesButton
import app.doggy.hapticssample.ui.component.HapticFeedbackConstantsButton
import app.doggy.hapticssample.ui.component.Header
import app.doggy.hapticssample.ui.component.PredefinedEffectsButton
import app.doggy.hapticssample.ui.component.Primitive
import app.doggy.hapticssample.ui.theme.Dimen
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun CatalogScreen(
  modifier: Modifier = Modifier,
) {
  val context = LocalContext.current
  val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java)!!

  LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(Dimen.M),
  ) {
    stickyHeader {
      Header(title = "HapticFeedbackConstants")
    }
    items(feedBackConstantList) {
      Spacer(modifier = Modifier.height(Dimen.S))
      HapticFeedbackConstantsButton(
        label = it.first,
        feedBackConstant = it.second,
      )
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
      items(feedBackConstantOMR1List) {
        Spacer(modifier = Modifier.height(Dimen.S))
        HapticFeedbackConstantsButton(
          label = it.first,
          feedBackConstant = it.second,
        )
      }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      items(feedbackConstantRList) {
        Spacer(modifier = Modifier.height(Dimen.S))
        HapticFeedbackConstantsButton(
          label = it.first,
          feedBackConstant = it.second,
        )
      }
    }

    stickyHeader {
      Spacer(modifier = Modifier.height(Dimen.M))
      Header(title = "Predefined VibrationEffect")
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      items(effectIdList) {
        Spacer(modifier = Modifier.height(Dimen.S))
        PredefinedEffectsButton(
          label = it.first,
          effectId = it.second,
          vibrator = vibrator,
        )
      }
    }

    stickyHeader {
      Spacer(modifier = Modifier.height(Dimen.M))
      Header(title = "VibrationEffect composition")
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      item {
        Spacer(modifier = Modifier.height(Dimen.S))
        CompositionPrimitivesButton(
          label = "Custom Haptic Effect",
          primitiveList = primitiveIdList,
          vibrator = vibrator,
        )
      }
    }
  }
}

private val feedBackConstantList = listOf(
  "CONTEXT_CLICK" to CONTEXT_CLICK,
  "CLOCK_TICK" to CLOCK_TICK,
  "VIRTUAL_KEY" to VIRTUAL_KEY,
  "KEYBOARD_TAP" to KEYBOARD_TAP,
  "LONG_PRESS" to LONG_PRESS,
)

@RequiresApi(Build.VERSION_CODES.O_MR1)
private val feedBackConstantOMR1List = listOf(
  "KEYBOARD_PRESS" to KEYBOARD_PRESS,
  "KEYBOARD_RELEASE" to KEYBOARD_RELEASE,
  "TEXT_HANDLE_MOVE" to TEXT_HANDLE_MOVE,
  "VIRTUAL_KEY_RELEASE" to VIRTUAL_KEY_RELEASE,
)

@RequiresApi(Build.VERSION_CODES.R)
private val feedbackConstantRList = listOf(
  "CONFIRM" to CONFIRM,
  "REJECT" to REJECT,
  "GESTURE_START" to GESTURE_START,
  "GESTURE_END" to GESTURE_END,
)

@RequiresApi(Build.VERSION_CODES.Q)
private val effectIdList = listOf(
  "EFFECT_TICK" to EFFECT_TICK,
  "EFFECT_CLICK" to EFFECT_CLICK,
  "EFFECT_HEAVY_CLICK" to EFFECT_HEAVY_CLICK,
  "EFFECT_DOUBLE_CLICK" to EFFECT_DOUBLE_CLICK,
)

@RequiresApi(Build.VERSION_CODES.R)
private val primitiveIdList = listOf(
  PRIMITIVE_CLICK,
  PRIMITIVE_QUICK_RISE,
  PRIMITIVE_SLOW_RISE,
  PRIMITIVE_QUICK_FALL,
  PRIMITIVE_TICK,
).mapIndexed { index, primitiveId ->
  Primitive(
    primitiveId = primitiveId,
    delay = index * 100,
  )
}

@Preview
@Composable
private fun CatalogScreenPreview() {
  HapticsSampleTheme {
    Surface {
      CatalogScreen()
    }
  }
}
