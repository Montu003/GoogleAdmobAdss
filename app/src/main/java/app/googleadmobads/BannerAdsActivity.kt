package app.googleadmobads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.googleadmobads.databinding.ActivityBannerAdsBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class BannerAdsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBannerAdsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Banner Ads
        MobileAds.initialize(this) {}
        binding.adView.loadAd(AdRequest.Builder().build())




        binding.btnHome.setOnClickListener {
            startActivity(Intent(applicationContext , MainActivity::class.java))
        }

    }
}