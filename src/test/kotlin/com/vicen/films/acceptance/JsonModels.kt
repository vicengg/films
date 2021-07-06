package com.vicen.films.acceptance

import java.text.MessageFormat

enum class JsonModels constructor(private val filePath: String) {

    STAFF_MEMBER("/models/staff-member-{0}.json");

    fun getFilePath(number: Int): String {
        return MessageFormat.format(this.filePath, number)
    }

}
