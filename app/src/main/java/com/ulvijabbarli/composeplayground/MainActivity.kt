package com.ulvijabbarli.composeplayground

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.ulvijabbarli.composeplayground.ui.ComposePlayGroundTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                AppScreen()
            }
        }
    }
}
