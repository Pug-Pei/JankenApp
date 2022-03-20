package co.websarva.wings.android.jankenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.websarva.wings.android.jankenapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    val gu = 0
    val choki = 1
    val pa = 2
    private lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_result)
        val id = intent.getIntExtra("MY_HAND",0)

        val myHand: Int
        myHand = when(id){
            R.id.gu -> {
                binding.myHandImage.setImageResource(R.drawable.gu)
                gu
            }
            R.id.choki -> {
                binding.myHandImage.setImageResource(R.drawable.choki)
                choki
            }
            R.id.pa-> {binding.myHandImage.setImageResource(R.drawable.pa)
            pa
            }
            else -> gu
        }
        //　コンピューターの手を決める
        val comHand = (Math.random() * 3).toInt()
        when(comHand) {
            gu -> binding.comHandImage.setImageResource(R.drawable.com_gu)
            choki -> binding.myHandImage.setImageResource(R.drawable.com_choki)
            pa -> binding.myHandImage.setImageResource(R.drawable.com_pa)
        }

        //勝敗の判定をする
        val gameResult = (comHand - myHand + 3) % 3
        when(gameResult){
            0 -> binding.resultLabel.setText(R.string.result_draw) //引き分け
            1 -> binding.resultLabel.setText(R.string.result_win) //あなたの勝ち
            2 -> binding.resultLabel.setText(R.string.result_lose) //あなたの負け
        }
    }
}