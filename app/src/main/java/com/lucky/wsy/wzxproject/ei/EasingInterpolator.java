package com.lucky.wsy.wzxproject.ei;

import android.animation.TimeInterpolator;
import android.support.annotation.NonNull;

/**
 * Created by wsy on 2018/3/5.
 */

public class EasingInterpolator implements TimeInterpolator {
    private final Ease ease;

    public EasingInterpolator(@NonNull Ease ease) {
        this.ease = ease;
    }

    @Override
    public float getInterpolation(float input) {
        return EasingProvider.get(this.ease, input);
    }

    public Ease getEase() {
        return ease;
    }
}
