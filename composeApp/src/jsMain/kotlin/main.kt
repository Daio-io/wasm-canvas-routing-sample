import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.CanvasBasedWindow
import app.softwork.routingcompose.BrowserRouter
import app.softwork.routingcompose.Router
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow("Wasm Routing") {
            BrowserRouter(initPath = "/") {
                val router = Router.current
                route("/") {
                    Screen("Screen 1") {
                        router.navigate("/screen2")
                    }
                }
                route("/screen2") {
                    Screen("Screen 2", Color.Blue) {
                        router.navigate("/screen3")
                    }
                }
                route("/screen3") {
                    Screen("Screen 3", Color.Red) {
                        router.navigate("/")
                    }
                }
            }
        }
    }
}

@Composable
fun Screen(
    name: String,
    color: Color = Color.White,
    navigate: () -> Unit
) {
    Column(
        Modifier.fillMaxSize().background(color),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(name, fontSize = 54.sp)
        Button({
            navigate()
        }) {
            Text("Navigate!")
        }
    }
}
