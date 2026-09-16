package com.ae.design.foundation.interactions



/**
 * Min ripple duration — must match the ripple animation duration so the
 * press state is visually maintained until the ripple completes.
 */
public const val MIN_RIPPLE_DURATION_MS: Long = 225L

/**
 * Default minimum press duration — half the ripple duration,
 * long enough to be visible but shorter than the full animation.
 */
public const val DEFAULT_MIN_PRESS_DURATION_MS: Long = MIN_RIPPLE_DURATION_MS / 2
