package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

public class Event {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT-5")
    private Date date;
    @JsonProperty
    private Country winningCountry;
    @JsonProperty
    private Country losingCountry;
    @JsonProperty
    private int winningScore;
    @JsonProperty
    private int losingScore;
    @JsonProperty
    private EventType eventType;
    @JsonProperty
    private Country homeCountry;
    @JsonProperty
    private Country awayCountry;


    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Country getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(Country homeCountry) {
        this.homeCountry = homeCountry;
    }

    public Country getAwayCountry() {
        return awayCountry;
    }

    public void setAwayCountry(Country awayCountry) {
        this.awayCountry = awayCountry;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Country getLosingCountry() {
        return losingCountry;
    }

    public void setLosingCountry(Country losingCountry) {
        this.losingCountry = losingCountry;
    }

    public Country getWinningCountry() {
        return winningCountry;
    }

    public void setWinningCountry(Country winningCountry) {
        this.winningCountry = winningCountry;
    }

    public int getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    public int getLosingScore() {
        return losingScore;
    }

    public void setLosingScore(int losingScore) {
        this.losingScore = losingScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (getWinningScore() != event.getWinningScore()) return false;
        if (getLosingScore() != event.getLosingScore()) return false;
        if (!getDate().equals(event.getDate())) return false;
        if (getWinningCountry() != event.getWinningCountry()) return false;
        if (getLosingCountry() != event.getLosingCountry()) return false;
        if (getEventType() != event.getEventType()) return false;
        if (getHomeCountry() != event.getHomeCountry()) return false;
        return getAwayCountry() == event.getAwayCountry();

    }

    @Override
    public int hashCode() {
        int result = getDate().hashCode();
        result = 31 * result + getWinningCountry().hashCode();
        result = 31 * result + getLosingCountry().hashCode();
        result = 31 * result + getWinningScore();
        result = 31 * result + getLosingScore();
        result = 31 * result + getEventType().hashCode();
        result = 31 * result + getHomeCountry().hashCode();
        result = 31 * result + getAwayCountry().hashCode();
        return result;
    }
}
