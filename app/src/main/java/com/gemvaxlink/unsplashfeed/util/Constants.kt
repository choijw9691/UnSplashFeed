package com.gemvaxlink.unsplashfeed.util

object Constants {
    val CROSS_FADE_DURATION = 350

    enum class ListType{
        PHOTO,
        COLLECTION,
        USER,
        USER_PHOTOS
    }

    enum class ClickType{
        PROFILE,
        PHOTO
    }

    enum class Orientation{
        landscape,
        portrait,
        squarish
    }

    enum class FragmentType{
        MAIN,
        SEARCH
    }
}