package app.googleadmobads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.googleadmobads.databinding.ActivityInterstitialAdsBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialAdsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInterstitialAdsBinding
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterstitialAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnInterstitial.setOnClickListener {
           val adRequest = AdRequest.Builder().build()
               InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
               object : InterstitialAdLoadCallback() {
                   override fun onAdFailedToLoad(adError: LoadAdError) {
                       mInterstitialAd = null
                   }

                   override fun onAdLoaded(interstitialAd: InterstitialAd) {
                       mInterstitialAd = interstitialAd
                       if (mInterstitialAd != null) {
                           mInterstitialAd?.show(this@InterstitialAdsActivity)
                       }
                   }
               })
       }


        binding.btnHome.setOnClickListener {
            startActivity(Intent(applicationContext , MainActivity::class.java))
        }
    }
}