package com.example.latihan_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihan_recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactList = arrayListOf(
            Contact(R.drawable.robert, "Robert", "Selamat pagi, semangat kerjanya ya", "07:00"),
            Contact(R.drawable.nick, "Nick", "Mari makan siang bersama", "12:00"),
            Contact(R.drawable.pak_rt, "Pak RT", "Ini kegiatan lingkungan RT minggu ini", "16:00"),
            Contact(R.drawable.panda, "Panda", "Waktunya tidur, jangan ganggu", "20:00"),
            Contact(R.drawable.robert, "Robert", "Selamat pagi, semangat kerjanya ya", "07:00"),
            Contact(R.drawable.nick, "Nick", "Mari makan siang bersama", "12:00"),
            Contact(R.drawable.pak_rt, "Pak RT", "Ini kegiatan lingkungan RT minggu ini", "16:00"),
            Contact(R.drawable.panda, "Panda", "Waktunya tidur, jangan ganggu", "20:00")
        )

        val adapter = ContactAdapter()
        val layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

        adapter.submitData(contactList)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}