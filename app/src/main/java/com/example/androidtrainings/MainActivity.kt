package com.example.androidtrainings

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidtrainings.state.UsingState
import com.example.androidtrainings.ui.theme.AndroidTrainingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val optionListener = listOf({ goToBaseCompose() },
            { goToLayoutCompose() },
            { goToStates()},
            )
        var menu = listOf("Base Compose", "Basic Layout Compose", "Using States")

        setContent {
            AndroidTrainingsTheme {
                MainMenuScreen(
                    menuOptions = menu,
                    optionListener = optionListener)
            }
        }
    }

    private fun goToStates() {
        startActivity(Intent(this, UsingState::class.java))
    }

    private fun goToLayoutCompose() {
        startActivity(Intent(this, LayoutsComposeActivity::class.java))
    }

    private fun goToBaseCompose() {
        startActivity(Intent(this, ComposeBasicsActivity::class.java))
    }
}

@Composable
fun MainMenuScreen(
    optionListener: List<() -> Unit>,
    menuOptions: List<String> = listOf("Base Compose", "Basic Layout Compose")
) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,

        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            for ((index, menu) in menuOptions.withIndex())
                MenuScreen(menu, onClickItemMenu = optionListener[index])
        }

    }
}

@Composable
fun MenuScreen(menuOption: String, modifier: Modifier = Modifier, onClickItemMenu: () -> Unit) {
    ElevatedButton(onClick = onClickItemMenu, modifier = modifier.fillMaxWidth()) {
        Text(
            text = menuOption,
            modifier = modifier,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MainMenuScreenPreview() {
    val optionListener = listOf({ }, { })
    AndroidTrainingsTheme {
        MainMenuScreen(optionListener = optionListener)
    }
}