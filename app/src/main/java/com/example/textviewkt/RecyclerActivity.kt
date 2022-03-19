package com.example.textviewkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textviewkt.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private var mBinding: ActivityRecyclerBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "김영두", 30, "뀨에이"),
            Profiles(R.drawable.woman, "김갸람", 35, "FE")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfilesAdapter(profileList)
    }

}