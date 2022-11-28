package de.hshl.isd.poetryreader

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import de.hshl.isd.poetryreader.domain.PoetryReader
import de.hshl.isd.poetryreader.ui.theme.PoetryReaderTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoetryReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val tag = "MainContent"
    var resultText by remember { mutableStateOf("") }
    val poetryReader = PoetryReader()
    val scope = rememberCoroutineScope()

    fun success(value: String) {
        resultText = value
    }

    fun failure(error: Throwable) {
        Log.e(tag, error.localizedMessage!!)
    }

    Column {
        Button(onClick = {
            scope.launch {
                kotlin.runCatching {
                    poetryReader.giveMeSomePoetry()
                }
                    .onSuccess(::success)
                    .onFailure(::failure)
            }
        }) {
            Text("Start")
        }
        Text(resultText)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PoetryReaderTheme {
        MainContent()
    }
}