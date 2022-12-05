package de.hshl.isd.poetryreader

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.hshl.isd.poetryreader.domain.PoetryReader
import de.hshl.isd.poetryreader.ui.theme.PoetryReaderTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoetryReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val tag = "MainContent"
    var resultText by remember { mutableStateOf("I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)") }
    val poetryReader = PoetryReader()
    val scope = rememberCoroutineScope()

    fun success(value: String) {
        resultText = value
    }

    fun failure(error: Throwable) {
        Log.e(tag, error.localizedMessage!!)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.SpaceAround) {
        Text("Poetry Reader", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
//        Column(vertical = Alignment.Bottom) {
            Button(onClick = {
                scope.launch {
                    kotlin.runCatching {
                        poetryReader.giveMeSomePoetry()
                    }
                        .onSuccess(::success)
                        .onFailure(::failure)
                }
            }) {
                Text("Give me some poetry")
            }
            Text(resultText)
        //}

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PoetryReaderTheme {
        MainContent()
    }
}