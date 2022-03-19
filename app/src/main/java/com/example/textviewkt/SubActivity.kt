package com.example.textviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.textviewkt.databinding.ActivityMainBinding
import com.example.textviewkt.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private var mBinding: ActivitySubBinding? = null
    private val binding get() = mBinding!!

    var UserList = arrayListOf<User>(
        User(R.drawable.android2, "김영주", "30", "하이하잉"),
        User(R.drawable.android2, "김영주1", "31", "하이하잉1"),
        User(R.drawable.android2, "김영주2", "32", "하이하잉2"),
        User(R.drawable.android2, "김영주3", "33", "하이하잉3"),
        User(R.drawable.android2, "김영주4", "34", "하이하잉4")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("msg")) {
            binding.tvGetMsg.setText(intent.getStringExtra("msg"))
        }

        // ListView
        /*val item = arrayOf("MONDAY", "TUESDAY", "WEDNESDAY")
        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)*/

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }
}