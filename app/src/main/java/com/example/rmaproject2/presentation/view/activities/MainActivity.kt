package com.example.rmaproject2.presentation.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.rmaproject2.R
import com.example.rmaproject2.data.models.note.NoteEntity
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.viewModels.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
   private val noteMV: NoteContract.ViewModel by viewModel<NotesViewModel>()//TODO SKLONI OVO KASNIJE

    override fun onCreate(savedInstanceState: Bundle?) {


        val noteEntity: NoteEntity= NoteEntity(
            0,
            "titlee",
            "content",
            "datee",
            true
        )

        noteMV.insert(noteEntity)
        noteMV.insert(noteEntity)


        val splashScreen: SplashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {

            val sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)
            val username = sharedPreferences.getString(LoginActivity.USERNAME, "")
            intent = if (username == "") {
                Intent(this, LoginActivity::class.java)
            } else {
                Intent(this, AppActivity::class.java)
            }
            startActivity(intent)
            finish()
            false
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}