package app.googleadmobads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.googleadmobads.databinding.ActivityNativeTemplateAdsBinding
import app.googleadmobads.nativeads.NativeTemplateStyle
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class NativeTemplateAdsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNativeTemplateAdsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeTemplateAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Native Template Ads

        MobileAds.initialize(this)
        val adLoader = AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
            .forNativeAd { nativeAd ->
                val styles =
                    NativeTemplateStyle.Builder().build()
                val template = binding.templateAds
                template.setStyles(styles)
                template.setNativeAd(nativeAd)
            }
            .build()
        adLoader.loadAd(AdRequest.Builder().build())



        binding.btnHome.setOnClickListener {
            startActivity(Intent(applicationContext , MainActivity::class.java))
        }
    }
}