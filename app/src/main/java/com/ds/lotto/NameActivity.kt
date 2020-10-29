package com.ds.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        // 번호 생성 버튼의 클릭이벤트 리스너 설정
        goButton.setOnClickListener {
            // 입력된 이름이 없으면 토스트 메세지 출력 후 리턴
            if (TextUtils.isEmpty(editText.text.toString())) {
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)

            /**
             * intent의 결과 데이터를 전달한다.
            int의 리스트를 전달하므로 putIntegerArrayListExtra를 사용한다.
            전다랗는 리스트는 이름의 해시코드로 생성한 로또번호
             */
            intent.putIntegerArrayListExtra(
                "result",
                ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString())
            ))

            // 입력받은 이름을 추가로 전달한다.
            intent.putExtra("name", editText.text.toString())

            // ResultAcitivity를 시작하는 Intent를 만들고 startAcitivity로 실행
            startActivity(intent)

        }

        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener{
            //액티비티 종료
            finish()
        }
    }
}