package com.example.textviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.textviewkt.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private var mBinding: ActivityWebviewBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 웹뷰 내 자바스크립트 허용
        binding.webView.settings.javaScriptEnabled = true

        // 웹뷰 내 새창이 뜨지 않도록 방지
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()

        binding.webView.loadUrl("https://m.naver.com")
    }

    // 디바이스백 버튼 클릭 시 수행
    override fun onBackPressed() {
        // 웹뷰 내 뒤로갈 페이지가 존재
        if(binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            // 일반 백버튼 기능 실행
            super.onBackPressed()
        }
    }
}