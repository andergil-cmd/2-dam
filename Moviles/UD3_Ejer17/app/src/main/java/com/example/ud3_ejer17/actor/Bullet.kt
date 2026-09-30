package com.example.ud3_ejer17.actor

import android.graphics.RectF


// The Bullet shot by the Player Ship
class Bullet(screenY: Int,
             private val speed: Float = 350f,
             heightModifier: Float = 20f) {

    // The coordinates of the rectangle that is the bullet itself
    val position = RectF()

    // Which way is it shooting
    val upwards = 0
    val downwards = 1

    // The way we are actually shooting (-1 is neither upwards nor downwards)
    private var heading = -1

    // The bullet size & height
    private val width = 2
    private var height = screenY / heightModifier

    // Is the bullet active?
    var isActive = false

    // We shot a bullet!!!
    fun shoot(startX: Float, startY: Float, direction: Int): Boolean {
        if (!isActive) {
            position.left = startX
            position.top = startY
            position.right = position.left + width
            position.bottom = position.top + height
            heading = direction
            isActive = true
        }
        return true
    }

    // Update position
    fun update(fps: Long) {
        if (heading == upwards) {
            position.top -= speed / fps
        } else {
            position.top += speed / fps
        }

        // Update the bottom position
        position.bottom = position.top + height
    }
}