package com.example.textviewkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.textviewkt.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null

    // 매번 null 체크 할 필요 없이, 편의성을 위해 바인딩 변수 재선언
    private val binding get() = mBinding!!

    // 앱 최초 실행됐을 때 수행
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 기존 setContentView 제거
        // setContentView(R.layout.activity_main) // xml 화면 뷰 연결
        // textView2.setText("gggg")

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시함
        setContentView(binding.root)





        binding.btnSendMsg.setOnClickListener {
            Toast.makeText(this@MainActivity, "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show()
            binding.ivProfile.setImageResource(R.drawable.android2)
        }

        binding.btnGetText.setOnClickListener {
            // et_id에 입력되어 있는 값을 가지고와 tv_result에 뿌려줌
            var resultText = binding.etId.text.toString()
            binding.tvResult.setText(resultText)
        }

        binding.btnA.setOnClickListener {
            // 다음 화면으로 이동하기 위한 Intent 객체 생성
            val intent = Intent(this, SubActivity::class.java)

            // 전달할 값은 intent에 넣기
            intent.putExtra("msg", binding.tvResult.text.toString())

            // intent에 저장된 액티비티로 이동
            startActivity(intent)

            // finish()
        }

        binding.btnB.setOnClickListener {
            // 다음 화면으로 이동하기 위한 Intent 객체 생성
            val intent = Intent(this, Sub2Activity::class.java)

            // intent에 저장된 액티비티로 이동
            startActivity(intent)

            // finish()
        }

        binding.gowebview.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnRecycle.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }



        /* 네비게이션 */

        binding.btnNavi.setOnClickListener {
            // START = LEFT, END = RIGHT
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }

        // 네이게이션 메뉴 아이템에 클릭 속성 부여
        binding.naviView.setNavigationItemSelectedListener(this)
    }

    override fun onDestroy() {
        // binding class 인스턴스 참조를 정리해주어야 함
        mBinding = null
        super.onDestroy()
    }

    // 네비게이션 아이템 클릭 시, 수행
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()
        }

        // 네비게이션 뷰 닫기
        binding.layoutDrawer.closeDrawers()
        return false
    }

    // 디바이스백 버튼 클릭 시 수행
    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.layoutDrawer.closeDrawers()
        } else {
            // 일반 백버튼 기능 실행
            super.onBackPressed()
        }
    }
}