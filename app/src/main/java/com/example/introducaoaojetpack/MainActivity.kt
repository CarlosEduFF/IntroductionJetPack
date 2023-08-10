package com.example.introducaoaojetpack

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introducaoaojetpack.ui.theme.DebugButtonCOlor
import com.example.introducaoaojetpack.ui.theme.ErrorDebugButtonCOlor
import com.example.introducaoaojetpack.ui.theme.InfoDebugButtonCOlor
import com.example.introducaoaojetpack.ui.theme.IntroducaoaoJetPackTheme
import com.example.introducaoaojetpack.ui.theme.WarningDebugButtonCOlor
import java.lang.RuntimeException

const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    IntroducaoaoJetPackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(name = "JetPack")
                ActionButton(
                    text = "Debug",
                    buttonColors = DebugButtonCOlor(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Log.d(TAG, "App: Clicou em DEBUG!")
                }
                ActionButton(
                    text = "Info",
                    buttonColors = InfoDebugButtonCOlor(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Log.i(TAG, "App: Clicou em Info!")
                }
                ActionButton(
                    text = "Warning",
                    buttonColors = WarningDebugButtonCOlor(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Log.w(TAG, "App: Clicou em Warning!")
                }
                ActionButton(
                    text = "Error",
                    buttonColors = ErrorDebugButtonCOlor(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    try {
                        throw RuntimeException("Clicou em Error!")
                    }catch (ex: Exception){
                        Log.e(TAG,"${ex.message}")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 200, heightDp = 300)
@Composable
fun AppPreview(){
    App()

}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
           ){
            Text(text = text)
        }
    }


@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppActionButton(){
    ActionButton(text = "Cadastrar"){

    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroducaoaoJetPackTheme {
        Greeting("Android")
    }
}