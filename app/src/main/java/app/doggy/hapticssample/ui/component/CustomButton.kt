package app.doggy.hapticssample.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

@Composable
internal fun CustomButton(
  label: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {},
) {
  Button(
    onClick = onClick,
    modifier = modifier
      .fillMaxWidth(),
  ) {
    Text(text = label)
  }
}

@Preview
@Composable
private fun CustomButtonPreview() {
  HapticsSampleTheme {
    Surface {
      CustomButton(
        label = "Preview",
        onClick = {},
      )
    }
  }
}
