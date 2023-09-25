package app.doggy.hapticssample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import app.doggy.hapticssample.ui.screen.CatalogScreen
import app.doggy.hapticssample.ui.theme.HapticsSampleTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HapticsSampleTheme {
        Surface(
          modifier = Modifier
            .fillMaxSize(),
        ) {
          CatalogScreen()
        }
      }
    }
  }
}
