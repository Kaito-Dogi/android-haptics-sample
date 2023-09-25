package app.doggy.hapticssample.ui.component

import android.os.Build
import android.view.HapticFeedbackConstants.CLOCK_TICK
import android.view.HapticFeedbackConstants.CONFIRM
import android.view.HapticFeedbackConstants.CONTEXT_CLICK
import android.view.HapticFeedbackConstants.GESTURE_END
import android.view.HapticFeedbackConstants.GESTURE_START
import android.view.HapticFeedbackConstants.KEYBOARD_PRESS
import android.view.HapticFeedbackConstants.KEYBOARD_RELEASE
import android.view.HapticFeedbackConstants.LONG_PRESS
import android.view.HapticFeedbackConstants.REJECT
import android.view.HapticFeedbackConstants.TEXT_HANDLE_MOVE
import android.view.HapticFeedbackConstants.VIRTUAL_KEY
import android.view.HapticFeedbackConstants.VIRTUAL_KEY_RELEASE
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@Composable
internal fun HapticFeedbackConstantsButton(
  label: String,
  @FeedBackConstant feedBackConstant: Int,
  modifier: Modifier = Modifier,
) {
  CustomButton(
    label = label,
    modifier = modifier,
  ) { view ->
    view.performHapticFeedback(feedBackConstant)
  }
}

@RequiresApi(Build.VERSION_CODES.R)
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
@IntDef(
  CONTEXT_CLICK,
  CLOCK_TICK,
  VIRTUAL_KEY,
  // KEYBOARD_TAP, // KEYBOARD_PRESS と値が重複するためコメントアウト
  LONG_PRESS,
  KEYBOARD_PRESS, // 以下 API level 27 (O_MR1) 以上
  KEYBOARD_RELEASE,
  TEXT_HANDLE_MOVE,
  VIRTUAL_KEY_RELEASE,
  CONFIRM, // 以下 API level 30 (R) 以上
  REJECT,
  GESTURE_START,
  GESTURE_END,
)
private annotation class FeedBackConstant

@Preview
@Composable
private fun HapticFeedbackConstantsButtonPreview() {
  HapticsSampleTheme {
    Surface {
      HapticFeedbackConstantsButton(
        label = "VIRTUAL_KEY",
        feedBackConstant = VIRTUAL_KEY,
      )
    }
  }
}
