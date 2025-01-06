package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://random-d.uk/api/1.jpg"),
        User("002", "Paul", "https://random-d.uk/api/2.jpg"),
        User("003", "Phil", "https://random-d.uk/api/3.jpg"),
        User("004", "Guillaume", "https://random-d.uk/api/4.jpg"),
        User("005", "Francis", "https://random-d.uk/api/5.jpg"),
        User("006", "George", "https://random-d.uk/api/6.jpg"),
        User("007", "Louis", "https://random-d.uk/api/7.jpg"),
        User("008", "Mateo", "https://random-d.uk/api/8.jpg"),
        User("009", "April", "https://random-d.uk/api/9.jpg"),
        User("010", "Louise", "https://random-d.uk/api/10.jpg"),
        User("011", "Elodie", "https://random-d.uk/api/11.jpg"),
        User("012", "Helene", "https://random-d.uk/api/12.jpg"),
        User("013", "Fanny", "https://random-d.uk/api/13.jpg"),
        User("014", "Laura", "https://random-d.uk/api/14.jpg"),
        User("015", "Gertrude", "https://random-d.uk/api/15.jpg"),
        User("016", "Chloé", "https://random-d.uk/api/16.jpg"),
        User("017", "April", "https://random-d.uk/api/17.jpg"),
        User("018", "Marie", "https://random-d.uk/api/18.jpg"),
        User("019", "Henri", "https://random-d.uk/api/19.jpg"),
        User("020", "Rémi", "https://random-d.uk/api/20.jpg")
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://random-d.uk/api/21.jpg"),
        User("022", "Geoffrey", "https://random-d.uk/api/22.jpg"),
        User("023", "Simon", "https://random-d.uk/api/23.jpg"),
        User("024", "André", "https://random-d.uk/api/24.jpg"),
        User("025", "Leopold", "https://random-d.uk/api/25.jpg")
    )
}