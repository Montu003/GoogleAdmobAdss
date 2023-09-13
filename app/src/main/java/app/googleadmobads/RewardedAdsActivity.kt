package app.googleadmobads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.googleadmobads.databinding.ActivityRewardedAdsBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions

class RewardedAdsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRewardedAdsBinding
    private var rewardedAd: RewardedAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardedAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRewarded.setOnClickListener {

            val adRequest = AdRequest.Builder().build()
            RewardedAd.load(this,"ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    rewardedAd = null
                }

                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                    val options = ServerSideVerificationOptions.Builder()
                        .setCustomData("SAMPLE_CUSTOM_DATA_STRING")
                        .build()
                    rewardedAd!!.setServerSideVerificationOptions(options)

                    rewardedAd?.let { ad ->
                        ad.show(this@RewardedAdsActivity, OnUserEarnedRewardListener { rewardItem ->
                            val rewardAmount = rewardItem.amount
                            val rewardType = rewardItem.type
                        })
                    } ?: run {
                    }
                }
            })
        }



        binding.btnHome.setOnClickListener {
            startActivity(Intent(applicationContext , MainActivity::class.java))
        }
    }
}