package com.example.textviewkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.textviewkt.databinding.ActivitySub2Binding

class Sub2Activity : AppCompatActivity() {

    private var mBinding: ActivitySub2Binding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 저장된 데이터 로드
        loadData()
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)

        // 저장했던 KEY - KEY 값에 데이터가 없을 경우 대체 VALUE
        binding.etHello.setText(pref.getString("name", ""))
    }

    private fun saveData() {
        // 내부 경로에 pref 라는 이름으로 데이터를 저장하겠다
        val pref = getSharedPreferences("pref", 0)

        // 수정모드
        val edit = pref.edit()

        // KEY - VALUE
        edit.putString("name", binding.etHello.text.toString())

        // 저장
        edit.apply()
    }

    // 액티비티가 종료되는 시점에 호출
    override fun onDestroy() {
        super.onDestroy()

        // 데이터 저장
        saveData()
    }

}