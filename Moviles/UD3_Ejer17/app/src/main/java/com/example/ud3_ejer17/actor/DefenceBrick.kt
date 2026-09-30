package com.example.ud3_ejer17.actor

import android.graphics.RectF

// A defense wall for the player ship
class DefenceBrick(row: Int, column: Int, shelterNumber: Int, screenX: Int, screenY: Int) {

    // Is visible?
    var isVisible = true

    // The size of the invader
    private val width = screenX / 180
    private val height = screenY / 80

    // Sometimes a bullet slips through this padding.
    // Set padding to zero if this annoys you
    private val brickPadding = 1

    // The number of shelters
    private val shelterPadding = screenX / 12f
    private val startHeight = screenY - screenY / 10f * 2f

    // The coordinates of the rectangle that is the brick itself
    val position = RectF(column * width + brickPadding +
            shelterPadding * shelterNumber +
            shelterPadding + shelterPadding * shelterNumber,
        row * height + brickPadding + startHeight,
        column * width + width - brickPadding +
                shelterPadding * shelterNumber +
                shelterPadding + shelterPadding * shelterNumber,
        row * height + height - brickPadding + startHeight)
}