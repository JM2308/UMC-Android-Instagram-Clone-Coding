package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupBirthdayBinding
import java.text.SimpleDateFormat
import java.util.*


class SignupBirthdayActivity: AppCompatActivity() {

    lateinit var binding: ActivitySignupBirthdayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBirthdayBinding.inflate(layoutInflater)

        setDatePicker()

        binding.selectNextBtn.setOnClickListener {
            val number = intent.getStringExtra("number")
            val email = intent.getStringExtra("email")
            val name = intent.getStringExtra("name")
            val pwd = intent.getStringExtra("pwd")

            val intent = Intent(this, SignupAgreeActivity::class.java)
            intent.putExtra("number", number)
            intent.putExtra("email", email)
            intent.putExtra("name", name)
            intent.putExtra("pwd", pwd)
            startActivity(intent)
        }

        setContentView(binding.root)
    }

    private fun setDatePicker() {
        var now = System.currentTimeMillis()
        var date = Date(now)
        var year = SimpleDateFormat("yyyy").format(date).toInt()
        var month = SimpleDateFormat("M").format(date).toInt() - 1
        var day = SimpleDateFormat("d").format(date).toInt()

        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()

        var maxDate = Calendar.getInstance()
        maxDate.set(year, month, day)

        binding.birthdayDatePicker.maxDate = maxDate.timeInMillis;

        binding.birthdayBirthdayDate.text = year.toString() + "년 " + (month + 1).toString() + "월 " + day.toString() + "일"

        binding.birthdayDatePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, dayOfMonth ->
            var age = getAge(year, (month + 1), dayOfMonth).toString()
            binding.birthdayBirthdayAge.text = age + "세"

            if (age.toInt() < 6) {
                binding.birthdayBirthdayAge.setTextColor(Color.parseColor("#ED0000"))
            } else if (age.toInt() >= 6) {
                binding.birthdayBirthdayAge.setTextColor(Color.BLACK)
            }
        }
    }

    private fun getAge(birthYear: Int, birthMonth: Int, birthDay: Int): Int {
        val current = Calendar.getInstance()
        val currentYear = current[Calendar.YEAR]
        val currentMonth = current[Calendar.MONTH] + 1
        val currentDay = current[Calendar.DAY_OF_MONTH]
        var age = currentYear - birthYear
        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay) age--
        return age
    }
}