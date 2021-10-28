package com.mrredondo.psp_playground.ut02.exercise1.data

class MockApiClient : ApiClient {
    override fun getUser(userId: Int): UserApiModel? {
        return UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es")
    }

    override fun getUsers(): List<UserApiModel> {
        return mutableListOf(
            UserApiModel(
                1,
                "Usuario 1",
                "Usuario1",
                "user@email.es"
            ),
            UserApiModel(
                2,
                "Usuario 2",
                "Usuario2",
                "user@email.es"
            ),
            UserApiModel(
                3,
                "Usuario 3",
                "Usuario3",
                "user@email.es"
            ),
            UserApiModel(
                4,
                "Usuario 4",
                "Usuario4",
                "user@email.es"
            ),
        )
    }
}

