package com.ulvijabbarli.composeplayground

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

//            AppScreen(
//                clickedRecipe = {
//                    Toast.makeText(this,"Recipe -> $it",Toast.LENGTH_SHORT).show()
//                },
//                clickedStory = {
//                    Toast.makeText(this,"Story -> $it",Toast.LENGTH_SHORT).show()
//                },
//                clickedTag = {
//                    Toast.makeText(this,"Tag -> $it",Toast.LENGTH_SHORT).show()
//

