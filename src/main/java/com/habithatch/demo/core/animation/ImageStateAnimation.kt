package com.habithatch.demo.core.animation

class ImageStateAnimation(
    image: ImageResource,
) : FrameStateAnimation(
        listOf(Frame(image, Long.MAX_VALUE)),
    )
