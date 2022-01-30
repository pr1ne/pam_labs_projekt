package com.example.project4.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.project4.R
import kotlin.random.Random

data class ConsultationCard(
    @StringRes val dName: Int, @StringRes val address: Int,
    @StringRes val cab: Int, @DrawableRes val avatar: Int,
    val time: String, val date: String, val number: Int
)

object ConsultationCardList {
    var consultationList = mutableListOf<ConsultationCard>()
}

object CardList {
    fun addRandomConsultationCard() {
        var h = Random.nextInt(8, 22)
        var m = Random.nextInt(0, 53)
        var mo = Random.nextInt(2, 13)
        var d = Random.nextInt(1, 31)
        var hour = if (h < 10) "0$h" else "$h"
        var minute = if (m < 10) "0$m" else "$m"
        var day = if (d < 10) "0$d" else "$d"
        var month = if (mo < 10) "0$mo" else "$mo"

        var name = when (Random.nextInt(0, 5)) {
            0 -> R.string.Name1
            1 -> R.string.Name2
            2 -> R.string.Name3
            3 -> R.string.Name4
            else -> R.string.Name5
        }

        var addrs = when (Random.nextInt(0, 5)) {
            0 -> R.string.Addr1
            1 -> R.string.Addr2
            2 -> R.string.Addr3
            3 -> R.string.Addr4
            else -> R.string.Addr5
        }

        var cab = when (Random.nextInt(0, 5)) {
            0 -> R.string.Cab1
            1 -> R.string.Cab2
            2 -> R.string.Cab3
            3 -> R.string.Cab4
            else -> R.string.Cab5
        }

        var ava = when (Random.nextInt(0, 5)) {
            0 -> R.drawable.ava1
            1 -> R.drawable.ava2
            2 -> R.drawable.ava3
            3 -> R.drawable.ava4
            else -> R.drawable.ava5
        }

        ConsultationCardList.consultationList.add(ConsultationCard(
            name,
            addrs,
            cab,
            ava,
            "$hour:$minute",
            "$day.$month.2022",
            Random.nextInt(100000000,999999999)
        ))
    }

    fun loadConsultationCards(): MutableList<ConsultationCard> {
        return ConsultationCardList.consultationList
    }
}