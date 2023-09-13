package app.googleadmobads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.googleadmobads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBanner.setOnClickListener {
            startActivity(Intent(applicationContext , BannerAdsActivity::class.java))
        }

        binding.btnInterstitial.setOnClickListener {
            startActivity(Intent(applicationContext , InterstitialAdsActivity::class.java))
        }

        binding.btnNativeTemplete.setOnClickListener {
            startActivity(Intent(applicationContext , NativeTemplateAdsActivity::class.java))
        }

        binding.btnRewarded.setOnClickListener {
            startActivity(Intent(applicationContext , RewardedAdsActivity::class.java))
        }
    }
}