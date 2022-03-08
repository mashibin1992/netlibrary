package com.example.netlibrary
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.net.module.BaseVIewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this)[BaseVIewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getArticles(1).observe(this) {
            Log.d("hahahhahahahah", "onCreate: $it")
            tv.text=it[0].chapterName

        }
        tv.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("open://app.test.com/game?appId=com.game.sid21&token=21token&extend=21extend&merchant=21merchant&agent=21agent"))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}