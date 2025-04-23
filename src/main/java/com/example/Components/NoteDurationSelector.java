package com.example.Components;

public class NoteDurationSelector {
    
    public enum NoteDuration {
        WHOLE("\uE1D2", 4.0f),      
        HALF("\uE1D3", 2.0f),       
        QUARTER("\uE1D5", 1.0f),   
        EIGHTH("\uE1D7", 0.50f);   

        private final String unicode;
        private final float duration;

        NoteDuration(String unicode, float duration) {
            this.unicode = unicode;
            this.duration = duration;
        }

        public String getUnicode() {
            return unicode;
        }

        public float getDuration() {
            return duration;
        }
    }

    private final NoteDuration[] durations = NoteDuration.values();
    private int currentIndex = 0;

    public NoteDuration getCurrent() {
        return durations[currentIndex];
    }

    public void next() {
        currentIndex = (currentIndex + 1) % durations.length;
    }

    public void previous() {
        currentIndex = (currentIndex - 1 + durations.length) % durations.length;
    }
    public void next(float minDuration) {
        do {
            currentIndex = (currentIndex + 1) % durations.length;
        } while (durations[currentIndex].getDuration() > minDuration );
    }

    public void previous(float minDuration) {
        do {
            currentIndex = (currentIndex - 1 + durations.length) % durations.length;
        } while (durations[currentIndex].getDuration() > minDuration);
    }
}

