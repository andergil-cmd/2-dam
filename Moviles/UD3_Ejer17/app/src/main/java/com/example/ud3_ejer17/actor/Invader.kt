package com.example.ud3_ejer17.actor

import android.content.Context
import android.graphics.Bitmap
import android.graphics.RectF
import java.util.*
import android.graphics.BitmapFactory
import com.example.ud3_ejer17.R
import androidx.core.graphics.scale

// An evil invader from another world!
class Invader(context: Context, row: Int, column: Int, screenX: Int, screenY: Int) {

    // The size of the invader
    var width = screenX / 35f
    private var height = screenY / 35f
    private val padding = screenX / 45

    // The coordinates of the rectangle that is the invader itself
    var position = RectF(
        column * (width + padding),
        100 + row * (width + padding / 4),
        column * (width + padding) + width,
        100 + row * (width + padding / 4) + height
    )

    // The speed in pixels per second
    private var speed = 40f

    // Which way is it moving
    private val left = 1
    private val right = 2

    // The way we are actually moving (Right by default)
    private var shipMoving = right

    // Is visible?
    var isVisible = true

    companion object {
        // The alien ship will be represented by a Bitmap
        lateinit var bitmap1: Bitmap
        lateinit var bitmap2: Bitmap

        // keep track of the number of instances
        // that are active
        var numberOfInvaders = 0
    }

    init {
        // Initialize the bitmaps
        bitmap1 = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.invader1
        )

        bitmap2 = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.invader2
        )

        // stretch the first bitmap to a size
        // appropriate for the screen resolution
        bitmap1 = bitmap1.scale((width.toInt()), (height.toInt()), false)

        // stretch the second bitmap as well
        bitmap2 = bitmap2.scale((width.toInt()), (height.toInt()), false)

        numberOfInvaders ++
    }

    // Update position
    fun update(fps: Long) {
        if (shipMoving == left) {
            position.left -= speed / fps
        }

        if (shipMoving == right) {
            position.left += speed / fps
        }

        position.right = position.left + width
    }

    // End of the lane! Move down and reverse direction!
    fun dropDownAndReverse(waveNumber: Int) {
        shipMoving = if (shipMoving == left) {
            right
        } else {
            left
        }

        position.top += height
        position.bottom += height

        // The later the wave, the more the invader speeds up
        speed *=  (1.1f + (waveNumber.toFloat() / 20))
    }

    // Consider to shoot to the player ship! (True or False)
    fun takeAim(playerShipX: Float, playerShipLength: Float, waves: Int) : Boolean {

        val randomGenerator = Random()

        // If near the player consider taking a shot
        if (playerShipX + playerShipLength > position.left &&
            playerShipX + playerShipLength < position.left + width ||
            playerShipX > position.left && playerShipX < position.left + width) {

            // The fewer invaders the more each invader shoots
            // The higher the wave the more the invader shoots
            val randomNumber = randomGenerator.nextInt((100 * numberOfInvaders) / waves)
            if (randomNumber == 0) {
                return true
            }
        }

        // If firing randomly (not near the player)
        val randomNumber = randomGenerator.nextInt(150 * numberOfInvaders)
        return randomNumber == 0
    }
}