package app.doggy.hapticssample.ui.component

import android.view.HapticFeedbackConstants.VIRTUAL_KEY
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@Composable
internal fun HapticFeedbackConstantsButton(
  label: String,
  feedBackConstant: Int,
  modifier: Modifier = Modifier,
) {
  CustomButton(
    label = label,
    modifier = modifier,
  ) { view ->
    view.performHapticFeedback(feedBackConstant)
  }
}

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
